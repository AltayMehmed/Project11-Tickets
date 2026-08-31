package model;

public class TicketCodeGenerator {
    private int next = 1;
    public String nextCode() {
        return "24621650-" + String.format("%04d", next++);
    }
}
