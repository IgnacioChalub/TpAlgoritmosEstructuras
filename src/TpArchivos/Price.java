package TpArchivos;

public class Price {

    private int month;
    private double dolarPrice;

    public Price(int month, double dolarPrice){
        this.month = month;
        this.dolarPrice = dolarPrice;
    }

    public int getMonth() {
        return month;
    }

    public double getDolarPrice() {
        return dolarPrice;
    }
}
