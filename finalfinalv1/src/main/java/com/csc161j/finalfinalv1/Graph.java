package com.csc161j.finalfinalv1;

import java.util.ArrayList;

/*
 * Graph class using an adjacency matrix.
 * Represents a directed graph.
 */
public class Graph {

    // List of course names
    private ArrayList<String> vertices;

    // Adjacency matrix
    private boolean[][] edges;

    /*
     * Constructor
     */
    public Graph(int size) {

        vertices = new ArrayList<String>();
        edges = new boolean[size][size];
    }

    /*
     * Adds a vertex to the graph
     */
    public void addVertex(String name) {

        vertices.add(name);
    }

    /*
     * Returns index of a vertex
     */
    public int getIndex(String name) {

        return vertices.indexOf(name);
    }

    /*
     * Returns vertex name at index
     */
    public String getVertex(int index) {

        return vertices.get(index);
    }

    /*
     * Returns number of vertices
     */
    public int size() {

        return vertices.size();
    }

    /*
     * Adds a directed edge
     */
    public void addEdge(String from, String to) {

        int fromIndex = getIndex(from);
        int toIndex = getIndex(to);

        // Only add valid edges
        if(fromIndex >= 0 && toIndex >= 0) {

            edges[fromIndex][toIndex] = true;
        }
    }

    /*
     * Removes an edge
     */
    public void removeEdge(int from, int to) {

        edges[from][to] = false;
    }

    /*
     * Checks if edge exists
     */
    public boolean hasEdge(int from, int to) {

        return edges[from][to];
    }

    /*
     * Counts incoming edges for a node
     */
    public int indegree(int node) {

        int count = 0;

        for(int i = 0; i < size(); i++) {

            if(edges[i][node]) {

                count++;
            }
        }

        return count;
    }

    /*
     * Checks if graph still has edges
     */
    public boolean hasEdges() {

        for(int i = 0; i < size(); i++) {

            for(int j = 0; j < size(); j++) {

                if(edges[i][j]) {

                    return true;
                }
            }
        }

        return false;
    }
}