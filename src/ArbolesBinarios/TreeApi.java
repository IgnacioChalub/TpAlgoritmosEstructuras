package ArbolesBinarios;

import java.util.ArrayList;
import java.util.List;

public class TreeApi <T extends Comparable> { //Metodos que vimos en clase
    //-----------------IMPLEMENTADOS EN CLASE----------------------------------------

    public int size(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        }
        return 1 + size(a.getLeft()) + size(a.getRight());
    }

    public int completeNodes(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getLeft().isEmpty()) {
            return completeNodes(a.getRight());
        }
        if (a.getRight().isEmpty()) {
            return completeNodes(a.getLeft());
        }
        return 1 + completeNodes(a.getRight()) + completeNodes(a.getLeft());
    }

    public void inorden(BinaryTree<T> a) { // recorre inorden e imprime los valores
        if (!a.isEmpty()) {
            inorden(a.getLeft());
            System.out.println(a.getRoot());
            inorden(a.getRight());
        }
    }

    public void inorden(BinaryTree<T> a, ArrayList<T> ar) { //llena un arraylist con el recorrido inorden de un arbol
        if (!a.isEmpty()) {
            inorden(a.getLeft(), ar);
            ar.add(a.getRoot());
            inorden(a.getRight(), ar);
        }
    }

    //-----------------GUIA-ARBOLES-BINARIOS------------------------------------------
    public int weight(BinaryTree<T> a) { //IGUAL A SIZE
        if (a.isEmpty()) {
            return 1;
        }
        return 1 + size(a.getLeft()) + size(a.getRight());
    }

    public int leaves(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        }
        return leaves(a.getLeft()) + leaves(a.getRight());
    }

    public int ocurrencias(BinaryTree<T> a, T o) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot().equals(o)) {
            return 1 + ocurrencias(a.getLeft(), o) + ocurrencias(a.getRight(), o);
        } else {
            return ocurrencias(a.getLeft(), o) + ocurrencias(a.getRight(), o);
        }
    }

    public int elementsInLevel(BinaryTree<T> a, int level) {
        if (a.isEmpty()) {
            return 0;
        }
        if (level == 0) {
            return 1;
        }
        return elementsInLevel(a.getLeft(), (level - 1)) + elementsInLevel(a.getRight(), (level - 1));
    }

    public int height(BinaryTree<T> a) {
        return heightAux(a) - 1;
    }

    public int heightAux(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (heightAux(a.getLeft()) > heightAux(a.getRight())) {
            return 1 + heightAux(a.getLeft());
        }
        return 1 + heightAux(a.getRight());
    }

    public int sumElements(BinaryTree<Integer> a) {
        if (a.isEmpty()) {
            return 0;
        }
        return a.getRoot() + sumElements(a.getLeft()) + sumElements(a.getRight());
    }

    public int sumElementsThreeMultiple(BinaryTree<Integer> a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot() % 3 == 0) {
            return a.getRoot() + sumElementsThreeMultiple(a.getLeft()) + sumElementsThreeMultiple(a.getRight());
        }
        return sumElementsThreeMultiple(a.getLeft()) + sumElementsThreeMultiple(a.getRight());
    }

    public boolean compareTrees(BinaryTree<T> t1, BinaryTree<T> t2) {
        ArrayList<T> t1Elements = new ArrayList<T>();
        ArrayList<T> t2Elements = new ArrayList<T>();
        inorden(t1, t1Elements);
        inorden(t2, t2Elements);
        if (t1Elements.size() != t2Elements.size() || !isomorph(t1, t2)) {
            return false;
        }
        for (int i = 0; i < t1Elements.size(); i++) {
            if (!t1Elements.get(i).equals(t2Elements.get(i))) {
                return false;
            }
        }
        return true;
    }

    //intento de mejorar el compareTrees
    /*public boolean compareTrees(BinaryTree<T> t1, BinaryTree<T> t2){
        if(t1.getRoot() != null && t2.getRoot() != null ){
            if(!t1.getRoot().equals(t2.getRoot())){
               return false;
            }
        }
        if(t1.getLeft() == null && t2.getLeft() == null && t1.getRight() == null && t2.getRight() == null){
            return true;
        }
        return compareTrees(t1.getLeft(), t2.getLeft()) && compareTrees(t1.getRight(), t2.getRight());
    }*/

    public boolean isomorph(BinaryTree<T> t1, BinaryTree<T> t2) {
        if ((t1.isEmpty() && !t2.isEmpty()) || (!t1.isEmpty() && t2.isEmpty())) {
            return false;
        }
        if (t1.isEmpty() && t2.isEmpty()) {
            return true;
        }
        return isomorph(t1.getLeft(), t2.getLeft()) && isomorph(t1.getRight(), t2.getRight());
    }

    public boolean areSimilar(BinaryTree<T> t1, BinaryTree<T> t2){
        if(size(t1) != size(t2)){
            return false;
        }
        ArrayList<T> t1Elements = new ArrayList<T>();
        inorden(t1, t1Elements);
        int similarElements = areSimilar(t1Elements, t2);
        if(similarElements == t1Elements.size()){
            return true;
        }
        return false;
    }

    private int areSimilar(List t1Elements, BinaryTree<T> t2) {
       if(t2.isEmpty()){
           return 0;
       }
       if(t1Elements.contains(t2.getRoot())){
           return 1 + areSimilar(t1Elements,t2.getLeft()) + areSimilar(t1Elements, t2.getRight());
       }
       return 0;
    }

    public boolean isComplete(BinaryTree<T> a) {
        if (a.isEmpty()) {
            return false;
        }
        if(a.getRight().isEmpty() && a.getLeft().isEmpty()){
            return true;
        }
        if (a.getLeft().isEmpty() && !a.getRight().isEmpty() || !a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return false;
        }
        return isComplete(a.getLeft()) && isComplete(a.getRight());
    }

    public boolean isFull(BinaryTree<T> t1){
        if(Math.pow(2,height(t1)) == elementsInLevel(t1, height(t1))){
            return true;
        }
        return false;
    }

    public boolean isEstable(BinaryTree<T> t1){
        if(t1.isEmpty() || size(t1) == 1){
            return true;
        }
        return isEstableAux(t1);
    }

    private boolean isEstableAux(BinaryTree<T> t1){
        if(t1.getRight().isEmpty() && t1.getLeft().isEmpty()){
            return true;
        }
        if(t1.getRight().isEmpty()){
            return isEstableAux(t1.getLeft());
        }
        if(t1.getLeft().isEmpty()){
            return isEstableAux(t1.getRight());
        }
        if(t1.getRoot().compareTo(t1.getLeft().getRoot()) < 0 && t1.getRoot().compareTo(t1.getRight().getRoot()) < 0){
            return false;
        }
        return isEstableAux(t1.getLeft()) && isEstableAux(t1.getRight());

    }

}

