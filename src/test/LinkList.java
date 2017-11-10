

// wrote by ye 
//For understanding the LinkedList.

package test;

class ListNode {
 	
		  int value;
	      ListNode next;
	      
	      ListNode(int x) //constructor
	      { value = x; }
	  
	 public void print(){
		 int x = value;
		 System.out.print(x);   //
	 }
}
    
public class LinkList {
	ListNode first;
	
	
	 public LinkList() {          //define a head node
         this. first = null;  
   }  
	 
	public void addFirst(int x){   //Add a node in the head of list
		ListNode node = new ListNode(x);
		node.next = first;
		first = node;
	}
	public  void add (int index,int x){  // add a node in a specific position
		int pos = 0;
		
		ListNode node = new ListNode(x);
		ListNode current = first;
		ListNode previous = first;
		while (pos != index){
			previous = current;
			current = current.next;
			pos ++;
		} 
		node.next = current;
		previous.next = node;
		
	}
	
	public void delete (int index){ //delete a specific node by position
		int pos = 0;
		ListNode current = first;
		ListNode previous = first;
		if (index == 0){
			current = previous.next;
			first = current;
		}
		else{
		while (pos != index){
			previous = current;
			current = current.next;
			pos++;
		}
		previous.next = current.next;
		}
	}
	
	public void findx ( int index ) { //find a specific node by position
		int pos = 1 ;
		ListNode current = first;
		while (current != null){
			current = current.next;
			pos ++;
			if (pos == index){
				break;
			}
		}
		System.out.println(current.value);
	}
	
	public void findpos (int x){         // find a specific position by node value
		int pos = 1;
		
		ListNode current = first;
		while (current != null){
			
			if (current.value == x){
				break;
			}
			current = current.next;
			pos++ ;
		}
		System.out.println(pos);
	}
	
	public void printall (){             //print all node one by one 
		ListNode current = first;
		while (current != null){
		current.print();
		current = current.next;
		}
		System.out.println();
	}
	
	 public ListNode reverseList (){          //not write yet,but is easy.
		return null;		 
	 }
	

     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// test the  function
		LinkList List = new LinkList();
		List.addFirst(1);
		List.addFirst(2);
		List.addFirst(3);
		List.add(1, 5);
		List.add(2, 7);
		List.printall();
		List.findx(2);
		List.findpos(7);
		List.delete(0);
		List.printall();
		// all right.I am genius

	}

}
