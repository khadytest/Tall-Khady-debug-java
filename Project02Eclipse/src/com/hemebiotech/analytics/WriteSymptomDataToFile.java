package com.hemebiotech.analytics;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filepath;
    private Integer file2;

    public WriteSymptomDataToFile(String filepath, Integer file2) {
        this.filepath = filepath;
        this.file2 =file2;
    }


    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> result = new HashMap<>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader (new FileReader(filepath));
                String line = reader.readLine();
                Integer line2 = 0;

                while (line != null) {
                    result.put(line, line2);
                    line = reader.readLine();

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);




    }
}
