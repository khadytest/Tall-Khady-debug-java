package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }



    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> map = new HashMap<>();
        for (String element : symptoms) {
            if (map.containsKey(element)) {
                int occurence = map.get(element);
                map.put(element, occurence+1);
            } else {
                map.put(element, 1);
            }
        }
        return map;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
       TreeMap<String, Integer> map = new TreeMap<>(symptoms);
       for (String element : symptoms.keySet()){
           map.put(element, symptoms.get(element));

       }

       return map;

    }


    public void writeSymptoms(Map<String, Integer> symptoms){

        this.writer.writeSymptoms(symptoms);
    }





    public static void main(String args[]) throws Exception {
        FileReader readerObj = new FileReader("Project02Eclipse/symptoms.txt");
        BufferedReader reader = new BufferedReader(readerObj);
        String line = reader.readLine();

        int i = 0;
        int headCount = 0;
        while (line != null) {
            i++;
            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headCount++;
                System.out.println("number of headaches: " + headCount);
            } else if (line.equals("rush")) {
                rashCount++;
            } else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();
        }

        FileWriter writer = new FileWriter("/home/khady/Tall-Khady-debug-java/result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
