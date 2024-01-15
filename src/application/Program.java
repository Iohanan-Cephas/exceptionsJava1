package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = reader.nextInt();
			
			System.out.print("Check-in date: ");
			Date checkIn = sdf.parse(reader.next());
			
			System.out.print("Check-out date: ");
			Date checkOut = sdf.parse(reader.next());
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
				
			System.out.println();
				
			System.out.println("Enter data to update reservation:");
			System.out.print("Check-in date: ");
			checkIn = sdf.parse(reader.next());
			System.out.print("Check-out date: ");
			checkOut = sdf.parse(reader.next());
				
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		reader.close();
	}

}
