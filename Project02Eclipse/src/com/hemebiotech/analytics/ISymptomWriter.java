package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The {@code ISymptomWriter} interface defines a contract for writing symptom occurrences to a file.
 * Implementing classes should provide functionality to write a Map of symptoms and their occurrences
 * to an output file.
 *
 * @author Sullivan
 * @version 1.0
 */
public interface ISymptomWriter {
    /**
     * Writes a Map of symptoms and their occurrences to an output file.
     *
     * @param symptoms The Map containing symptoms as keys and their occurrences as values.
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
