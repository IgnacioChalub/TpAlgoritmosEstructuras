package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SalesFile extends GenericFile{
    public SalesFile(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void write(Sale sale) throws IOException {
        raf.writeUTF(sale.getDestinyCode());
        raf.writeUTF(sale.getArticleCode());
        raf.writeInt(sale.getAmount());
        raf.writeDouble(sale.getPriceInDolaras());
        raf.writeInt(sale.getDay());
        raf.writeInt(sale.getMonth());
        raf.writeInt(sale.getYear());
        updateRegAmount();
    }
    public Sale[] list() throws IOException {
        raf.seek(4); //va a 4 pq el primer int es el reg amount
        Sale[] saleArray = new Sale[regAmount];
        for (int i = 0; i < regAmount; i++) {
            saleArray[i] = readOneRegister();
        }
        return saleArray;
    }

    public Sale readOneRegister() throws IOException {
        return new Sale(raf.readUTF(),raf.readUTF(),raf.readInt(),raf.readDouble(),raf.readInt(),raf.readInt(),raf.readInt());
    }
}
