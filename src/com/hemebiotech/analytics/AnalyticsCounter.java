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
     *this method transform a text file into a List of String non. It use the ReadSymptomDataFromFile class
     * and implement ISymptomReader interface
     *
     * @param dataInput
     * data text file
     *
     * @return a list of String
     *
     * @see ReadSymptomDataFromFile
     * @see ISymptomReader
     */
    public List<String> reading(ReadSymptomDataFromFile dataInput) {

        return dataInput.GetSymptoms();

    }

    /**
     *this method allow to re organize a list and transform it into a TreeMap with keys (Strings) and values (Integer).
     *
     * <p>It will re organize alphabetically(key) and count the occurrence(value) number and put all in a TreeMap.</p>
     *
     * @param list
     * list of String
     *
     * @return a TreeMap with symptoms (key), occurrence (value)
     *
     */
    public TreeMap<String, Integer> sorting(List<String> list){

        Set<String> noDuplicateSet = new HashSet<String>(list); // Delete duplicates
        List<String> noDuplicateList = new ArrayList<String>(noDuplicateSet); // new list without duplicates

        Map<String,Integer> symptomsOccurrence = new HashMap(); //Temporary Map to get (symptoms, occurrence)

        for (String symptom : noDuplicateList) { // fill the Map with symptoms(key) and occurrences(value)
            symptomsOccurrence.put(symptom,Collections.frequency(list,symptom));
        }

        TreeMap<String, Integer> mapSorted = new TreeMap<String, Integer>(); //TreeMap to sort alphabetically

        mapSorted.putAll(symptomsOccurrence); //fill the TreeMap with our temporary Map
        return mapSorted;
    }

    /**
     *allow to save in a file what contains a TreeMap.
     *
     *<p>If the file doesn't exist, a new file named "results.out" will be created.</p>
     *
     * @param map
     * a TreeMap with String(key) and Integer(value)
     *
     * @throws IOException if I/O operations failed or interrupt
     * @see BufferedWriter
     * @see FileWriter
     */
    public void saving(TreeMap<String, Integer> map) throws IOException {

        System.out.println("\n*** saving sorted symptoms list in \"../result.out\" file.................................");

        try {

            File results = new File("result.out");
            BufferedWriter writer = new BufferedWriter(new FileWriter (results));

            for(Map.Entry<String, Integer> entry : map.entrySet()) { // run the TreeMap and write each line into the result.out

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
