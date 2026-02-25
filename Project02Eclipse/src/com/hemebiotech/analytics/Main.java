package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile("/home/khady/Tall-Khady-debug-java/Project02Eclipse/symptoms.txt");

        ISymptomWriter iSymptomWriter = new WriteSymptomDataToFile("/home/khady/Tall-Khady-debug-java/result.out");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);

        List<String> liste = analyticsCounter.getSymptoms();
        System.out.println(liste);

        Map<String, Integer> mapCount = analyticsCounter.countSymptoms(liste);
        System.out.println(mapCount);

     Map<String, Integer> mapSort = analyticsCounter.sortSymptoms(mapCount);







    }
}
