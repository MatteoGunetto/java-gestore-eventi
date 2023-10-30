package org.lesson.java.gestore_eventi;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProgrammEventi {
    private String title;
    private ArrayList<Evento> events;

    public ProgrammEventi(String title) {
        setTitle(title);
        this.events = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addEvent(Evento event) {
        this.events.add(event);
    }

    public ArrayList<Evento> getEventsOnDate(LocalDate date){
        return (ArrayList<Evento>) this.events.stream().filter(x -> x.getEventDate() == date).collect(Collectors.toList());
    }

    public int getTotal() {
        return (int)this.events.stream().count();
    }

    public void clearEvents() {
        this.events.clear();
    }

    public void printEvents() {
        System.out.println(getTitle());
        for (Evento event : events) {
            System.out.println(" -> " + event.getEventDate() + " | " + event.getTitle());
        }
    }
}