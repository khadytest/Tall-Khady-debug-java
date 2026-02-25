package com.hemebiotech.analytics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{

    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;

    }


    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

            try {
                BufferedWriter writer = new BufferedWriter (new FileWriter(filepath));
                for (String element : symptoms.keySet()){
                    String symptomOcurrence = element + symptoms.get(element);
                    writer.write(symptomOcurrence);
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
