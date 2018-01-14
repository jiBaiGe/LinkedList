

// wrote by ye 

//For understanding the LinkedList.

package test;


import java.util.ArrayList;



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
	
	public void delete (int index){  //delete a specific node by position
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
	
	 void printall (){             //print all node one by one 
		ListNode current = first;
		while (current != null){
		current.print();
		current = current.next;
		}
		System.out.println();
	}
		
	public ListNode deleteDuplicates(ListNode head) {//The requirement from leetcode.com
        ListNode current = head;
        ListNode previous = null;
        ArrayList<Integer> list = new ArrayList<Integer> ();
        
        while(current != null) {
        	
        	if( list.contains(current.value)) {
        		previous.next = current.next;
        	}else {
        	list.add(current.value);
        	previous = current;
        	}
        	current = current.next;
        }
        return current;
    }
	
	
	 public ListNode reverseList (ListNode head){          //通过外部数组存储存储
//		  ListNode current = head;
//		  ListNode previous = head;
//		  if(current == null) {return head;}
//		 ArrayList<Integer> list = new ArrayList<Integer> ();
//		  while (current != null ) {
//			  list.add(current.value);
//			  current = current.next;	 
//		  }
//		  
//		  for(int i = list.size()-1; previous !=null ; i--) {
//			  previous.value = list.get(i);
//			  previous = previous.next;
//		  }return head;
		 
		 //第二种方法
		 
		 ListNode first =null;
		 ListNode current = head;
		 ListNode newnode =null;
		 while (current != null) {
			 
			 newnode = new ListNode(current.value);
			newnode.next = first;
			first = newnode;
			current = current.next;
		 }
		 this.first = first;
		  return head;
		 
		
	 }
	 
//	 public void Merge(ListNode list1,ListNode list2) {//将两个升序的链表list2合并到list1中，合并结束仍是升序。
//		  
//		  ListNode node2 = list2;
//		  
//		  
//		  while(node2 != null) {
//			ListNode node1 = list1;  
//			 ListNode previous = list1;
//			 
//			 //将list2中每一个节点分别取出，往list1中插。
//		 ListNode  current = new ListNode(node2.value);
//		 
//		  while(true) {	
//			  	  
//			  if(node1 == null || current.value < node1.value) {
//				  //判断current节点是否比list1头结点大。
//				  if(previous == node1) { current.next = previous; list1 = current;break;}
//				  previous.next = current;
//				  current.next = node1;
//				  break;
//			  }
//			  previous = node1;
//			  node1 = node1.next;
//			  
//		  	}
//		  node2 = node2.next; 
//		  
//		  }
//		  this.first =  list1;
//		  
//	    }
	 
	 public static ListNode Merge(ListNode list1,ListNode list2) {//将两个升序的链表list2合并到list1中，合并结束仍是升序。
		  
		  ListNode node2 = list2;
		  
		  
		  while(node2 != null) {
			ListNode node1 = list1;  
			 ListNode previous = list1;
			 
			 //将list2中每一个节点分别取出，往list1中插。
		 ListNode  current = new ListNode(node2.value);
		 
		  while(true) {	
			  	  
			  if(node1 == null || current.value < node1.value) {
				  //判断current节点是否比list1头结点大。
				  if(previous == node1) { current.next = previous; list1 = current;break;}
				  previous.next = current;
				  current.next = node1;
				  break;
			  }
			  previous = node1;
			  node1 = node1.next;
			  
		  	}
		  node2 = node2.next; 
		  
		  }
		  return list1;
		  
	    }

     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// test the  function
		LinkList List = new LinkList();
		List.addFirst(1);
		List.addFirst(2);
		List.addFirst(3);
		List.add(1, 7);
		List.add(2, 5);
		List.printall();
		List.findx(2);
		List.findpos(7);
		List.delete(0);
		List.add(3, 7);
		List.printall();
		
		List.deleteDuplicates(List.first);
		List.reverseList(List.first);
		
		List.printall();		
		LinkList List2 = new LinkList();
		
		List2.addFirst(0);
		List2.addFirst(8);
		List2.addFirst(9);
		List2.printall();
		List.first = Merge(List.first, List2.first);
		List.printall();
		// all right.I am genius

	}

}
