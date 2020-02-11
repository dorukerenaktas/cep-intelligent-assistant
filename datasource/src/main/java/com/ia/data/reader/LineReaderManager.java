package com.ia.data.reader;

import com.ia.data.producer.EventProducer;

public class LineReaderManager {
    private EventProducer producer;
    private LineReader pageViewLogReader;
    private LineReaderJob job;

    public LineReaderManager(EventProducer producer) {
        this.producer = producer;
        this.pageViewLogReader = new LineReader("/page-view-logs.txt");
    }

    public void start(int frequency) {
        this.job = new LineReaderJob(frequency, this.pageViewLogReader, this.producer);
        job.start();
    }

    public void pause() {
        this.job.Stop();
    }

    public void stop() {
        this.job.Stop();
        this.pageViewLogReader.close();
        this.pageViewLogReader = new LineReader("/page-view-logs.txt");
    }

    public boolean getState() {
        if (this.job != null) {
            return this.job.isRunning();
        }
        return false;
    }
}
