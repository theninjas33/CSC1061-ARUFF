import org.w3c.dom.Node;

public class MyDoubleLInkedLIst {

}
private class MyIterator implements Iterator<E> {
	private Node curNode = Head;
	
	@Override
	public boolean hasNext() {
		if (curNode != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public E next() {
		if (curNode != null) {
			curNode = curNode.data;
			curNode - curNode.next;
			return data;
			
		}
	}
}