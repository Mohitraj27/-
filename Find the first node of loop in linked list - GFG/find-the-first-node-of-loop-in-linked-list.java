//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            Solution x = new Solution();
            out.println(x.findFirstNode(head));
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java


/* class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}*/

class Solution {
    //Function to find first node if the linked list has a loop.
    // using floyd's warshal algorithm 
    public static int findFirstNode(Node head){
        //code here
        /* 1. two pointers are intilaized with head node 
        and a boolean variable is taken which checks the loop exist or noy
        2. If no loop is detected, the function returns null to indicate
        that no loop exists in the linked list
        3. If a loop exists, the slowPtr is reset to the head of the 
        linked list, and both slowPtr and fastPtr are moved one step 
        at a time until they meet again at the first node of the loop.
        This is achieved by the second while loop.

Finally, the function returns the slowPtr, which represents 
the first node of the loop in the linked list.
        */
            Node slowPtr = head;
    Node fastPtr = head;
    boolean loopExists = false;

    while (fastPtr != null && fastPtr.next != null) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;

        if (slowPtr == fastPtr) {
            loopExists = true;
            break;
        }
    }

    if (!loopExists) {
        return -1; // No loop exists
    }

    slowPtr = head;

    while (slowPtr != fastPtr) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
    }

    return slowPtr.data; // Return the first node of the loop
}

    
}