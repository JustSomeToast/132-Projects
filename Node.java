/*
 * Property of no one in particular. Open Project Properties to change this.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outlab2;

/**
 *
 * @author Tyler
 */
public class Node {
    
    private Node next;
    private Node previous;
    private int idNum;

    
    public Node(int id){  //constructor for node
        idNum = id;
        next = null;
        previous = null;
    }
    
    public void setNext(Node n){
        next = n;        
    }
    
    public void setPrevious(Node n){
        previous = n;
    }
    
    public int getId(){
        return idNum;
    }
    
    public Node getNext(){
        return next;
    }
    
    public Node getPrevious(){
        return previous;
    }
    
    public void setId(int id){
        idNum = id;
    }
    
    @Override
    public String toString(){
        return idNum + " ";
    }
}
