package org.lesson.java.gestore_eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String title;
    private LocalDate eventDate;
    private LocalDate presentDate;
    private int totalSeat;
    private int reservedSeat = 0;

    public Evento(String title, LocalDate eventDate, LocalDate presentDate, int totalSeat) {
        setTitle(title);
        setEventDate(eventDate);
        setPresentDate(presentDate);
        this.totalSeat = totalSeat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate date) {
        this.eventDate = date;
    }

    public int getReservedSeat() {
        return reservedSeat;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

   protected LocalDate getPresentDate() {
        return presentDate;
    }

    private void setPresentDate(LocalDate presentDate) {
        this.presentDate = presentDate;
    }

    public void reserve() throws Exception {
        if(eventDate.isBefore(getPresentDate())) {
            throw new Exception("L'evento è già stato fatto");
        }else {
            if(getReservedSeat() < getTotalSeat()) {
                this.reservedSeat += 1;
            }else {
                throw new Exception("Posti esauriti");
            }
        }
    }

    public void removeReservation() throws Exception {
        if(eventDate.isBefore(getPresentDate())) {
            throw new Exception("L'evento è già stato fatto");
        }else {
            if(getReservedSeat() > 0) {
                this.reservedSeat -= 1;
            }else {
                throw new Exception("Tutti i posti sono prenotati");
            }
        }

    }

    @Override
    public String toString() {
        return formattedDate(getEventDate()) + " - " + getTitle();

    }

    private String formattedDate(LocalDate date) {
        DateTimeFormatter selectedFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(selectedFormat);
    }

}