package TablasDeDispersion;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Dictionary {
    HashTableOpen hashTable;

    public Dictionary(){
        hashTable = new HashTableOpen(1000);
    }

    public void createTable(RandomAccessFile raf,int size) throws IOException {
        for (int i = 0; i < size; i++) {
            Word w = new Word(raf.readLine());
            hashTable.insert(w);
        }
    }
    public void shownNotIncludedWords(RandomAccessFile raf,int size) throws IOException {
        for (int i = 0; i < size; i++) {
            Word w = new Word(raf.readLine());
            if(hashTable.search(w) == w){
                System.out.println(w.word);
            }
        }
    }

}
