package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PriceFile extends GenericFile{
    public PriceFile(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void write(Price price) throws IOException {
        raf.writeInt(price.getMonth());
        raf.writeDouble(price.getDolarPrice());
        updateRegAmount();
    }

    public Price[] list() throws IOException {
        raf.seek(4);
        Price[] priceArray = new Price[regAmount];
        for (int i = 0; i < regAmount; i++) {
            priceArray[i] = readOneRegister();
        }
        return priceArray;
    }

    public Price readOneRegister() throws IOException {
        return new Price(raf.readInt(),raf.readDouble());
    }

}
