package model;

public class Ticket {
    private final String code;
    private final String performanceKey;
    private final String performanceName;
    private final String date;
    private final int hallId;
    private final int row;
    private final int seat;
    private TicketStatus status;
    private final String note;

    public Ticket(String code, String performanceKey, String performanceName, String date,
                  int hallId, int row, int seat, TicketStatus status, String note) {
        this.code = code; this.performanceKey = performanceKey; this.performanceName = performanceName;
        this.date = date; this.hallId = hallId; this.row = row; this.seat = seat;
        this.status = status; this.note = note;
    }
    public String getCode() {
        return code;
    }
    public String getPerformanceKey() {
        return performanceKey;
    }
    public String getPerformanceName() {
        return performanceName;
    }
    public String getDate() {
        return date;
    }
    public int getHallId() {
        return hallId;
    }
    public int getRow() {
        return row;
    }
    public int getSeat() {
        return seat;
    }
    public TicketStatus getStatus() {
        return status;
    }
    public String getNote() {
        return note;
    }
    public void sell() {
        status = TicketStatus.SOLD;
    }
    public boolean isAt(int hall, int row, int seat) {
        return hallId == hall && this.row == row && this.seat == seat;
    }
    public String toString() {
        return code + " " + performanceName + " " + date + " seat=" + row + ":" + seat + " " + status;
    }
}
