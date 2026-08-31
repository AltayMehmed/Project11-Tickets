package model;

import java.util.ArrayList;
import java.util.List;

public class TicketRegistry {
    private final List<Ticket> tickets = new ArrayList<>();
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void clear() {
        tickets.clear();
    }
    public void add(Ticket ticket) {
        tickets.add(ticket);
    }
    public Ticket find(String code) {
        for (Ticket t : tickets) if (t.getCode().equals(code)) return t;
        return null;
    }
    public Ticket findAt(String performanceKey, int hall, int row, int seat) {
        for (Ticket t : tickets) if (t.getPerformanceKey().equals(performanceKey) && t.isAt(hall,row,seat)) return t;
        return null;
    }
}
