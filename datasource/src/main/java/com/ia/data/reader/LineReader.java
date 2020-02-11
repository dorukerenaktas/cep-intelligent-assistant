package com.ia.data.reader;

import java.io.*;

public class LineReader {

    private BufferedReader reader;

    public LineReader(String path) {
        this.reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
    }

    public String readLine() {
        String line = null;
        try {
            line = this.reader.readLine();

            if (line == null) {
                this.reader.close();
            }

            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close() {
        try {
            this.reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
