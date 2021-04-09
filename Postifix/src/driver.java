import java.io.IOException;
import java.util.Scanner;


/**
 * Write a description of class Node here.
 * Written in Eclipse 
 * @author (Abdulaziz Ameri)
 * @version (2/18/2021)
 */
///Node class\\\

class Node<T>
{
    // instance variables - replace the example below with your own
	private T data;
	private Node<T> next;
	
	Node() {
		
	}
	
	public Node(T data) {
		
		setData(data);
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public void setNext(Node<T> n) {
		next = n;
	}
	
	
	public Node<T> getNext() {
		return next;
	}
	
   
}

///Stack class\\\
 //LIFO\\Last in First out
class stack<T> {
    
    private Node<T> top;
    
    public boolean isEmpty() {
    	
    	return top != null;
    }
    
    public T peek() {
    	
    	return top.getData();
    	
    }
    
    public void push(T data) {
    	Node<T> nn = new Node<T>(data);
    	if(top == null)
    		top = nn;
    	else {    		
     		nn.setNext(top);
     		top = nn;
    	}
    	
    }
    
	public T pop() {
    	if(top == null )
    		return null;
    	
    	T data = top.getData();    	
    	top = top.getNext();
    	return data;
    	
    }
    
    public void traverse() {
    	 
    	for(Node<T> curr = top; curr != null ; curr = curr.getNext() ) {
    		System.out.print( curr.getData() );
    	}
    }
   
}
// QUEUE CLASS\\ First In First Out
class Queue<T> {
	
	private Node<T> head; // remover for the head
	private Node<T> tail; //add to the tail
	
	public boolean isEmpty() {
		return head != null; 
	}
	
	public T peek() {
		if(head != null)
		return head.getData();
		
		else {
			return null;
		}
	}
	
	public void add(T data) {
		Node<T> nn = new Node<T>(data);
		
		if(tail != null)
			tail.setNext(nn);
		
		tail = nn;
		
		if(head == null)
			head = nn;		
	}
	
	public T remove() {
		T data = head.getData();
		head = head.getNext();
		if(head == null)
			tail = null;
		
		return data;	
	}
	
	public void traverse() {
		for(Node<T> curr = head; curr != null ; curr = curr.getNext() ) {
			System.out.print(curr.getData() );
		}
	}
}


class postifix{
    
	public static int prec(char ch ) {
    	
    	switch(ch) {
    	  
		case '+':
		case '-':
			return 1;
    	  
		case '*':
		case '/':  
			return 2;
		
		case '^':
			return 3;
		
		default:
    	    return -1;
    	}    	
    	
	}

 
    public Queue<Character> getPostfix(String input) {
    	    	
    	
    	stack<Character> s1 = new stack<Character>();
    	Queue<Character> q1 = new Queue<Character>();
    	       	
    	for(int i=0; i<input.length(); i++) {
    		
	    	if( Character.isLetterOrDigit( input.charAt(i)) )
	    			q1.add(input.charAt(i) );
    		
	    	else if(!Character.isLetterOrDigit(input.charAt(i) ) )
	    		if(!s1.isEmpty() )
	    			s1.push(input.charAt(i));
	    	else if(input.charAt(i) == '(' )
	    		s1.push(input.charAt(i) );
	    	
	    	else if(input.charAt(i) == ')' ) {	    		
	    		while(s1.isEmpty() && s1.peek() != '(' ) 
	    			q1.add(s1.pop() );
	    			    		
	      		s1.pop();	    		
	    	}
	    	
	    	else {
	    		while(s1.isEmpty() && prec(input.charAt(i)) <= prec(s1.peek() ) ) {
	    			//if(s1.peek() == ')' )
	    				//return "Invalid Expression";
	    			q1.add(s1.pop() );
	    		}
	    		s1.push(input.charAt(i) );
	    	}
	    	
	    	
	    }
    	
    	while(s1.isEmpty() ) {
    		q1.add(s1.pop() );	    	
    	}	
    	
    	
    	return q1;
    	    	
	}

}



class evaluate {
	
	public int calEval(Queue<Character> q) {
		stack<Integer> s1 = new stack<Integer>();
		int a=0;
		int b=0;
		
		while(q.isEmpty() ) {
					
			if(Character.isLetterOrDigit(q.peek()) )
				s1.push(Integer.parseInt(q.remove().toString()) );
					
			
			else {
				b = s1.pop(); 
				a = s1.pop();
				
				switch (q.peek() ) {
				case '+':
					s1.push(a + b);
					break;
				case '-':
					s1.push(a - b);
					break;
				case '*':
					s1.push(a * b);
					break;
				case '/':
					s1.push(a / b);
					break;
				}
				q.remove();
		
			}	
				
		}
		
		//System.out.println(b);
		//s1.traverse();
		//System.out.println();
	return s1.pop();
	}
}



	
public class driver {
	
	public static void main(String[] arg ) throws IOException {
		
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter an expression ");
		
		String input = userInput.nextLine();
		
    	//String input;
		
		postifix addQ = new postifix();
		
		Queue<Character> q1 = addQ.getPostfix(input);
		
		userInput.close();
		
		q1.traverse();
		//System.out.println();
		evaluate addUp = new evaluate();
		
		int x = addUp.calEval(q1);
		System.out.println();
		System.out.println(x);
		
		
	}
	
}