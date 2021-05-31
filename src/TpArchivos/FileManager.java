package TpArchivos;

import TpArchivos.List.OrderedDynamicList;

import java.io.IOException;

public class FileManager {

    public static void main(String[] args) throws IOException {

        SalesFile salesFile = new SalesFile("SalesFile");
        DestinyFile destinyFile = new DestinyFile("DestinyFile");
        PriceFile priceFile = new PriceFile("PriceFile");

        String[] destinyCodes = createDestinyCodes();

        //Writing destiny file
        Destiny[] destiniesArray = createRandomDestinyArray(destinyCodes);
        if(destinyFile.isEmpty()) {
            destinyFile.seekFirstRegPosition();
            for (int i = 0; i < destiniesArray.length; i++) {
                destinyFile.write(destiniesArray[i]);
            }
        }

        //Writing sales file
        Sale[] salesArray = randomSalesArray(destinyCodes);
        if(salesFile.isEmpty()) {
            salesFile.seekFirstRegPosition();
            for (int i = 0; i < salesArray.length; i++) {
                salesFile.write(salesArray[i]);
            }
        }

        //Writing dollar price file
        Price[] priceArray = createPriceArray();
        if (priceFile.isEmpty()){
            priceFile.seekFirstRegPosition();
            for (int i = 0; i < priceArray.length; i++) {
                priceFile.write(priceArray[i]);
            }
        }

        //Reports:

        Destiny[] destinies = destinyFile.list();
        Price[] dollarPrices = priceFile.list();
        Sale[] sales = salesFile.list();
        OrderedDynamicList<Sale> orderedSales = new OrderedDynamicList<>();

        for (int i = 0; i < sales.length; i++) {
            orderedSales.add(sales[i]);
        }
        System.out.println("Sales by Destiny: " );
        String destinyCode = "";
        float totalSalesAmountEachMonth = 0;
        for (int i = 0; i < sales.length; i++) {
            orderedSales.goTo(i);
            Sale sale = orderedSales.getActual();
            if(!destinyCode.equals(sale.getDestinyCode())) {
                if(i>0) System.out.println("Total sale amount : " + totalSalesAmountEachMonth + "\n");
                totalSalesAmountEachMonth = 0;
                destinyCode = sale.getDestinyCode();
                System.out.println("DESTINY: " + destinyCode);
            }
            float saleAmount = (float)(sale.getPriceInDolaras() * sale.getAmount() * dollarPrices[sale.getMonth() - 1].getDolarPrice());
            totalSalesAmountEachMonth+=saleAmount;
            System.out.println(saleAmount);
        }
        System.out.println("Total sale amount : " + totalSalesAmountEachMonth + "\n");

        OrderedDynamicList<SaleComparedByMonth> orderedSalesMonth = new OrderedDynamicList<>();
        for (int i = 0; i < sales.length; i++) {
            SaleComparedByMonth saleCopy = new SaleComparedByMonth(sales[i]);
            orderedSalesMonth.add(saleCopy);
        }
        System.out.println();
        System.out.println("Sales by Month: " );
        int month = 0;
        for (int i = 0; i < sales.length; i++) {
            orderedSalesMonth.goTo(i);
            SaleComparedByMonth sale = orderedSalesMonth.getActual();
            if(month != sale.getSale().getMonth()) {
                if(i>0) System.out.println("Total sale amount : " + totalSalesAmountEachMonth + "\n");
                totalSalesAmountEachMonth = 0;
                month = sale.getSale().getMonth();
                System.out.println("MONTH " + month);
            }
            float saleAmount = (float)(sale.getSale().getPriceInDolaras() * sale.getSale().getAmount() * dollarPrices[sale.getSale().getMonth() - 1].getDolarPrice());
            totalSalesAmountEachMonth+=saleAmount;
            System.out.println(saleAmount);
        }
        System.out.println("Total sale amount : " + totalSalesAmountEachMonth + "\n");

        salesFile.close();
        destinyFile.close();
        priceFile.close();
    }

    private static Price[] createPriceArray() {
        Price[] priceArray = new Price[12];
        for (int i = 0; i < 12; i++) {
            priceArray[i] = new Price(i+1,randDouble(100,150));
        }
        return priceArray;
    }

    static Sale[] randomSalesArray(String[] destinyCodes){
        Sale[] salesArray = new Sale[1000];
        for (int i = 0; i < salesArray.length; i++) {

            salesArray[i] = createRandomSale(destinyCodes[(int)(Math.random() * 30)]);
        }
        return salesArray;
    }

    static Sale createRandomSale(String destinyCode){
        return new Sale(destinyCode,randomString(5),(int)randDouble(1,10),randDouble(10,20), (int) randDouble(1,31),(int) randDouble(1,13), 2012);
    }

    public static double randDouble(double bound1, double bound2) {
        //make sure bound2 > bound1
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

    public static Destiny[] createRandomDestinyArray(String[] destinyCodes){
        Destiny[] destinies = new Destiny[30];
        for (int i = 0; i < destinies.length; i++) {
            destinies[i] = new Destiny(destinyCodes[i],randomString(100));
        }
        return destinies;
    }


    public static String[] createDestinyCodes(){
        String[] codes = new String[30];
        for (int i = 0; i < codes.length; i++) {
            codes[i] = randomString(3);
        }
        return codes;
    }

}
