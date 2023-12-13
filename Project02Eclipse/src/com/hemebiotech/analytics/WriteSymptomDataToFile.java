package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * Takes a Map as input in the form of symptoms: numbers
     * Written to the file as key: value
     */

    private String filepath = "result.out";

    @Override
    public void WriteSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            try {
                FileWriter fileWriter = new FileWriter(filepath, false);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();

                    writer.write(key + ": "  + value);
                    writer.newLine();
                }

                writer.close();

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
