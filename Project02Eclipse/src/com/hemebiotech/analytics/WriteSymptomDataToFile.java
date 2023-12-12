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

                symptoms.forEach((key, value) -> {
                    try {
                        writer.write(key + ": " + value);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error : Problem while writing in result.out");
                    }
                });

                writer.close();

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
