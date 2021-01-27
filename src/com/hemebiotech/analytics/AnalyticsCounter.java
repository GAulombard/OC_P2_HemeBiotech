package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile dataInput = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptomsList = dataInput.GetSymptoms();

		//Sorting the symptoms list alphabetically
		symptomsList.sort(Comparator.naturalOrder());
		System.out.println(symptomsList); //check the result in terminal
		System.out.println(symptomsList.size()); //check the result in terminal

		//compare elements in list
		for (int i = 0 ; i < symptomsList.size() ; i++) { //Run the tab

		}

		//test HashMap
		HashMap hm = new HashMap();
		hm.put("test 1", 2);
		hm.put("test 2", 12);
		hm.put("test 3", 26);
		System.out.println(hm);


		//Créer une fonction WriteFileFromMap
		FileWriter dataOutput = new FileWriter ("result.txt");
		dataOutput.close();

	}
}
