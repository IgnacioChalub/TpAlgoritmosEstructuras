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
    public boolean equals(BinaryTree<T> t1, BinaryTree<T> t2) {
        if ((t1.isEmpty() && !t2.isEmpty()) || (!t1.isEmpty() && t2.isEmpty())) {
            return false;
        }
        if (t1.isEmpty() && t2.isEmpty()) {
            return true;
        }
        if(t1.getRoot().equals(t2.getRoot())){
            return equals(t1.getLeft(),t2.getLeft()) && equals(t1.getRight(), t2.getRight());
        }
        return false;
    }

    public boolean isomorph(BinaryTree<T> t1, BinaryTree<T> t2) {
        if ((t1.isEmpty() && !t2.isEmpty()) || (!t1.isEmpty() && t2.isEmpty())) {
            return false;
        }
        if (t1.isEmpty() && t2.isEmpty()) {
            return true;
        }
        return isomorph(t1.getLeft(), t2.getLeft()) && isomorph(t1.getRight(), t2.getRight());
    }

    public boolean areSimilar(BinaryTree<T> t1, BinaryTree<T> t2) {
        return (size(t1) == size(t2)) && included(t1,t2);
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

    public boolean included(BinaryTree<T> t1, BinaryTree<T> t2){ // verifica si t1 esta incluido en t2
        if(t1.isEmpty()){
            return true;
        }
        if(ocurrencias(t2,t1.getRoot()) == 1){
            return included(t1.getLeft(), t2) && included(t1.getRight(), t2);
        }
        return false;
    }
    public boolean occuresBinaryTree(BinaryTree<T> t1, BinaryTree<T> t2){
        if(size(t2) > size(t1)){
            return false;
        }
        if(t1.getRoot().equals(t2.getRoot())){
            if(t2.getRight().isEmpty() && t2.getLeft().isEmpty()){
                return true;
            }
            if(t2.getLeft().isEmpty()){
                return occuresBinaryTree(t1.getRight(), t2.getRight());
            }
            if(t2.getRight().isEmpty()){
                return occuresBinaryTree(t1.getLeft(), t2.getLeft());
            }
            return occuresBinaryTree(t1.getLeft(),t2.getLeft()) && occuresBinaryTree(t1.getRight(),t2.getRight());
        }
        return occuresBinaryTree(t1.getLeft(), t2) || occuresBinaryTree(t1.getRight(), t2);
    }

    public void showFrontier(BinaryTree<T> t1){
        if(t1.isEmpty()){
            return;
        }
        if(t1.getLeft().isEmpty() && t1.getRight().isEmpty()){
            System.out.println(t1.getRoot().toString());
        }
        showFrontier(t1.getRight());
        showFrontier(t1.getLeft());
    }

}

