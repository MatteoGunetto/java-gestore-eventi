package org.lesson.java.gestore_eventi;

import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //boolean exit = false;

        //while(!exit) {
        System.out.println("\n------------------------------\n");

        System.out.print("Inserire nome evento: ");
        String name = in.nextLine();

        //if(name.equals("!exit")) exit = true;

        System.out.println("\n------------------------------\n");

        System.out.print("Inserire data evento (yyyy-mm-dd): ");
        String dateStr1 = in.nextLine();
        LocalDate eventDate = LocalDate.parse(dateStr1);

        System.out.println("\n------------------------------\n");

        System.out.print("Inserire data odierna (yyyy-mm-dd): ");
        String dateStr2 = in.nextLine();
        LocalDate actualDate = LocalDate.parse(dateStr2);


        System.out.println("\n------------------------------\n");

        System.out.println("Inserire posti a sedere totali: ");
        int totalSeats = Integer.parseInt(in.nextLine());

        try {
            Evento show = new Evento(name, eventDate, actualDate, totalSeats);

            System.out.println(show);

            System.out.println("\n------------------------------\n");

            System.out.print("Quante prenotazioni? ");
            int reservation = Integer.parseInt(in.nextLine());

            for(int i=0; i<reservation; i++) {
                show.reserve();
            }

            System.out.println("\n------------------------------\n");

            System.out.println("Prenotazione effettuata.");

            System.out.println("\n------------------------------\n");

            System.out.println("Posti prenotati: " + show.getReservedSeat() + " | Posti liberi: " + (show.getTotalSeat() - show.getReservedSeat()));

            System.out.println("\n------------------------------\n");

            System.out.print("Quante prenotazioni vuoi annullare? ");
            int deletion = Integer.parseInt(in.nextLine());

            for(int i=0; i<deletion; i++) {
                show.removeReservation();
            }

            System.out.println("\n------------------------------\n");

            System.out.println("Prenotazione cancellata.");

            System.out.println("\n------------------------------\n");

            System.out.println("Posti prenotati: " + show.getReservedSeat() + " | Posti liberi: " + (show.getTotalSeat() - show.getReservedSeat()));

        }catch(Exception e) {
            in.close();
            System.err.println(e.getMessage());
        }


        //}

        in.close();

    }
}