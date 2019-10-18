package Grafo;

import java.util.ArrayList;

//This design is implemented with an adyacence list.

public class Node<T> {

    private ArrayList<Node<T>> arches;
    private Node<T> nextNode;
    private Object searchKey;
    private T element;

    public Node(String pSearchKey, T pElement) {
        searchKey = pSearchKey;
        element = pElement;
        arches = new ArrayList<>();
        nextNode = null;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
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

    public Object getSearchKey() {
        return searchKey;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
