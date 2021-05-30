package TpArchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class GenericFile {

    File file;
    RandomAccessFile raf;
    int regAmount;

    public GenericFile(String fileName) throws FileNotFoundException {
        this.file = new File(fileName);
        this.raf = new RandomAccessFile(file,"rw");
        try {
            raf.seek(0);
            this.regAmount = raf.readInt();
        } catch (IOException e) {
            this.regAmount = 0;
        }
    }

    public void close() throws IOException {
        raf.close();
    }

    public int getRegAmount(){
        return regAmount;
    }


    public void updateRegAmount() throws IOException {
        regAmount++;
        raf.seek(0);
        raf.writeInt(regAmount);
        raf.seek(file.length()-1);
    }

    public boolean isEmpty(){
        return regAmount == 0;
    }


}
