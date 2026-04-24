package edu.frcc.csc1061j.MyTreeMap;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyTreeMap<K extends Comparable<K>,V> implements Map<K,V>, Iterable<V> {
	private Node root = null;
	private int size = 0;
	
	private class Node {
		protected K key;
		protected V value;
		protected Node lChild;
		protected Node rChild;
	
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		Node current = root;
		Comparable<K> k = (Comparable<K>) key;
		
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				current = current.lChild;
			}
			else if (k.compareTo(current.key) > 0) {
				current = current.rChild;
			}
			else {
				return current.value;
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		if (root == null) {
			root = new Node(key, value);
			size++;
			return null;
		}
		
		Node parent = null;
		Node current = root;
		while(current != null) {
			parent = current;
			if (key.compareTo(current.key) < 0) {
				current = current.lChild;
			}
			else if (key.compareTo(current.key) > 0) {
				current = current.rChild;
			}
			else {
				V oldVal = current.value;
				current.value = value;
				return oldVal;
			}
		}
		
		Node newNode = new Node(key, value);
		if (key.compareTo(parent.key) < 0) {
			parent.lChild = newNode;
		}
		else {
			parent.rChild = newNode;
		}
		
		size++;
		return null;
	}

	@Override
	public V remove(Object key) {
		Comparable<K> k = (Comparable<K>) key;
		V value = null;
		
		// Find node
		Node current = root;
		Node parent = null;
		while(current != null) {
			if (k.compareTo(current.key) < 0) {
				parent = current;
				current = current.lChild;
			}
			else if (k.compareTo(current.key) > 0) {
				parent = current;
				current = current.rChild;
			}
			else {
				value = current.value;
				break;
			}
		}
		
		// Case 1: No children
		if (current.lChild == null && current.rChild == null) {
			if (current == parent.lChild) {
				parent.lChild = null;
			}
			else {
				parent.rChild = null;
			}
		}		
		// Case 3: One child
		else if (current.lChild == null) {
			if (current == parent.lChild) {
				parent.lChild = current.rChild;
			}
			else {
				parent.rChild = current.rChild;
			}			
		}
		else if (current.rChild == null) {
			if (current == parent.lChild) {
				parent.lChild = current.lChild;
			}
			else {
				parent.rChild = current.lChild;
			}			
		}		
		
		if (current.lChild != null && current.rChild != null) {
			Node inOrderPred = current.lChild;
			Node parentOfInOrderPred = current;
			while(inOrderPred.rChild != null) {
				parentOfInOrderPred = inOrderPred;
				inOrderPred = inOrderPred.rChild;
			}
			
			current.key = inOrderPred.key;
			current.value = inOrderPred.value;

			if(parentOfInOrderPred == current) {
				current.lChild = inOrderPred.lChild;
			}
			else {
				parentOfInOrderPred.rChild = null;
			}
		}
		return value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public Set<K> keySet() {

		
		return null;
	}

	@Override
	public Collection<V> values() {
		List<V> values = new LinkedList<>();
		Iterator<V> it = iterator();
		while (it.hasNext()) {
			values.add(it.next());
		}
		return values;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new NonRecursiveIterator();
	}
	
	private class NonRecursiveIterator implements Iterator<V> {
		private Deque<Node> stack = new ArrayDeque<>();
		
		public NonRecursiveIterator() {
			pushOnStack(root);
		}

		private void pushOnStack(Node node) {
			Node current = node;
			while (current != null) {
				stack.push(current);
				current = current.lChild;
			}
		}
		
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public V next() {
			Node node = stack.pop();
			pushOnStack(node.rChild);
			return node.value;
		}
	}
	
	private class RecursiveIterator implements Iterator<V> {

		private List<V> list = new LinkedList<>();
		
		public RecursiveIterator() {
			postorder(root);
		}
		
		private void inorder(Node node) {
			if (node == null) {
				return;
			}
			
			inorder(node.lChild);
			list.add(node.value);
			inorder(node.rChild);
		}
		
		private void preorder(Node node) {
			if (node == null) {
				return;
			}
			list.add(node.value);			
			preorder(node.lChild);
			preorder(node.rChild);
		}

		private void postorder(Node node) {
			if (node == null) {
				return;
			}		
			postorder(node.lChild);
			postorder(node.rChild);
			list.add(node.value);
		}
		
		@Override
		public boolean hasNext() {
			return !list.isEmpty();
		}

		@Override
		public V next() {
			return list.remove(0);
		}
	}
	
}
