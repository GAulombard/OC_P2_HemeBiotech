package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

import static java.util.Collection.*;

/**
 * Allows, from a text file, to read, sort alphabetically, and write a new file
 *
 * @author geoffrey aulombard
 */


public class AnalyticsCounter {

    /**
     *this method allow to write the list from the data List String, in the terminal
     */
    public List<String> reading(ReadSymptomDataFromFile dataInput) {

        return dataInput.GetSymptoms();

    }
    /**
     *this method allow to re organize the list from data ReadSymptomDataFromFile.
     *
     * <p>It will re organize alphabetically and count the occurrence number and put all in a TreeMap.</p>
     */
    public TreeMap<String, Integer> sorting(List<String> list){

        Set<String> noDuplicateSet = new HashSet<String>(list); // Delete duplicates
        List<String> noDuplicateList = new ArrayList<String>(noDuplicateSet); // new list without duplicates
        Map symptomsOccurrence = new HashMap(); //
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        for (String symptom : noDuplicateList) { // fill the Map with symptoms(key) and occurrences(value)
            symptomsOccurrence.put(symptom,Collections.frequency(list,symptom));
        }

        map.putAll(symptomsOccurrence);
        return map;
    }
    /**
     *allow to write in a file the result of the sorting() method.
     *<p>If the file doesn't exist, a new file named "results.out" will be created.</p>
     *
     * @throws IOException if I/O operations failed or interrupt
     */
    public void saving(TreeMap<String, Integer> map) {

        System.out.println("\n*** saving sorted symptoms list in \"../result.out\" file.................................");

        try {

            File results = new File("result.out");
            BufferedWriter writer = new BufferedWriter(new FileWriter (results));
            for(Map.Entry<String, Integer> entry : map.entrySet()) {

                writer.write(entry.getKey() + " = " + entry.getValue());
                writer.newLine();
                writer.flush();

            }

            writer.close();
            System.out.println("* file saved !\n");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
