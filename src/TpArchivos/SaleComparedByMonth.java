package TpArchivos;

public class SaleComparedByMonth implements Comparable<SaleComparedByMonth> {
    Sale sale;
    public SaleComparedByMonth(Sale sale) {
        this.sale = sale;
    }

    public Sale getSale() {
        return sale;
    }

    public int compareTo(SaleComparedByMonth s) {
        return sale.getMonth() - s.getSale().getMonth();
    }
}
