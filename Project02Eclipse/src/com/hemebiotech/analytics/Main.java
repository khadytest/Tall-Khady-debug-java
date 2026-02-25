package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomWriter writeSymptomDataToFile = new WriteSymptomDataToFile("/home/khady/Tall-Khady-debug-java/result.out");
        ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile("/home/khady/Tall-Khady-debug-java/Project02Eclipse/symptoms.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile, writeSymptomDataToFile);

        List<String> liste = analyticsCounter.getSymptoms();
        System.out.println(liste);

        Map<String, Integer> mapCount = analyticsCounter.countSymptoms(liste);
        System.out.println(mapCount);

        Map<String, Integer> sortedMap = analyticsCounter.sortSymptoms(mapCount);

        analyticsCounter.writeSymptoms(sortedMap);


    }
}
