package Grafo;

//This design is implemented with an adyacence list.

import java.util.ArrayList;

public class Graph<T> {

    ArrayList<Node<T>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(T pNewNodeElement){
        Node<T> newNode = new Node<T>(pNewNodeElement);
        nodes.add(newNode);
    }

    public void deleteNode(Node<T> pToDelete){
        //TODO.
    }

    public void addArch(Node<T> pNodeOne, Node<T> pNodeTwo){
        pNodeOne.addArch(pNodeTwo);
        pNodeTwo.addArch(pNodeOne);
    }

    public void clear(){
        nodes.clear();
    }

    public void removeArch(Object pKey){
        //TODO
    }

    public ArrayList<Node<T>> goTroughGraph(){
        Node<T> first = nodes.get(0);
        
    }

    public void pathFrom(Node<T> pNodeA, Node<T> pNodeB){
        //TODO
    }

}
