package Grafo;

import java.util.ArrayList;

//This design is implemented with an adyacence list.

import java.util.ArrayList;
import java.util.Queue;

public class Graph<T> {

    ArrayList<Node<T>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(T pNewNodeElement){
    	Node<T> NewNodo = new Node<T>(pNewNodeElement);
    	nodes.add(NewNodo);
    }

    public void deleteNode(Node<T> pToDelete){
    	nodes.remove(pToDelete);
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

    public void pathFrom(Node<T> pNodeA, Node<T> pNodeB){
        //TODO
        ArrayList<Node<T>> path = new ArrayList<>();
        ArrayList<Node<T>> auxiliarQueue = new ArrayList<>();
        auxiliarQueue.add(pNodeA);

        Node<T> current = pNodeA;
        while(current != pNodeB){
            current = auxiliarQueue.get(0);
            auxiliarQueue = enqueueArches(current, auxiliarQueue);
        }


    }

    public ArrayList<Node<T>> enqueueArches(Node<T> pNode, ArrayList<Node<T>> queue){
        for (Node<T> arch: pNode.getArches()){
            queue.add(arch);
        }
        return queue;
    }
}
