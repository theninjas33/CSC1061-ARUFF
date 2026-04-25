package com.csc161j.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/*
 * Builds a tree from a file system directory.
 * Each node is either a file or a folder.
 */
public class FileTree implements Iterable<FileNode> {

    private FileNode root;

    // Creates the tree starting from a path
    public FileTree(String path) {
        root = new FileNode(path);
        buildTree(root);
    }

    // Default traversal (post-order DFS)
    @Override
    public Iterator<FileNode> iterator() {
        return new DepthFirstIterator();
    }

    // Recursively builds the tree structure
    private void buildTree(FileNode fileNode) {

        File file = fileNode.getFile();

        if (file.isDirectory()) {

            File[] files = file.listFiles();

            if (files != null) {

                for (File f : files) {

                    FileNode child = new FileNode(f);
                    fileNode.getChildNodes().add(child);

                    buildTree(child);
                }
            }
        }
    }

    // Post-order DFS iterator
    private class DepthFirstIterator implements Iterator<FileNode> {

        private Deque<FileNode> stack1 = new ArrayDeque<>();
        private Deque<FileNode> stack2 = new ArrayDeque<>();

        public DepthFirstIterator() {

            if (root != null) {

                stack1.push(root);

                while (!stack1.isEmpty()) {

                    FileNode node = stack1.pop();
                    stack2.push(node);

                    for (FileNode child : node.getChildNodes()) {
                        stack1.push(child);
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !stack2.isEmpty();
        }

        @Override
        public FileNode next() {
            return stack2.pop();
        }
    }

    // BFS traversal access
    public Iterator<FileNode> breadthFirstIterator() {
        return new BreadthFirstIterator();
    }

    // Level-order traversal using a queue
    private class BreadthFirstIterator implements Iterator<FileNode> {

        private Queue<FileNode> queue = new ArrayDeque<>();

        public BreadthFirstIterator() {
            if (root != null) {
                queue.add(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public FileNode next() {

            FileNode node = queue.poll();

            for (FileNode child : node.getChildNodes()) {
                queue.add(child);
            }

            return node;
        }
    }
}