import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


public class ReverseList<E extends Comparable<E>> {

	
	private List<E> list = new LinkedList<E>();
	
	public void add(E input) {
		list.add(0, input);
	}
	
	public List<E> getLIst() {
		return list;
	}
	
	public int size() {
		return list.size();
		
	}
	public E get(int index);
	return list.get(index); 
	
	}

}
