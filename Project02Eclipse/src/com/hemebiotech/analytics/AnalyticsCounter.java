package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
	private ISymptomWriter writer = new WriteSymptomDataToFile();

	

	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {

		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms () {
		return reader.GetSymptoms();
	}
	
	public Map countSymptoms(List symptoms) {
		HashMap<String, Integer> tmp = new HashMap<>();
		for (int i = 0; i < symptoms.size(); i++) {
			if (symptoms.get(i) == "headache") {
				headacheCount++;
			}
			else if (symptoms.get(i) == "rush") {
				rashCount++;
			}
			else if (symptoms.get(i) == "pupils") {
				pupilCount++;
			}
		}
		tmp.put("headache", headacheCount);
		tmp.put("rush", rashCount);
		tmp.put("Pupils", pupilCount);
		return tmp;
	}

	public Map sortSymptoms(Map symptoms) {
		try {
			TreeMap<String, Integer> tmp = new TreeMap<String, Integer>(symptoms);
			return tmp;
		}
		catch (ClassCastException e) {
			System.out.println("ERROR: Bad trying to sort");
		}
		return symptoms;
	}

	public void writeSymptoms(Map symptoms) { 
		writer.WriteSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
