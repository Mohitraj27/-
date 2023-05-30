//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class Remove_Duplicate_From_LL
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        GfG g = new GfG();
		llist.head = g.removeDuplicates(llist.head);
		llist.printList();
		
        t--;		
        }
    }}
// } Driver Code Ends





class GfG
{
    
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
/* optimized approach
    Simply using the concept of hashset 
    1. checks for the head node if it is null return null means no node present
    2. Create a empty hashset and all values in it 
    and intialize current node as head node 
    and check that current.next should not be null if found while loop terminates and head is returned
    write a conditon for duplicates elements using .contains() function and checks by iterating throughout the 
    linkedlist 
    and 
	*/
	
	
	if(head==null)
	{
	    return null;
	}
	Set<Integer> duplicates =new HashSet<>();
	duplicates.add(head.data);
	Node current= head;
    while (current.next != null) {
        if(duplicates.contains(current.next.data)){
           current.next = current.next.next;
        }
        else {
            duplicates.add(current.next.data);
            current=current.next;
        }
        }
    return head;    }
}
