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

    public ArrayList<Node<T>> pathFrom(Node<T> pNodeA, Node<T> pNodeB){

        ArrayList<Node<T>> path;
        ArrayList<Node<T>> auxiliarQueue = new ArrayList<>();

        auxiliarQueue.add(pNodeA);
        Node<T> current = pNodeA;

        while(current != pNodeB){
            current = auxiliarQueue.get(0);
            auxiliarQueue = enqueueArches(current, auxiliarQueue);
            auxiliarQueue.get(0).setVisited(false);
            auxiliarQueue.remove(0);
        }
        path = getPath(current, pNodeA);
        return path;
    }

    private ArrayList<Node<T>> enqueueArches(Node<T> pNode, ArrayList<Node<T>> queue){
        for (Node<T> arch: pNode.getArches()){
            if(!arch.isVisited()){
                arch.setPrevNode(pNode);
                queue.add(arch);
                arch.setVisited(true);
            }
        }
        return queue;
    }

    private ArrayList<Node<T>> getPath(Node<T> pNodeA, Node<T> pNodeB){
        ArrayList<Node<T>> path = new ArrayList<>();
        Node<T> previousNode = pNodeA.getPrevNode();
        path.add(pNodeA);

        if(previousNode == pNodeB){
            path.add(previousNode);
        } else{
            while(previousNode != pNodeB){
                path.add(previousNode);
                previousNode = previousNode.getPrevNode();
            }
        }

        return path;
    }


}
