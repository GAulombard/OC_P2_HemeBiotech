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
     * data is a list of String elements
     *
     */
    private List<String> data;
    /**
     *a Map that contains String keys and value
     */
    private Map symptomsOccurrence = new HashMap();
    /**
     *a Map that contains String keys and Long value organized alphabetically form the symptomsOccurence Map
     * @see Map symptomsOccurence
     */
    private TreeMap<String, Long> map = new TreeMap<String, Long>();

    /**
     *Constructor
     *
     * @param data
     *      a list of String from a text file that use the ReadSymptomDataFromFile class
     * @see ReadSymptomDataFromFile
     *
     */

    //----CONSTRUCTOR----
    public AnalyticsCounter(List<String> data) {

        this.data = data;

    }

    //----METHODS----
    /**
     *this method allow to write the list from the data List String, in the terminal
     */
    public void reading() {

        System.out.println("\n-------------- READING SYMPTOMS LIST ----------------\n");
        System.out.println(data);

    }
    /**
     *this method allow to re organize the list from data ReadSymptomDataFromFile.
     *
     * <p>It will re organize alphabetically and count the occurrence number and put all in a TreeMap.</p>
     */
    public void sorting(){

        Set<String> noDuplicateSet = new HashSet<String>(data); // Delete duplicates
        List<String> noDuplicateList = new ArrayList<String>(noDuplicateSet); // new list without duplicates

        for (String symptom : noDuplicateList) { // fill the Map with symptoms(key) and occurrences(value)
            symptomsOccurrence.put(symptom,Collections.frequency(data,symptom));
        }

        map.putAll(symptomsOccurrence);

        System.out.println("\n-------------- READING SORTED SYMPTOMS LIST ----------------\n");

        symptomsOccurrence.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

    }
    /**
     *allow to write in a file the result of the sorting() method.
     *<p>If the file doesn't exist, a new file named "results.out" will be created.</p>
     *
     * @throws IOException if I/O operations failed or interrupt
     */
    public void saving() throws IOException {

        sorting();
        System.out.println("\n*** saving sorted symptoms list in \"../results.out\" file.................................");

        try {

            File results = new File("results.out");
            BufferedWriter writer = new BufferedWriter(new FileWriter (results));
            for(Map.Entry<String, Long> entry : map.entrySet()) {

                writer.write(entry.getKey() + " = " + entry.getValue());
                writer.newLine();
                writer.flush();

            }

            writer.close();
            System.out.println("* file saved !\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
