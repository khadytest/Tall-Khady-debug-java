package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;


public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filePathWrite;

    public WriteSymptomDataToFile(String filepath) {

        this.filePathWrite = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePathWrite));
            for (String symptomsWrite : symptoms.keySet()) {
                String symtomsAvecOccurence = symptomsWrite + " = " +symptoms.get(symptomsWrite);

                writer.write(symtomsAvecOccurence);
                writer.newLine();


            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
