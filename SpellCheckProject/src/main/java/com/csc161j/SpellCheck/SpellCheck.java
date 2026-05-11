package com.csc161j.SpellCheck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SpellCheck {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error: No dictionary file provided.");
            return;
        }

        String filename = args[0];
        AVLTree tree = new AVLTree();

        // Load dictionary
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String word;
            while ((word = reader.readLine()) != null) {

                word = word.trim();

                if (!word.equals("")) {
                    tree.insert(word);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error: Could not open file.");
            return;
        }

        System.out.println("Loaded the words into a tree with height = " + tree.height());

        Scanner input = new Scanner(System.in);

        while (true) {

            if (!input.hasNext()) break;

            String word = input.next();

            if (word.equals("END")) {
                break;
            }

            if (!tree.search(word)) {
                System.out.println(word + " is spelled wrong!");
            }
        }

        input.close();
    }
}