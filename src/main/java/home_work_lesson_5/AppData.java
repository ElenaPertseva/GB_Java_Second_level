package home_work_lesson_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {

    }

    public AppData(String path) {
        load(path);
    }


    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    private void load(String path) {
        //read whole file
        String s = readFile(path);
        // split on lines
        String[] strings = s.split("\n");
        // split first line  to get  headers
        this.header = strings[0].split(";");
        //if lines  > 1  split lines to data
        if (strings.length > 0) {
            this.data = new int[strings.length -1][this.header.length];
            for (int i = 1; i < strings.length; i++) {
                String[] sInner = strings[i].split(";");
//                System.out.println(strings[i]);
                int[] inner = new int[sInner.length];
                for (int j = 0; j < sInner.length; j++){
                    inner[j] = Integer.parseInt(sInner[j]);
                }
                this.data[i-1] = inner;
            }
        }
    }

    private String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = null;
            while (reader.ready()) {
                sb.append(reader.readLine());
                sb.append('\n');
            }
            sb.deleteCharAt(sb.length() - 1);
//            System.out.println(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    boolean save(String path) {
        File file = new File(path);

        try {
            FileWriter writer = new FileWriter(file);
            //write headers
            writer.write(this.headerToString());
            writer.flush();
            //write data
            for (int[] datum : data) {
                writer.append("\n");
                writer.write(this.dataToString(datum));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String headerToString() {
        StringBuilder builder = new StringBuilder();
        for (String s : header) {
            builder.append(s);
            builder.append(';');
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private String dataToString(int[] ints) {
        StringBuilder builder = new StringBuilder();
        for (int i : ints) {
            builder.append(i);
            builder.append(';');
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int[] ints: data) {
            builder.append(Arrays.toString(ints));
        }
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + builder.toString() +
                '}';
    }
}


