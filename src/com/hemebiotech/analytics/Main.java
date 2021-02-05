package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {

        ReadSymptomDataFromFile dataInput = new ReadSymptomDataFromFile("symptoms.txt");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        List<String> data = analyticsCounter.reading(dataInput);
        TreeMap<String,Integer> map = analyticsCounter.sorting(data);
        analyticsCounter.saving(map);


    }
}
