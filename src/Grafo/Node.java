package Grafo;

import java.util.ArrayList;

//This design is implemented with an adyacence list.

public class Node<T> {

    private ArrayList<Node<T>> arches;
    private Node<T> prevNode;
    private boolean visited;
    private T element;
    private boolean visitado;

    public Node(T pElement) {

        element = pElement;
        arches = new ArrayList<>();
        visited = false;
        prevNode = null;
    }

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    public void addArch(Node<T> pNewArch){
        arches.add(pNewArch);
    }

    public void deleteArch(Node<T> pToEliminate){
        arches.remove(pToEliminate);
    }

    public ArrayList<Node<T>> getArches() {
        return arches;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
