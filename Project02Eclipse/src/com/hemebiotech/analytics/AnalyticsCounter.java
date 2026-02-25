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

        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> map = new HashMap<>();
        for (String symptoms1 : symptoms) {
            if (map.containsKey(symptoms1)) {
                map.put(symptoms1, map.get(symptoms1) + 1);
            } else {
                map.put(symptoms1, 1);
            }
        }
        return map;
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        TreeMap<String, Integer> map = new TreeMap<>(symptoms);
        for (String element : symptoms.keySet()) {
            map.put(element, symptoms.get(element));
        }
        return map;
    }


    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);

    }


}
