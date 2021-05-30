package TpArchivos;

public class Price {

    private int month;
    private int dolarPrice;

    public Price(int month, int dolarPrice){
        this.month = month;
        this.dolarPrice = dolarPrice;
    }

    public int getMonth() {
        return month;
    }

    public int getDolarPrice() {
        return dolarPrice;
    }
}
