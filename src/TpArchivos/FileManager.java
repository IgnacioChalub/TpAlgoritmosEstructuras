package TpArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {

    public static void main(String[] args) throws IOException {

        //SalesFile salesFile = new SalesFile("SalesFile");
        //DestinyFile destinyFile = new DestinyFile("DestinyFile");
        PriceFile priceFile = new PriceFile("PriceFile");

        /*Sale[] salesArray = randomSalesArray();
        if(salesFile.isEmpty()){
        for (int i = 0; i < salesArray.length; i++) {
            salesFile.write(salesArray[i]);
        }
        }

        Sale[] allSales = salesFile.list();
        System.out.println("hey");
*/
        Price[] priceArray = createPriceArray();
        priceFile.seek(4);
            for (int i = 0; i < priceArray.length; i++) {
                priceFile.write(priceArray[i]);
            }
        //Price[] allPrice = priceFile.list();
        priceFile.seek(0);
        System.out.println(priceFile.readOneRegister());
        priceFile.list();
        System.out.println("hey");
        /*Price[] allPrice = priceFile.list();
        System.out.println("xd");
        salesFile.close();
        destinyFile.close();
        priceFile.close();*/
    }

    private static Price[] createPriceArray() {
        Price[] priceArray = new Price[12];
        for (int i = 0; i < 12; i++) {
            priceArray[i] = new Price(i+1,i+1);
        }
        return priceArray;
    }

    static Sale[] randomSalesArray(){
        Sale[] salesArray = new Sale[1000];
        for (int i = 0; i < salesArray.length; i++) {
            salesArray[i] = createRandomSale();
        }
        return salesArray;
    }

    static Sale createRandomSale(){
        return new Sale(randomString(3),randomString(5),(int)randDouble(1,1000),randDouble(1,1000), (int) randDouble(1,31),(int) randDouble(1,13), (int)2012);
    }

    public static double randDouble(double bound1, double bound2) {
        //make sure bound2> bound1
        double min = Math.min(bound1, bound2);
        double max = Math.max(bound1, bound2);
        //math.random gives random number from 0 to 1
        return min + (Math.random() * (max - min));
    }

    public static String randomString(int length){
        String allchars = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < length; i++) {
            int randomInt = (int) (Math.random() * 26);
            result += allchars.charAt(randomInt);
        }
        return result;
    }

}
