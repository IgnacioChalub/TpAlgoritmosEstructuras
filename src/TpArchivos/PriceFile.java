package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PriceFile extends GenericFile{
    public PriceFile(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public void write(Price price) throws IOException {
        raf.writeInt(price.getMonth());
        raf.writeInt(price.getDolarPrice());
        updateRegAmount();
    }

    /*public Price[] list() throws IOException {
        raf.seek(4);
        Price[] priceArray = new Price[getRegAmount()];
        for (int i = 0; i < getRegAmount(); i++) {
            priceArray[i] = readOneRegister();
        }
        return priceArray;
    }*/

    public void list() throws IOException {
        raf.seek(4);
        Price p;
        try {
            PriceFile archP = new PriceFile("PriceFile");
            long cant = archP.getRegAmount();
            for (long i = 0; i < cant ; i++){
                p = archP.readOneRegister();
                System.out.println(p.getMonth() + "  " + p.getDolarPrice());
           }
            archP.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public Price readOneRegister() throws IOException {
        return new Price(raf.readInt(),raf.readInt());
    }

}
