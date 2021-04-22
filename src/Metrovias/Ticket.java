package Metrovias;

public class Ticket {
    private Integer ticketNumber;
    private Integer attentionTime;


    public Ticket(Integer ticketNumber, Integer attentionTime) {
        this.ticketNumber = ticketNumber;
        this.attentionTime = attentionTime;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public Integer getAttentionTime() {
        return attentionTime;
    }

    public String toString(){
        return "Ticket number: " + ticketNumber + ". Atention time: " + attentionTime + ". ";
    }
}
