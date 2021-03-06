package ArbolesBinarios.Testing;

import ArbolesBinarios.BinaryTree;
import ArbolesBinarios.IsEmptyException;
import ArbolesBinarios.TreeApi;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IsEmptyException { //Ejemplo del arbol binario con el objeto book
        Book l1 = new Book(12, "Hamlet", 230);
        Book l2 = new Book(25, "Muerte en las nubes", 321);
        Book l3 = new Book(22, "El precio de la intriga", 530);
        Book l4 = new Book(75, "Romeo y Julieta", 199);
        Book l5 = new Book(56, "La isla del tesoro", 452);
        Book l6 = new Book(64, "El anillo", 520);
        Book l7 = new Book(90, "El doctor Zhivago", 930);

        TreeApi<Book> api = new TreeApi<Book>();

        BinaryTree<Book> t1 = new BinaryTree<Book>(l7);

        BinaryTree <Book> t2 = new BinaryTree<Book>(l5);

        BinaryTree <Book> t3 = new BinaryTree<Book>(l6,t1,new BinaryTree<Book>());

        BinaryTree <Book> t4 = new BinaryTree<Book>( l4, t3,t2);

        BinaryTree <Book> t5 = new BinaryTree<Book>(l2,t4,new BinaryTree<Book>());

        BinaryTree <Book> t6 = new BinaryTree<Book>(l3,new BinaryTree<Book>(),t2);

        BinaryTree <Book> t7 = new BinaryTree<Book>(l1,t5,t6);

        BinaryTree <Book> t7Copy = new BinaryTree<>(l1,t5,t6);

        BinaryTree <Book> t7FalseCopy = new BinaryTree<>(l1,t5,new BinaryTree<Book>());

        BinaryTree<Integer> i1 = new BinaryTree<>(3,new BinaryTree<Integer>(5,new BinaryTree<Integer>(6),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1),new BinaryTree<>(4)));


        System.out.println(api.size(t7));
        System.out.println("__________");

        api.inorden(t7);

        System.out.println("__________");

        api.postorden(t7);

        System.out.println("__________");

        api.preorden(t7);

        System.out.println("__________");

        try{
            api.byLevel(t7);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println("__________");
        System.out.println(api.occurrences(t7, l5));

        System.out.println(api.occurrences(t7, new Book(100, "zzz", 200)));

        ArrayList<Book> books = new ArrayList<Book>();

        api.inorden(t7, books);

        for (int i= 0; i < books.size();i++) {
            System.out.println(books.get(i).getCode() + "  " + books.get(i).getTitle());
        }
        System.out.println("__________");
        System.out.println(api.completeNodes(t7));

        System.out.println("__________");
        System.out.println(api.leaves(t7));

        System.out.println("__________");
        System.out.println(api.elementsInLevel(t7,0));
        System.out.println(api.elementsInLevel(t7,2));
        System.out.println(api.elementsInLevel(t7,4));

        System.out.println("__________");
        System.out.println(api.height(t7) + " 4");
        System.out.println(api.height(t5)+ " 3");

        System.out.println("__________");
        System.out.println(api.equals(t7,t7Copy) + " True");
        System.out.println(api.equals(t7,t7FalseCopy) + " False");

        System.out.println("__________");
        System.out.println(api.sumElements(i1) + " 21");
        System.out.println(api.sumElementsThreeMultiple(i1) + " 9");

        System.out.println("__________");
        System.out.println(api.isomorph(t7,t7) + " True");
        System.out.println(api.isomorph(t5,t7) + " False");

        System.out.println("__________");
        System.out.println(api.isComplete(t1));
        System.out.println(api.isComplete(t3));
        System.out.println(api.isComplete(t4));
        System.out.println(api.isComplete(t5));
        System.out.println(api.isComplete(new BinaryTree<Book>()));
        System.out.println("__________");
        System.out.println(api.areSimilar(t1,t2));
        System.out.println(api.areSimilar(t7,t7Copy));

        System.out.println("__________");
        System.out.println(api.isFull(t1));
        System.out.println(api.isFull(t3));
        System.out.println(api.isFull(t4));
        System.out.println(api.isFull(t5));

        System.out.println("__________");
        System.out.println(api.isStable(t1));//true
        System.out.println(api.isStable(t3));//false
        System.out.println(api.isStable(t4));//
        System.out.println(api.isStable(t5));

        System.out.println("__________");
        System.out.println(api.occursBinaryTree(t1, t2));//false
        System.out.println(api.occursBinaryTree(t3, t2));//false
        System.out.println(api.occursBinaryTree(t3,t1));//true
        System.out.println(api.occursBinaryTree(t7,t4));//true
        System.out.println(api.occursBinaryTree(t5,t6));//false
        System.out.println(api.occursBinaryTree(t4,t2));//true

        System.out.println("__________");
        api.showFrontier(t1);
        System.out.println("__________");
        api.showFrontier(t2);
        System.out.println("__________");
        api.showFrontier(t3);
        System.out.println("__________");
        api.showFrontier(t4);
        System.out.println("__________");
        api.showFrontier(t5);
        System.out.println("__________");
        api.showFrontier(t6);
        System.out.println("__________");
        api.showFrontier(t7);

        ArrayList<Book> bookArrayList = new ArrayList<>();
        api.frontier(t7,bookArrayList);
        for (int i = 0; i < bookArrayList.size(); i++) {
            System.out.println(bookArrayList.get(i).getTitle());
        }
        try {
            api.byLevel(t7);
        }catch (IsEmptyException e){
            System.out.println(e.getMessage());
        }
    }
}
