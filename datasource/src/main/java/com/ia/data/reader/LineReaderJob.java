package com.ia.data.reader;

import com.ia.data.producer.EventProducer;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

public class LineReaderJob extends Thread {
    private boolean isRunning = true;
    private int frequency;
    private LineReader lineReader;
    private EventProducer producer;

    public LineReaderJob(int frequency, LineReader lineReader, EventProducer producer) {
        this.frequency = frequency;
        this.lineReader = lineReader;
        this.producer = producer;
    }

    public void run() {
        String line = this.lineReader.readLine();
        while (isRunning && line != null) {
            line = line.replaceAll("^ +| +$|( )+", "$1");
            String[] attributes = line.split(" ");

            JSONObject json = new JSONObject();
            try {
                json.put("id", attributes[0]);
                json.put("user_id", attributes[1]);
                json.put("session_id", attributes[2]);
                json.put("even_day", attributes[3]);
                json.put("even_time", attributes[4]);
                json.put("url", attributes[5]);
                json.put("date", new Date().getTime());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                this.producer.send(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
            line = this.lineReader.readLine();

            try {
                sleep(this.frequency);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Stop() {
        this.isRunning = false;
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
