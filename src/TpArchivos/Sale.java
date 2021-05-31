package TpArchivos;

public class Sale implements Comparable<Sale> {

    private String destinyCode;
    private String articleCode;
    private int amount;
    private double priceInDolaras;
    private int day;
    private int month;
    private int year;

    public Sale(String destinyCode, String articleCode, int amount, double priceInDolaras, int day, int month, int year) {
        this.destinyCode = destinyCode;
        this.articleCode = articleCode;
        this.amount = amount;
        this.priceInDolaras = priceInDolaras;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDestinyCode() {
        return destinyCode;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public int getAmount() {
        return amount;
    }

    public double getPriceInDolaras() {
        return priceInDolaras;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Sale o) {
        return destinyCode.compareTo(o.destinyCode);
    }
}
