import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node {
	
	private String name;;
	private Node next;
	private Node prev;
	
	Node() {
		
	}
	
	Node(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return next;
	}
	public void setPrev(Node t) {
		prev = t;
	}
	public Node getPrev() {
		return prev;
	}
	
}


class DList {
	
	private Node head;
	private Node tail;
	
	DList() {
		head = null;
		tail = null;
	}
	
	public void add(String val) {
		
		Node nn = new Node(val);
		
		if(head == null) {
			nn.setNext(head);
			nn.setPrev(null);
			head = nn;
		}
		else if(head.getName().compareTo(nn.getName() ) > 0) {
			
			nn.setNext(head);            
            nn.getNext().setPrev(nn);            
            head = nn;
		}
		else {
			 tail = head;

 
			 while(tail.getNext() != null && tail.getNext().getName().compareTo(nn.getName() ) < 0 ) 
			 
				 tail = tail.getNext();

	            
	            nn.setNext(tail.getNext() );

	            
	            	            	
	            if(tail.getNext() != null)
	            	nn.getNext().setPrev(nn);

	              
	            tail.setNext(nn);

	            nn.setPrev(tail);
	            
		}
			
	}
	
	

	public void delete(String val) {

		Node curr = head;
		
		while(curr != null) {
			
			if(curr.getName().contains(val) ) {		
				if(curr.getPrev() != null)
					curr.getPrev().setNext(curr.getNext() );
				else
					head = curr.getNext();
				if(curr.getNext() != null)
					curr.getNext().setPrev(curr.getPrev() );
				else
					tail = curr.getPrev();
			}
			curr = curr.getNext();
		}		
		
	}
	
	public void traverse () {
		
		if(head == null) {
			System.out.println("Doubly linked list is empty");  
            return;
		}
		
		for(Node curr = head; curr != null; curr = curr.getNext() )
			
			System.out.println( curr.getName() );
	
	
	}

	public void traverseBack(){
		
		for(Node curr = tail; curr != null; curr= curr.getPrev() )
			System.out.println(curr.getName() );
		
	}
	
}


public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		DList list = new DList();
		
		File input = new File("file.txt");
		
		Scanner read = new Scanner(input);
		
		
		
		while(read.hasNextLine() ) {
			
			
			String name = read.next();
			
			if(!name.contains("delete") )
					list.add(name);
			
			if(name.contains("delete") ) { 
				name = read.next();				
				list.delete(name);				
			}			
	}
		
		read.close();
		
		list.traverse();
		
		//list.traverseBack();

	}

}
