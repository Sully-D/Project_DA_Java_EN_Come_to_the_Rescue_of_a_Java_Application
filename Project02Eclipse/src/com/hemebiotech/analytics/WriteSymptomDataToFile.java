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
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            try {
                FileWriter fileWriter = new FileWriter(filepath, false);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
                writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
