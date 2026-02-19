package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ISymptomReader iSymptomReader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

        ISymptomWriter iSymptomWriter = new WriteSymptomDataToFile("Project02Eclipse/write.txt");

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(iSymptomReader, iSymptomWriter);
        List<String> symptomList = analyticsCounter.getSymptoms();


       Map<String, Integer> symptMap = analyticsCounter.countSymptoms(symptomList);

       for(String key : symptMap.keySet()){
           Integer value = symptMap.get(key);
           System.out.println("key" + key + "value = " + value);
       }




    }
}
