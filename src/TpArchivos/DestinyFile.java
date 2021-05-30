package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DestinyFile extends GenericFile{

    public DestinyFile(String fileName) throws IOException {
        super(fileName);
    }

    public void writeDestiny(Destiny destiny) throws IOException {
        raf.writeUTF(destiny.getDestinyCode());
        raf.writeUTF(destiny.getDescription());
        updateRegAmount();
    }
    public Destiny[] list() throws IOException {
        raf.seek(0);
        Destiny[] destinyArray = new Destiny[getRegAmount()];
        for (int i = 0; i < getRegAmount(); i++) {
            destinyArray[i] = ReadOneRegister();
        }
        return destinyArray;
    }

    public Destiny ReadOneRegister() throws IOException {
        return new Destiny(raf.readUTF(),raf.readUTF());
    }
}
