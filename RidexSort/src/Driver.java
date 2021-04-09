
class Node
{
    // instance variables - replace the example below with your own
	private int data;
	private Node next;
	
	Node() {
		
	}
	
	public Node(int data) {
		
		setData(data);
	}
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setNext(Node n) {
		next = n;
	}
	
	
	public Node getNext() {
		return next;
	}
	
}




 //QUEUE CLASS\\ First In First Out 
class Queue {
 
 private Node head; // remover for the head private Node tail; //add to the
 private Node tail;
 
 public boolean isEmpty() { return head != null; }
 
 public int peek() { if(head != null) return head.getData();
 
 else { return -999; } }
 
 public void add(int data) { Node nn = new Node(data);
 
 if(tail != null) tail.setNext(nn);
 
 tail = nn;
 
 if(head == null) head = nn; }
 
 public int remove() { int data = head.getData(); head = head.getNext();
 if(head == null) tail = null;
 
 return data; }
 
 public void traverse() { for(Node curr = head; curr != null ; curr =
 curr.getNext() ) { System.out.print(curr.getData() + " "); } } }

 
public class Driver {
	public static void main(String[] args) {
		int[] arr = {45,23,56,32,856,176,23,65,12,78};
		System.out.println("Original Array");
		traverse(arr);
		arr = radixSort(arr);
		System.out.println("Array after Sorting ");
		traverse(arr);
		System.out.println("Array in descending order ");		
		traverseDec(arr);
	}

	public static int[] radixSort(int[] input) {
		// Largest place for a 32-bit int is the 1 billion's place
		for (int place = 1; place <= 100; place *= 10) {
			input = numCount(input, place);
		}

		return input;
	}

	private static int[] numCount(int[] input, int place) {
		int[] out = new int[input.length];
		Queue[] qarr = new Queue[10];

		for (int i = 0; i < 10; i++) {
			qarr[i] = new Queue();
		}

		for (int i = 0; i < input.length; i++) {
			int digit = getNum(input[i], place);
			qarr[digit].add(input[i]);
		}

		int i = 0;
		int id = 0;
		while (id < 10) {
			if (qarr[i].isEmpty() ) {
				out[id++] = (int) qarr[i].remove();
			} else {
				i++;
			}
		}

		return out;

	}

	private static int getNum(int value, int numPlace) {
		return ((value / numPlace) % 10);
	}

	static void traverse(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	static void traverseDec(int[] arr) {
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}