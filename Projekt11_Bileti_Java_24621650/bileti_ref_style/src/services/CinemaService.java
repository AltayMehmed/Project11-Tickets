package services;

import exceptions.CommandException;
import model.*;
import repository.XmlRepository;
import util.DateValidator;

import java.io.File;

public class CinemaService {
    private final int facultyNumber;
    private CinemaData data = new CinemaData();
    private final XmlRepository repository = new XmlRepository();
    private final TicketCodeGenerator codeGenerator = new TicketCodeGenerator();
    private final HelpService helpService = new HelpService();
    private final ReportService reportService = new ReportService();
    private final StatisticsService statisticsService = new StatisticsService();
    private String activeFile;

    public CinemaService(int facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
    private void requireOpen() throws CommandException {
        if(activeFile==null) throw new CommandException("No file is open.");
    }

    public void help(){ helpService.print(); }
    public void open(String path) throws Exception {
        if(new File(path).exists()) repository.load(path,data); else repository.save(path,data);
        activeFile=path; System.out.println("Opened: "+path);
    }
    public void close(){
        activeFile=null; data=new CinemaData(); System.out.println("Closed.");
    }
    public void save() throws Exception {
        requireOpen(); repository.save(activeFile,data); System.out.println("Saved.");
    }
    public void saveAs(String path) throws Exception {
        requireOpen(); repository.save(path,data); activeFile=path; System.out.println("Saved as: "+path);
    }
    public void addEvent(String[] a) throws CommandException {
        require(a,3); DateValidator.validate(a[1]); int hall=Integer.parseInt(a[2]);
        if(data.findHall(hall)==null) throw new CommandException("Invalid hall.");
        if(data.findPerformance(a[0],a[1])!=null) throw new CommandException("Performance already exists.");
        data.getPerformances().add(new Performance(a[0],a[1],hall)); System.out.println("Performance added.");
    }
    public void freeSeats(String[] a) throws CommandException {
        require(a,2); Performance p=find(a[0],a[1]); Hall h=data.findHall(p.getHallId());
        int free=0;
        for(int r=1;r<=h.getRows();r++)
            for(int s=1;s<=h.getSeatsPerRow();s++)
            if(data.getTickets().findAt(p.key(),h.getId(),r,s)==null) free++;
        System.out.println("Free seats: "+free);
    }
    public void book(String[] a) throws CommandException {
        createTicket(a,TicketStatus.RESERVED);
    }
    public void buy(String[] a) throws CommandException {
        createTicket(a,TicketStatus.SOLD);
    }
    private void createTicket(String[] a, TicketStatus status) throws CommandException {
        require(a,4); Performance p=find(a[0],a[1]);
        int row=Integer.parseInt(a[2]), seat=Integer.parseInt(a[3]);
        Hall h=data.findHall(p.getHallId());
        if(!h.validSeat(row,seat))
            throw new CommandException("Invalid seat.");
        if(data.getTickets().findAt(p.key(),h.getId(),row,seat)!=null)
            throw new CommandException("Seat is occupied.");
        String note=a.length>4?a[4]:"";
        Ticket t=new Ticket(codeGenerator.nextCode(),p.key(),p.getName(),p.getDate(),h.getId(),row,seat,status,note); data.getTickets().add(t);
        System.out.println("Ticket: "+t.getCode());
    }
    public void unbook(String[] a) throws CommandException {
        require(a,4); Performance p=find(a[0],a[1]); Ticket t=data.getTickets().findAt(p.key(),p.getHallId(),Integer.parseInt(a[2]),Integer.parseInt(a[3]));
        if(t==null || t.getStatus()!=TicketStatus.RESERVED) throw new CommandException("Reservation not found.");
        data.getTickets().getTickets().remove(t); System.out.println("Reservation cancelled.");
    }
    public void bookings() throws CommandException { requireOpen();
        for(Ticket t:data.getTickets().getTickets())
            if(t.getStatus()==TicketStatus.RESERVED) System.out.println(t); }
    public void check(String code) throws CommandException {
        requireOpen(); Ticket t=data.getTickets().find(code);
            if(t==null)
                throw new CommandException("Invalid ticket code.");
        System.out.println(t); }
    public void report(String[] a) throws CommandException {
        require(a,1);
        reportService.print(data,a[0]);
        statisticsService.print(data); }
    private Performance find(String name,String date) throws CommandException { Performance p=data.findPerformance(name,date);
        if(p==null) throw new CommandException("Performance not found.");
        return p; }
    private void require(String[] a,int n)
            throws CommandException { requireOpen();
        if(a.length<n)
            throw new CommandException("Not enough arguments."); }
}
