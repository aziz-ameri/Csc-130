/**
 * Write a description of class Node here.
 * Written in Eclipse 
 * @author (Abdulaziz Ameri)
 * @version (2/18/2021)
 */
///Node class\\\

class Node
{
    // instance variables 
    
    private int value;
    private Node next;           
    /**
     * Constructor for objects of class Node
     */
    Node() {
    	
    }
    
    Node(int value) {
    	
        setValue(value);
    }    
    
    public void setValue(int value) {
        this.value = value;
    }    
    
    public int getValue() {
        return value;
    }    
    
    public void setNext(Node n) {
        next = n;
    }
    
    public Node getNext() {
        return next;
    }
}

///Llist class\\\
 
class Llist {
    
    private Node head;
    
    void add (int value) {
        
        Node nn = new Node(value);
        nn.setNext(getHead());
        setHead(nn);  
    }
    
    
    void delete(int value) {
    	
    	
	
        if(getHead().getValue() == value ) {
            setHead(getHead().getNext());
	}	
	Node  curr = getHead();
	
	while(curr.getNext() != null &&   !(curr.getNext().getValue() == value) ) {
		
            curr =  curr.getNext();
        }
        
	if(curr.getNext() != null )
            curr.setNext(curr.getNext().getNext() );
	 
		
	}
    
    void traverse() {
		
	for(Node curr = getHead(); curr !=null; curr = curr.getNext() ) {
		System.out.print(curr.getValue() + " ");

            }
	}
    
    
    Node sortMerge(Node one, Node two)
    {
        Node result = null;
        /* Base cases */
        if (one == null)
            return two;
        if (two == null)
            return one;
  
        /* Pick either a or b, and recur */
        if (one.getValue() <= two.getValue() ) {
            result = one;
            result.setNext(sortMerge(one.getNext() , two) );
        }
        else {
            result = two;
            result.setNext(sortMerge(one, two.getNext()) );
        }
        return result;
    }
    
    
    
    Node merge(Node head)
    {
        if (head == null || head.getNext() == null) {
            return head;
        }
  
        Node middle = findMiddle(head);
        Node nextM = middle.getNext();
  
        middle.setNext(null);
  
        Node left = merge(head);
  
        Node right = merge(nextM);
  
        Node sortedli = sortMerge(left, right);
        return sortedli;
    }
    
    
    Node findMiddle(Node head)
    {
        // Base case
        if (head == null)
            return head;
        Node ptrOne = head.getNext();
        Node ptrTwo = head;
  

        while (ptrOne != null) {
            ptrOne = ptrOne.getNext();
            if (ptrOne != null) {
                ptrTwo = ptrTwo.getNext();
                ptrOne = ptrOne.getNext();
            }
        }
        return ptrTwo;
    }


	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}    
   
}


class driver{
 
    public static void main(String[] arg )  {
    	
    	//Node n1 = new Node();
    
    	Llist l1 = new Llist();
    	
    	l1.add(34);
    	l1.add(56);
    	l1.add(76);
    	l1.add(87);
    	l1.add(93);
    	l1.add(12);
    	l1.add(29);
    	l1.add(41);
    	
    	l1.traverse();
    	
    	System.out.println("\nSorted list ");
    	
    	l1.setHead(l1.merge(l1.getHead())); 
    	
    	
    	  
    	  
    	 //System.out.println("After Split Link list 2 ");
    	  l1.traverse();
    	  
    }
}