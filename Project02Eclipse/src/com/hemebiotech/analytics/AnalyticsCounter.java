package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;
	private ISymptomReader reader;
	private ISymptomWriter writer;

	

	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}


	public List<String> getSymptoms () {
		return reader.getSymptoms();
	}
	

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> tmp = new HashMap<>();
		for (String symptom : symptoms) {
			if (symptom.equals("headache")) {
				headacheCount++;
			}
			else if (symptom.equals("rush")) {
				rashCount++;
			}
			else if (symptom.equals("pupils")) {
				pupilCount++;
			}
		}
		tmp.put("headache", headacheCount);
		tmp.put("rush", rashCount);
		tmp.put("Pupils", pupilCount);
		return tmp;
	}


	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		try {
			TreeMap<String, Integer> tmp = new TreeMap<String, Integer>(symptoms);
			return tmp;
		}
		catch (ClassCastException e) {
			System.out.println("ERROR: Bad trying to sort");
		}
		return symptoms;
	}


	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.WriteSymptoms(symptoms);
	}

}

	/*
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
*/