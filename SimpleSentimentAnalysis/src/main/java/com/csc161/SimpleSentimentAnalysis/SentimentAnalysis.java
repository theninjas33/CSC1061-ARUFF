package com.csc161.SimpleSentimentAnalysis;

import java.io.File;
import java.util.Scanner;

public class SentimentAnalysis {

    public static void main(String[] args) throws Exception {

      

        // create hash map
        HashMap map = new HashMap();

        // load sentiment file
        Scanner file = new Scanner(new File("sentiments.txt"));

        while (file.hasNextLine()) {

            String line = file.nextLine().trim();
            if (line.length() == 0) continue;

            // supports tabs, spaces, or commas
            String[] parts = line.split("[,\\s]+");

            if (parts.length >= 2) {

                String word = parts[0].toLowerCase().trim();

                try {
                    int value = Integer.parseInt(parts[1].trim());
                    map.put(word, value);
                } catch (Exception e) {
                    // skip bad lines
                }
            }
        }

        file.close();

        // user input
        Scanner in = new Scanner(System.in);

        System.out.println("Enter text:");

        int wordCount = 0;
        int sentimentTotal = 0;

        String previousWord = "";

        while (true) {

            String line = in.nextLine();

            if (line.equals("END")) {
                break;
            }

            // clean input text
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            String[] words = line.split("\\s+");

            for (int i = 0; i < words.length; i++) {

                String word = words[i];
                if (word.length() == 0) continue;

                wordCount++;

                // single word sentiment
                Integer value = (Integer) map.get(word);
                if (value != null) {
                    sentimentTotal += value;
                }

                // two-word phrase sentiment
                if (!previousWord.equals("")) {

                    String phrase = previousWord + " " + word;

                    Integer phraseValue = (Integer) map.get(phrase);
                    if (phraseValue != null) {
                        sentimentTotal += phraseValue;
                    }
                }

                previousWord = word;
            }
        }

        in.close();

        // output results
        double average = (wordCount == 0)
                ? 0
                : (double) sentimentTotal / wordCount;

        System.out.println();
        System.out.println("Words: " + wordCount);
        System.out.println("Sentiment: " + sentimentTotal);
        System.out.printf("Overall: %.2f\n", average);
    }
}