package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DestinyFile extends GenericFile{

    public DestinyFile(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void write(Destiny destiny) throws IOException {
        raf.writeUTF(destiny.getDestinyCode());
        raf.writeUTF(destiny.getDescription());
        updateRegAmount();
    }
    public Destiny[] list() throws IOException {
        raf.seek(4);
        Destiny[] destinyArray = new Destiny[regAmount];
        for (int i = 0; i < regAmount; i++) {
            destinyArray[i] = readOneRegister();
        }
        return destinyArray;
    }

    public Destiny readOneRegister() throws IOException {
        return new Destiny(raf.readUTF(),raf.readUTF());
    }
}
