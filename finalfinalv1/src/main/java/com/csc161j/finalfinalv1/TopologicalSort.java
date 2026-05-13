package com.csc161j.finalfinalv1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Topological sorting program for course prerequisites.
 * Uses a directed graph and Kahn's Algorithm.
 */
public class TopologicalSort {

    public static void main(String[] args) {

        // Default files to run
        String[] files = {
            "input/cpsc.txt",
            "input/cybr.txt",
            "input/impossible.txt"
        };

        // If command-line argument exists, only run that file
        if(args.length > 0) {

            files = new String[] { args[0] };
        }

        // Run each file
        for(String fileName : files) {

            System.out.println("\n==============================");
            System.out.println("Running: " + fileName);
            System.out.println("==============================");

            runFile(fileName);
        }
    }

    /*
     * Reads a file, builds graph,
     * and performs topological sorting.
     */
    public static void runFile(String fileName) {

        try {

            // Open file
            File file = new File(fileName);

            // Debugging info
            System.out.println("Looking in: " + file.getAbsolutePath());

            // Check if file exists
            if(!file.exists()) {

                System.out.println("File not found.");
                return;
            }

            Scanner scan = new Scanner(file);

            // First number = number of courses
            if(!scan.hasNextInt()) {

                System.out.println("Invalid file format.");
                scan.close();
                return;
            }

            int numCourses = scan.nextInt();
            scan.nextLine();

            Graph graph = new Graph(numCourses);

            /*
             * PASS 1:
             * Add all vertices
             */
            while(scan.hasNextLine()) {

                String line = scan.nextLine().trim();

                if(line.length() == 0) {

                    continue;
                }

                Scanner lineScan = new Scanner(line);

                String course = lineScan.next();

                graph.addVertex(course);

                lineScan.close();
            }

            scan.close();

            /*
             * PASS 2:
             * Add edges
             */
            scan = new Scanner(file);

            // Skip first line
            scan.nextInt();
            scan.nextLine();

            while(scan.hasNextLine()) {

                String line = scan.nextLine().trim();

                if(line.length() == 0) {

                    continue;
                }

                Scanner lineScan = new Scanner(line);

                String course = lineScan.next();

                int prereqCount = lineScan.nextInt();

                for(int i = 0; i < prereqCount; i++) {

                    if(lineScan.hasNext()) {

                        String prereq = lineScan.next();

                        // prereq -> course
                        graph.addEdge(prereq, course);
                    }
                }

                lineScan.close();
            }

            scan.close();

            /*
             * TOPOLOGICAL SORT
             */

            Queue<Integer> active = new LinkedList<Integer>();

            ArrayList<String> ordering = new ArrayList<String>();

            boolean[] added = new boolean[graph.size()];

            // Find all nodes with indegree 0
            for(int i = 0; i < graph.size(); i++) {

                if(graph.indegree(i) == 0) {

                    active.add(i);
                    added[i] = true;
                }
            }

            // Process active set
            while(!active.isEmpty()) {

                int current = active.remove();

                ordering.add(graph.getVertex(current));

                // Remove outgoing edges
                for(int i = 0; i < graph.size(); i++) {

                    if(graph.hasEdge(current, i)) {

                        graph.removeEdge(current, i);

                        // If indegree becomes 0, add node
                        if(graph.indegree(i) == 0 && !added[i]) {

                            active.add(i);
                            added[i] = true;
                        }
                    }
                }
            }

            /*
             * Check for cycle
             */
            if(graph.hasEdges()) {

                System.out.println("Impossible to complete courses.");

            } else {

                System.out.println("Topological Ordering:");

                for(String course : ordering) {

                    System.out.println(course);
                }
            }

        } catch(FileNotFoundException e) {

            System.out.println("File not found.");

        } catch(Exception e) {

            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}