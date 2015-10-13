// Q1. Implement a deque using a double-linked list.
import java.util.Scanner;
class Link{
    public long dData;
    public Link next;
    public Link previous;
    
    public Link(long dd){
        dData = dd;
    }
    
    public void displayLink(){
        System.out.print(dData + " ");
    }
}

class DoublyLinkedList{
    private Link first;
    private Link last;
    
    public DoublyLinkedList(){
        first = null;
        last = null;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insertFirst(long dd){
        Link newLink = new Link(dd);
        
        if (isEmpty()){
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }
    
    public void insertLast(long dd){
        Link newLink = new Link(dd);
        
        if (isEmpty()){
            first = newLink;
        } else {
            //last.previous = last;
            last.next = newLink;
            newLink.previous = last; 
        }
        last = newLink;
    }
    
    public Link deleteFirst(){
        Link temp = first;
        if (first.next == null){
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }
    
    public Link deleteLast(){
        Link temp = last;
        if (first.next == null){
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }
    // insert dd after key, insert 77 after 22
    public boolean insertAfter(long key, long dd){
        Link current = first;
        while ( current.dData != key ){
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        Link newLink = new Link(dd);
        
        if ( current == last ){
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    
    public Link deleteKey(long key){
        Link current = first;
        while ( current.dData != key ){
            current = current.next;
            if(current == null)
                { return null; }
        }
        
        if (current == first){
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        
        if (current == last){
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }
    
    public void displayForward(){
        Link current = first;
        while ( current != null ){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
    
    public void displayBackward(){
        Link current = last;
        while ( current != null){
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }
}

class DoublyLinkedApp{
    public static void main(String [] args){
        DoublyLinkedList theList = new DoublyLinkedList();


        
        // EDIT THESE VARIABLES AND SEE OUTPUT!!
        Scanner reader = new Scanner(System.in);
        System.out.print("How many numbers will you input at the beginning? : ");
        int start = reader.nextInt(); 

        int toInsertFirst[] = new int[start];

        System.out.print("How many numbers will you input at the end? : ");
        int finish = reader.nextInt(); 

        int toInsertLast[] = new int[finish];

        System.out.print("How many numbers will you pop from beginning? : ");
        int popFromFirst = reader.nextInt(); 

        System.out.print("How many numbers will you pop from end? : ");
        int popFromLast = reader.nextInt(); 

        for (int i = 0; i < start ; i++){
           System.out.print("Enter a number to insert at the beginning, " + (start - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           toInsertFirst[i] = newNumber;
        }
        for (int i = 0; i < finish ; i++){
           System.out.print("Enter a number to insert at then ending, " + (finish - i) + " remaining : ");
           int newNumber = reader.nextInt(); 
           toInsertLast[i] = newNumber;
        }


        System.out.println("Inserting toInsertFirst array at the beginning : ");
        for ( int i = 0; i < toInsertFirst.length; i++){
            theList.insertFirst(toInsertFirst[i]);
        }
        
        theList.displayForward();
        
        System.out.println("Inserting toInsertLast array at the end : ");
        for ( int i = 0; i < toInsertLast.length; i++){
            theList.insertLast(toInsertLast[i]);
        }
        
        theList.displayForward();
        
        System.out.println("Removing " + popFromFirst + " items from beginning : ");
        for ( int i = 0; i < popFromFirst; i++){
            theList.deleteFirst();
        }
        
        theList.displayForward();
        
        System.out.println("Removing " + popFromLast + " items from end : ");
        for ( int i = 0; i < popFromLast; i++){
            theList.deleteLast();
        }
        
        theList.displayForward();
    }
}