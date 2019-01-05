//Program to insert, delete, reverse a linked list
import java.util.*;

class LinkedList{
    // Head Node
    static Node head=null;
    // Node Definition
    static class Node{
        int data;
        Node next;
        Node(int n){
            data=n;
            next=null;
        }
    }
    // Function to insert node at the first
    public static LinkedList insertFirst(LinkedList first, int d){
        Node newNode=new Node(d);
        newNode.data=d;
        if(head == null){
            first.head = newNode;
            return first;
        }
        Node temp=first.head;
        head=newNode;
        newNode.next=temp;
        return first;
    }
    // Function to insert node at the last
    public static LinkedList insertLast(LinkedList first, int d){
        Node newNode=new Node(d);
        newNode.data=d;
        newNode.next=null;
        if(head == null){
            first.head = newNode;
        }
        else{
            Node last=first.head;
            while(last.next != null){
                last=last.next;
            }
            last.next = newNode;
        }
        return first;
    }
    //function to insert at the given position
    public static LinkedList insertAt(LinkedList first, int d, int n){
        Node newNode=new Node(d);
        newNode.data=d;
        newNode.next=null;
        Node temp=first.head;
        if(n<1) {
            System.out.println("Invalid Position To Insert");
            return first;
        }
        if(temp==null) n=1;
        int i=0;
        while(i<n-2){
            i++;
            temp=temp.next;
            if(temp==null){
                System.out.println("Invalid Position To Insert");
                return first;
            }
        }
        Node swap=temp.next;
        temp.next=newNode;
        newNode.next=swap;

        return first;
    }
    // Function to delete node at the last
    public static LinkedList deleteLast(LinkedList first){
        Node temp=first.head;
        if(temp == null) {
            System.out.println("List Is Empty");
            return first;
        }
        if(temp.next==null){
            first.head=null;
            return first;
        }
        while(temp.next.next != null){
            temp=temp.next;
        }
        temp.next=null;
        return first;
    }
    //function to delete the node from the begining
    public static LinkedList deleteFirst(LinkedList first){
        if(first.head == null) {
            System.out.println("List Is Empty");
            return first;
        }
        if(first.head.next==null){
            first.head=null;
            return first;
        }
        first.head=first.head.next;
        return first;
    }
    //deleting node at the given position
    public static LinkedList deleteAt(LinkedList first,int n){
        if(first.head == null) {
            System.out.println("List Is Empty");
            return first;
        }
        Node temp=first.head;
        for(int i=0; i<n-2; i++){
            temp=temp.next;
        }
        Node t=temp.next.next;
        temp.next=t;
        return first;
    }
    //reverse function
    public static LinkedList reverse(LinkedList first){
        Node curr,prev,next;
        curr=first.head;
        prev=null;
        next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        first.head=prev;
        return first;
    }
    //print function
    public static void print(LinkedList first){
        Node currNode=first.head;
        while(currNode!=null){
            System.out.print(currNode.data+" ");
            currNode=currNode.next;
        }
        System.out.println();
    }
    //main function
    public static void main(String args[]){
        LinkedList first=new LinkedList();
        System.out.println("Linked List:");
        first=insertLast(first, 3);      //Inserting node at the last
        first=insertLast(first, 4);     //Inserting node at the last
        System.out.println("After Inserting Nodes At The End:");
        print(first);   //after inserting two nodes at the end
        first=insertFirst(first, 1);    //Inserting node at the begining
        System.out.println("After Inserting Nodes At The Begining:");
        print(first);   //after inserting a node at the begining
        first=insertAt(first, 2, 2);  //inseting node at position 2
        System.out.println("After Inserting Nodes At 2nd Position:");
        print(first);  // after inserting a node at the 2nd position
        first=reverse(first); //reversing the List
        System.out.println("After Reversing");
        print(first);  //printing after reversing
        first=reverse(first); //reversing the List
        System.out.println("After Reversing");
        print(first);  //printing after reversing
        first=deleteAt(first,2);   //deleting a node at 2nd position
        System.out.println("After deleting Nodes At 2nd Position:");
        print(first); //printing after deleting node at position 2
        first=deleteLast(first); //deleting from the last
        System.out.println("After Deleting The Last Node:");
        print(first); //printing after deleting a node from thye last
        first=deleteFirst(first); //deleting from the first
        System.out.println("After Deleting The First Node:");
        print(first); //printing after deleting from the first
    }
}
