package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import static java.util.Collection.*;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

        HashMap hm = new HashMap();
        int occurence = 0;
        ReadSymptomDataFromFile dataInput = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsList = dataInput.GetSymptoms();

		//Sorting the symptoms list alphabetically
		symptomsList.sort(Comparator.naturalOrder());

        Set<String> mySet = new HashSet<String>(symptomsList);
        List<String> sortedList = new ArrayList<String>(mySet);


        for (int i = 0 ; i < sortedList.size() ; i++) {
            hm.put(sortedList.get(i),Collections.frequency(symptomsList,sortedList.get(i)));
        }

        hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

		// -->> Create WriteFileFromMap function
		FileWriter dataOutput = new FileWriter ("result.txt");
		dataOutput.close();

	}
}
