package org.lesson.java.gestore_eventi;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

    private LocalTime eventHour;
    private LocalTime presentHour;
    private BigDecimal price;

    public Concerto(String title, LocalDate eventDate, LocalDate presentDate, int totalSeat, LocalTime hour, LocalTime presentHour, BigDecimal price) {
        super(title, eventDate, presentDate, totalSeat);
        setHour(hour);
        setPresentHour(presentHour);
        setPrice(price);
    }

    public LocalTime getHour() {
        return eventHour;
    }

    public void setHour(LocalTime hour) {
        this.eventHour = hour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalTime getPresentHour() {
        return presentHour;
    }

    public void setPresentHour(LocalTime presentHour) {
        this.presentHour = presentHour;
    }

    @Override
    public void reserve() throws Exception {
        if(getPresentHour().isBefore(getHour()) && super.getPresentDate().isBefore(getEventDate())){
            throw new Exception("Il concerto è finito");
        }else {
            super.reserve();
        }
    }

    @Override
    public void removeReservation() throws Exception {
        if(getPresentHour().isBefore(getHour()) && super.getPresentDate().isBefore(getEventDate())){
            throw new Exception("Il concerto è già stato fatto ");
        }else {
            super.removeReservation();
        }

    }

    @Override
    public String toString() {
        return super.toString() + " - " + formattedPrice();
    }

    private String formattedPrice() {
        String priceStr = "" + getPrice();
        priceStr = priceStr.replace('.', ',').concat("€");
        return priceStr;
    }

}