package com.hemebiotech.analytics;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLIntegrityConstraintViolationException;
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

    public int addition(int a, int b){
        return a+b;
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

//    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
//        Map<String, Integer> mapSymtoms = new HashMap<>();
//        for (String elem : symptoms.keySet()){
//            Integer value = symptoms.get(elem);
//
//        }
//        return  mapSymtoms;
//
//    }
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

        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
