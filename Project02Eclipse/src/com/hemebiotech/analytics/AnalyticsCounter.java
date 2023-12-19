package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class, {@code SymptomProcessor}, is responsible for processing symptoms.
 * It provides functionality to retrieve a list of symptoms, count the occurrences
 * for each symptom, sort symptoms and their occurrences alphabetically, and write
 * the result to a file named result.out.
 *
 * @author Sullivan
 * @version 1.0
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;


	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves a list of symptoms from a data source.
	 *
	 * @return A list of symptoms.
	 */
	public List<String> getSymptoms () {
		return reader.getSymptoms();
	}

	/**
	 * Counts the number of occurrences for each symptom in the list.
	 *
	 * @param symptoms The list of symptoms to process.
	 * @return A Map associating each symptom with its number of occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> tmp = new HashMap<>();
		for (String symptom : symptoms) {
			if (tmp.containsKey(symptom)) {
				int count = tmp.get(symptom) +1;
				tmp.put(symptom, count);
			}
			else {
				tmp.put(symptom, 1);
			}
		}
		return tmp;
	}

	/**
	 * Sorts symptoms and their occurrences alphabetically.
	 *
	 * @param symptomsOccurrences The Map of symptoms and their occurrences.
	 * @return A Map sorted alphabetically by symptoms.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsOccurrences) {
		try {
            return new TreeMap<String, Integer>(symptomsOccurrences);
		}
		catch (ClassCastException e) {
			System.out.println("ERROR: Bad trying to sort");
		}
		return symptomsOccurrences;
	}

	/**
	 * Writes the result to a file named result.out.
	 *
	 * @param sortedSymptoms The sorted Map of symptoms and their occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> sortedSymptoms) {
		writer.writeSymptoms(sortedSymptoms);
	}

}