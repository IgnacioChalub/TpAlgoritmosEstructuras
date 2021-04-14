package ArbolesBinarios;

import java.util.ArrayList;
import java.util.List;

public class TreeApi <T extends Comparable> {

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

    public void inorden(BinaryTree<T> a) { //goes through the tree inorden and prints the values in the roots
        if (!a.isEmpty()) {
            inorden(a.getLeft());
            System.out.println(a.getRoot());
            inorden(a.getRight());
        }
    }

    public void inorden(BinaryTree<T> a, ArrayList<T> ar) { //fills an arraylist with the inorden path
        if (!a.isEmpty()) {
            inorden(a.getLeft(), ar);
            ar.add(a.getRoot());
            inorden(a.getRight(), ar);
        }
    }

    public void byLevel(BinaryTree<T> t) throws IsEmptyException {
        BinaryTree<T> a = new BinaryTree<>();
        QueueDynamic<BinaryTree<T>> q = new QueueDynamic<>();
        q.enqueue(t);
        while(!q.isEmpty()){
            a = q.dequeue();
            System.out.println(a.getRoot());
            if(!a.getLeft().isEmpty()){
                q.enqueue(a.getLeft());
            }
            if(!a.getRight().isEmpty()){
                q.enqueue(a.getRight());
            }
        }
    }

    public void postorden(BinaryTree<T> bt){
        if(!bt.isEmpty()){
            postorden(bt.getLeft());
            postorden(bt.getRight());
            System.out.println(bt.getRoot());
        }
    }

    public void postorden(BinaryTree<T> bt, ArrayList<T> ar){
        if(!bt.isEmpty()){
            postorden(bt.getLeft());
            postorden(bt.getRight());
            ar.add(bt.getRoot());
        }
    }

    public void preorden(BinaryTree<T> bt){
        if(!bt.isEmpty()){
            System.out.println(bt.getRoot());
            preorden(bt.getLeft());
            preorden(bt.getRight());
        }
    }

    public void preorden(BinaryTree<T> bt, ArrayList<T> ar){
        if(!bt.isEmpty()){
            ar.add(bt.getRoot());
            preorden(bt.getLeft());
            preorden(bt.getRight());
        }
    }
    public int weight(BinaryTree<T> a) { //same as size
        if (a.isEmpty()) {
            return 1;
        }
        return 1 + size(a.getLeft()) + size(a.getRight());
    }

    public int leaves(BinaryTree<T> a) {//returns the ammount of leaves in the tree
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        }
        return leaves(a.getLeft()) + leaves(a.getRight());
    }

    public int occurrences(BinaryTree<T> a, T o) {//returns the number of times a certain object o appears in a tree by comparing with .comparesTo()
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot().equals(o)) {
            return 1 + occurrences(a.getLeft(), o) + occurrences(a.getRight(), o);
        } else {
            return occurrences(a.getLeft(), o) + occurrences(a.getRight(), o);
        }
    }

    public int elementsInLevel(BinaryTree<T> a, int level) {//returns the ammount of elements in a certain level
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

    public int heightAux(BinaryTree<T> a) {//returns the longest path in the tree
        if (a.isEmpty()) {
            return 0;
        }
        if (heightAux(a.getLeft()) > heightAux(a.getRight())) {
            return 1 + heightAux(a.getLeft());
        }
        return 1 + heightAux(a.getRight());
    }

    public int sumElements(BinaryTree<Integer> a) {//The total sum of all the elements in a BinaryTree filled with Integers
        if (a.isEmpty()) {
            return 0;
        }
        return a.getRoot() + sumElements(a.getLeft()) + sumElements(a.getRight());
    }

    public int sumElementsThreeMultiple(BinaryTree<Integer> a) {//the total sum of the multiples of three in a Binary Tree of Integers
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot() % 3 == 0) {
            return a.getRoot() + sumElementsThreeMultiple(a.getLeft()) + sumElementsThreeMultiple(a.getRight());
        }
        return sumElementsThreeMultiple(a.getLeft()) + sumElementsThreeMultiple(a.getRight());
    }
    public boolean equals(BinaryTree<T> t1, BinaryTree<T> t2) {//two trees are equal if they have the same elements organized in the same structure
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

    public boolean isomorph(BinaryTree<T> t1, BinaryTree<T> t2) {//two trees are isomorph if they have the same structure
        if ((t1.isEmpty() && !t2.isEmpty()) || (!t1.isEmpty() && t2.isEmpty())) {
            return false;
        }
        if (t1.isEmpty() && t2.isEmpty()) {
            return true;
        }
        return isomorph(t1.getLeft(), t2.getLeft()) && isomorph(t1.getRight(), t2.getRight());
    }

    public boolean areSimilar(BinaryTree<T> t1, BinaryTree<T> t2) {//two trees are similar if they have the same elements.
        return (size(t1) == size(t2)) && included(t1,t2);
    }
    public boolean isComplete(BinaryTree<T> a) {//a tree is complete if all of their nodes are leaves or have two children. There isnt any node with only one child
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

    public boolean isFull(BinaryTree<T> t1){//a tree is full if all of its leaves are in the same level
        if(Math.pow(2,height(t1)) == elementsInLevel(t1, height(t1))){
            return true;
        }
        return false;
    }

    public boolean isStable(BinaryTree<T> t1){//a tree is stable if all of the children are less than their parents by using compareTo()
        if(t1.isEmpty() || size(t1) == 1){
            return true;
        }
        return isStableAux(t1);
    }

    private boolean isStableAux(BinaryTree<T> t1){
        if(t1.getRight().isEmpty() && t1.getLeft().isEmpty()){
            return true;
        }
        if(t1.getRight().isEmpty()){
            return isStableAux(t1.getLeft());
        }
        if(t1.getLeft().isEmpty()){
            return isStableAux(t1.getRight());
        }
        if(t1.getRoot().compareTo(t1.getLeft().getRoot()) < 0 && t1.getRoot().compareTo(t1.getRight().getRoot()) < 0){
            return false;
        }
        return isStableAux(t1.getLeft()) && isStableAux(t1.getRight());
    }

    public boolean included(BinaryTree<T> t1, BinaryTree<T> t2){ //verifies if t1 is included in t2. t1 is included if all of its elements appear only once in t2
        if(t1.isEmpty()){
            return true;
        }
        if(occurrences(t2,t1.getRoot()) == 1){
            return included(t1.getLeft(), t2) && included(t1.getRight(), t2);
        }
        return false;
    }
    public boolean occursBinaryTree(BinaryTree<T> t1, BinaryTree<T> t2){//returns true if t2 is included in t1
        if(size(t2) > size(t1)){
            return false;
        }
        if(t1.getRoot().equals(t2.getRoot())){
            if(t2.getRight().isEmpty() && t2.getLeft().isEmpty()){
                return true;
            }
            if(t2.getLeft().isEmpty()){
                return occursBinaryTree(t1.getRight(), t2.getRight());
            }
            if(t2.getRight().isEmpty()){
                return occursBinaryTree(t1.getLeft(), t2.getLeft());
            }
            return occursBinaryTree(t1.getLeft(),t2.getLeft()) && occursBinaryTree(t1.getRight(),t2.getRight());
        }
        return occursBinaryTree(t1.getLeft(), t2) || occursBinaryTree(t1.getRight(), t2);
    }

    public void showFrontier(BinaryTree<T> t1){//prints all the elements stored in leaves
        if(t1.isEmpty()){
            return;
        }
        if(t1.getLeft().isEmpty() && t1.getRight().isEmpty()){
            System.out.println(t1.getRoot().toString());
        }
        showFrontier(t1.getRight());
        showFrontier(t1.getLeft());
    }
    public void frontier(BinaryTree<T> t, ArrayList<T> frontierElements){
        if(t.isEmpty()){
            return;
        }
        if(t.getLeft().isEmpty() && t.getRight().isEmpty()){
            frontierElements.add(t.getRoot());
        }
        frontier(t.getRight(),frontierElements);
        frontier(t.getLeft(),frontierElements);
    }

}

