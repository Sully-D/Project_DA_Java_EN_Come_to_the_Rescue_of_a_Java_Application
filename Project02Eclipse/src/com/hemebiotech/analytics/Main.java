package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    
    public static void main (String[] args) throws Exception {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        List <String> sysmptoms = counter.getSymptoms();
        Map<String, Integer> countSymptoms = counter.countSymptoms(sysmptoms);
        Map<String, Integer> sortSymptoms = counter.sortSymptoms(countSymptoms);
        counter.writeSymptoms(sortSymptoms);

        System.out.println("List of sysmptoms :\n" + sortSymptoms);
    }
}
