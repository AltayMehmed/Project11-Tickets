package services;

import model.*;
import java.util.HashMap;
import java.util.Map;

public class StatisticsService {
    public void print(CinemaData data) {
        Map<String,Integer> count=new HashMap<>();
        for(Ticket t:data.getTickets().getTickets()) if(t.getStatus()==TicketStatus.SOLD)
            count.put(t.getPerformanceName(),count.getOrDefault(t.getPerformanceName(),0)+1);
        System.out.println("Statistics:");
        for(String name:count.keySet()) System.out.println(name+" -> "+count.get(name));
    }
}
