package model;

import java.util.ArrayList;
import java.util.List;

public class CinemaData {
    private final List<Hall> halls = new ArrayList<>();
    private final List<Performance> performances = new ArrayList<>();
    private final TicketRegistry tickets = new TicketRegistry();

    public CinemaData() {
        halls.add(new Hall(1, 8, 12));
        halls.add(new Hall(2, 10, 15));
        halls.add(new Hall(3, 12, 20));
    }
    public List<Hall> getHalls() { return halls; }
    public List<Performance> getPerformances() { return performances; }
    public TicketRegistry getTickets() { return tickets; }
    public Performance findPerformance(String name, String date) {
        for (Performance p : performances)
            if (p.getName().equalsIgnoreCase(name) && p.getDate().equals(date)) return p;
        return null;
    }
    public Hall findHall(int id) {
        for (Hall h : halls) if (h.getId() == id) return h;
        return null;
    }
}
