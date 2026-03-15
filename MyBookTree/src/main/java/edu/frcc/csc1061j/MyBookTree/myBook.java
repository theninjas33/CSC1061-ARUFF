package edu.frcc.csc1061j.MyBookTree;

public class myBook {

	public static void main(String[] args) {
		
		MyBookTree myBook = new MyBookTree("trees for dummies");
		
		myBook.addBookNode("Chapter 5", 5, 0, 0);
		myBook.addBookNode("Chapter 3", 4, 0, 0);
		myBook.addBookNode("Chapter 4", 3, 0, 0);
		myBook.addBookNode("Chapter 2", 2, 0, 0);
		myBook.addBookNode("Chapter 1", 1, 0, 0);
		
		myBook.addBookNode("Chapter 5.5", 5, 5, 0);
		myBook.addBookNode("Chapter 2.3", 2, 3, 0);
		myBook.addBookNode("Chapter 4.2", 4, 2, 0);
		myBook.addBookNode("Chapter 1.2", 1, 2, 0);
		myBook.addBookNode("Chapter 3.4", 3, 4, 0);
		
		myBook.addBookNode("Chapter 5.5.1", 5, 5, 1);
		myBook.addBookNode("Chapter 2.3.2", 2, 3, 2);
		myBook.addBookNode("Chapter 4.2.3", 4, 2, 3);
		myBook.addBookNode("Chapter 1.2.4", 1, 2, 4);
		myBook.addBookNode("Chapter 3.4.5", 3, 4, 5);
	
		for(MyBookNode node: myBook) {
			System.out.println(node);
		}
	}
}
