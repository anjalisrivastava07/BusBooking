package com.bct.java.bus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.bct.java.bus.management.BusRecordManagement;
import com.bct.java.bus.model.Record;


public class BusBook {
	private static Set<Integer> seats = new HashSet<Integer>();
	public static void main(String[] args) {
		seats.addAll( Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}));

		BusRecordManagement hr = new BusRecordManagement();
		Record record = new Record();
		Scanner input = new Scanner(System.in);
		int option = 0;
		do {
			menu();
	        option = input.nextInt();
	        switch(option) {
	        case 1:
	        	System.out.println("Enter seat number:");
	        	int seatNumber = input.nextInt();
	        	if((seats.isEmpty())|| (!seats.contains(seatNumber))) {
	        		System.out.println("Seats not available");
	        		break;
	        	}
	        	seats.remove(seatNumber);
	        	Random rand = new Random();
	        	int ticketNumber = rand.nextInt(1000,10000);
	        	System.out.println("Enter person's number:");
	        	long contactNumber = input.nextLong();
	        	input.nextLine(); 
	        	System.out.println("Enter person's name:");
	        	String name = input.nextLine();
	        	record = new Record(seatNumber,ticketNumber,contactNumber,name);
	        	hr.add(record);
	        	System.out.println(record.toString());
	        	System.out.println("Ticket number: "+record.getTicketNumber());
	        	System.out.println("Save ticket number for future purpose");
	        	break;
	        case 2:
	        	System.out.println("Enter ticket number and seat number to delete booking:");
	        	int ticketNumb = input.nextInt();
	        	
	        	int seatnumber = input.nextInt();
	        	
				int seat = 0;
	        	seat = hr.delete(ticketNumb,seatnumber);
	        	seats.add(seat);
	        	break;
	        case 3:
	        	System.out.println("Enter ticket number:");
	        	int ticketnum = input.nextInt();
	        	System.out.println("Enter seat number:");
	        	int seatNu = input.nextInt();
	        	hr.update(ticketnum,seatNu);
	        	break;
	        case 4:
	        	System.out.println("Enter ticket number to find user details:");
	        	int ticket = input.nextInt();
	        	if(!hr.find(ticket)) {
	        		System.out.println("Booking doesn't exist");
	        	}
	        	
	        case 5:
	        	hr.display();
	        	break;
	        	
	        case 6:
	        	System.out.println("Available seats:");
	        	System.out.println(seats);
	        	break;
	        case 9:
	        	System.out.println("\nThank you for using the program. Goodbye!\n");
	        	System.exit(0);
	        default:
	        	System.out.println("\n Invalid input\n");
	        	break;
	        }
			
		}while(option!=9);
	}
	public static void menu() {
		System.out.println("MENU");
        System.out.println("1: Add booking");
        System.out.println("2: Delete booking");
        System.out.println("3: Update booking");
        System.out.println("4: Search booking");
        System.out.println("5: Display booking");
        System.out.println("6: Display seats available");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection : ");
	}

}
