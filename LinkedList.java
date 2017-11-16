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
public class LinkedList {

    private Node first;
    private Node kSelector;
    private Node mSelector;
    private int size;

    public LinkedList(int data) {   //creates initial list
        first = new Node(data);
        first.setNext(first);
        first.setPrevious(first);
        size++;
    }

    public void add(Node n) {  //add a node to the list
        Node before = first;
        Node after = first.getNext();

        before.setNext(n);
        after.setPrevious(n);
        n.setNext(after);
        n.setPrevious(before);
        size++;
    }

    public void remove(int n) { //remove a node from list
        Node toRemove = first;
        Node before;
        Node after;

        if (toRemove == first) {
            if (first.getNext() == null) {
                first = first.getNext().getNext();
            } else {
                first = first.getNext();
            }
        }
        while (toRemove.getId() != n) {
            toRemove = toRemove.getNext();
        }
        before = toRemove.getPrevious();
        after = toRemove.getNext();

        before.setNext(after);
        after.setPrevious(before);
        size--;
    }

    public void Selector(int k, int m) {  //main selector method for removing candidates

        kSelector = first;
        mSelector = first.getPrevious();
        if (size == 1) {
            OutputWriter.saveToFile2("LinkedListProgram.txt", mSelector.toString(), true);  //if n = 1, just print the element, as it will be removed anyway
        }

        while (size > 0) {
            for (int i = 0; i < k - 1; i++) {
                kSelector = kSelector.getNext();
            }
            for (int i = 0; i < m - 1; i++) {
                mSelector = mSelector.getPrevious();
            }
            if (kSelector == mSelector) {
                OutputWriter.saveToFile2("LinkedListProgram.txt", mSelector.toString(), true);
                remove(kSelector.getId());
                kSelector = kSelector.getNext();
                mSelector = mSelector.getPrevious();
            } else if (kSelector.getNext() == mSelector) {
                OutputWriter.saveToFile1("LinkedListProgram.txt", kSelector.toString(), true);
                remove(kSelector.getId());
                kSelector = kSelector.getNext().getNext();
                OutputWriter.saveToFile2("LinkedListProgram.txt", mSelector.toString(), true);
                remove(mSelector.getId());
                mSelector = mSelector.getPrevious();
            } else {
                OutputWriter.saveToFile1("LinkedListProgram.txt", kSelector.toString(), true);
                remove(kSelector.getId());
                kSelector = kSelector.getNext();
                OutputWriter.saveToFile2("LinkedListProgram.txt", mSelector.toString(), true);
                remove(mSelector.getId());
                mSelector = mSelector.getPrevious();
            }
        }
    }

    public int getSize() {
        return size;
    }

}
