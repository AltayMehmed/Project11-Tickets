package repository;

import exceptions.FileFormatException;
import model.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

public class XmlRepository {
    public void save(String path, CinemaData data) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = doc.createElement("cinema"); doc.appendChild(root);
        Element events = doc.createElement("performances"); root.appendChild(events);
        for (Performance p : data.getPerformances()) {
            Element e = doc.createElement("performance");
            e.setAttribute("name", p.getName()); e.setAttribute("date", p.getDate()); e.setAttribute("hall", String.valueOf(p.getHallId()));
            events.appendChild(e);
        }
        Element tickets = doc.createElement("tickets"); root.appendChild(tickets);
        for (Ticket t : data.getTickets().getTickets()) {
            Element e = doc.createElement("ticket");
            e.setAttribute("code", t.getCode()); e.setAttribute("performance", t.getPerformanceKey());
            e.setAttribute("name", t.getPerformanceName()); e.setAttribute("date", t.getDate());
            e.setAttribute("hall", String.valueOf(t.getHallId())); e.setAttribute("row", String.valueOf(t.getRow()));
            e.setAttribute("seat", String.valueOf(t.getSeat())); e.setAttribute("status", t.getStatus().name());
            e.setAttribute("note", t.getNote() == null ? "" : t.getNote()); tickets.appendChild(e);
        }
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(new File(path)));
    }

    public void load(String path, CinemaData data) throws FileFormatException {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
            data.getPerformances().clear(); data.getTickets().clear();
            NodeList ps = doc.getElementsByTagName("performance");
            for (int i=0;i<ps.getLength();i++) {
                Element e=(Element)ps.item(i);
                data.getPerformances().add(new Performance(e.getAttribute("name"),e.getAttribute("date"),Integer.parseInt(e.getAttribute("hall"))));
            }
            NodeList ts=doc.getElementsByTagName("ticket");
            for(int i=0;i<ts.getLength();i++) {
                Element e=(Element)ts.item(i);
                data.getTickets().add(new Ticket(e.getAttribute("code"),e.getAttribute("performance"),e.getAttribute("name"),e.getAttribute("date"),
                    Integer.parseInt(e.getAttribute("hall")),Integer.parseInt(e.getAttribute("row")),Integer.parseInt(e.getAttribute("seat")),
                    TicketStatus.valueOf(e.getAttribute("status")),e.getAttribute("note")));
            }
        } catch(Exception e) { throw new FileFormatException("Invalid XML file", e); }
    }
}
