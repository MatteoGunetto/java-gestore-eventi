package org.lesson.java.gestore_eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("\n------------------------------\n");

        System.out.print("Inserire nome evento: ");
        String concertName = in.nextLine();

        System.out.println("\n------------------------------\n");

        System.out.print("Inserire data evento (yyyy-mm-dd): ");
        String dateStr1 = in.nextLine();
        LocalDate concertDate = LocalDate.parse(dateStr1);

        System.out.println("\n------------------------------\n");

        System.out.print("Inserire data odierna (yyyy-mm-dd): ");
        String dateStr2 = in.nextLine();
        LocalDate actualDate = LocalDate.parse(dateStr2);

        System.out.println("\n------------------------------\n");

        System.out.println("Inserire posti a sedere totali: ");
        int concertTotalSeats = Integer.parseInt(in.nextLine());

        System.out.println("\n------------------------------\n");

        System.out.println("Ora attuale (HH:mm): ");
        String hourStr1 = in.nextLine();
        LocalTime concertHour = LocalTime.parse(hourStr1);

        System.out.println("\n------------------------------\n");

        System.out.println("Ora del concerto (HH:mm): ");
        String hourStr2 = in.nextLine();
        LocalTime actualHour = LocalTime.parse(hourStr2);

        System.out.println("\n------------------------------\n");

        System.out.println("Inserire prezzo del concerto: ");
        BigDecimal concertPrice = BigDecimal.valueOf(Double.parseDouble(in.nextLine()));

        try {

            Concerto selezionato = new Concerto(concertName, concertDate, actualDate, concertTotalSeats, concertHour, actualHour, concertPrice);

            System.out.println("\n------------------------------\n");

            System.out.println("Concerto aggiunto");

            System.out.println("\n------------------------------\n");

            System.out.println(selezionato.toString());

            System.out.println("\n------------------------------\n");

            System.out.print("Quante prenotazioni? ");
            int reservedSeats = Integer.parseInt(in.nextLine());

            System.out.println("\n------------------------------\n");

            for(int i=0; i<reservedSeats; i++) {
                selezionato.reserve();
            }
            System.out.println("Posti prenotati:\n");
            System.out.println("Posti prenotati: "+ selezionato.getReservedSeat() + " | Posti liberi " + (selezionato.getTotalSeat() - selezionato.getReservedSeat()));

            System.out.println("\n------------------------------\n");

            System.out.print("Quante prenotazioni vuoi annullare? ");
            int seatsToRemove = Integer.parseInt(in.nextLine());

            System.out.println("\n------------------------------\n");

            int oldFreeSeats = selezionato.getTotalSeat() - selezionato.getReservedSeat();
            for(int i=0; i<seatsToRemove; i++) {
                selezionato.removeReservation();
            }
            System.out.println("Prenotazione cancellata.\n");
            System.out.println("Posti liberi prima della cancellazione: "+ oldFreeSeats + " | Posti liberi dopo la cancellazione " + (selezionato.getTotalSeat() - selezionato.getReservedSeat()));

            System.out.println("\n------------------------------\n");

        }catch(Exception e) {
            in.close();
            System.err.println(e.getMessage());
        }

        in.close();

    }
}