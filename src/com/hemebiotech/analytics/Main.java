package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.*;

/**
 * Principal class of the program
 *
 */

public class Main {
    public static void main(String args[]) throws Exception {

        ReadSymptomDataFromFile dataInput = new ReadSymptomDataFromFile("symptoms.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        List<String> data = analyticsCounter.reading(dataInput); //transform *.txt file into a list of String
        TreeMap<String,Integer> map = analyticsCounter.sorting(data); //sort the list alphabetically into a TreeMap
        analyticsCounter.saving(map); //save the TreeMap into a file


    }
}
