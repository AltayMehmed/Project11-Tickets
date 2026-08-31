package services;

import model.*;

public class ReportService {
    public void print(CinemaData data, String date) {
        System.out.println("Report for " + date);
        for (Performance p : data.getPerformances()) if (p.getDate().equals(date)) {
            int sold=0;
            for(Ticket t:data.getTickets().getTickets()) if(t.getPerformanceKey().equals(p.key()) && t.getStatus()==TicketStatus.SOLD) sold++;
            System.out.println(p + " -> sold: " + sold);
        }
    }
}
