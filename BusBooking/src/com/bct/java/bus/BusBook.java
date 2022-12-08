package com.bct.java.bus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import com.bct.java.bus.management.BusRecordManagement;
import com.bct.java.bus.model.Record;

//private static int[] seats = new int[20];
//public static void main(String[] args) {
//	System.out.println("Welcome to the Bus reservation system!");
//    System.out.println("Have a fabulous ride!");
//    System.out.println();
//    
//    Scanner sc = new Scanner(System.in);
//    int choice = 1;
//
//    System.out.print("Please enter your "
//    		+ "choice\n1.window seat\n2.Aisle "
//    		+ "seat\n0.Exit.\n");
//    
//    choice = sc.nextInt();
//    while (choice != 0) {
//        int seatnumber = 0;
//        if (choice == 1) {
//             seatnumber = bookWindow();
//             if (seatnumber == -1) {
//                  seatnumber = bookAisle();
//                 if (seatnumber != -1) {
//                     System. out.println("Sorry, we were "
//                     		+ "not able to book a window seat. "
//                     		+ "But do have an aisle seat.");
//                     printBoardingPass(seatnumber);
//                     }
//                }
//             else {
//                 System.out.println("Congratulations, "
//                 		+ "we have a window seat available!");
//                 printBoardingPass(seatnumber);
//                 }
//             }
//         else if (choice == 2) {
//             seatnumber = bookAisle();
//             if (seatnumber == -1) {
//                 seatnumber = bookWindow();
//                 if (seatnumber != -1) {
//                     System.out.println("Sorry, we were "
//                     		+ "not able to book an aisle seat. "
//                     		+ "But do have a window seat.");
//                     printBoardingPass(seatnumber);
//                     }
//                 }
//             else {
//                 System.out.println("Congratulations, we have "
//                 		+ "an aisle seat available!");
//                 printBoardingPass(seatnumber);
//                 }
//             }
//         else {
//             System.out.println("Invalid choice made. Please try again!");
//             choice = 0;
//             }
//         if (seatnumber == -1) {
//             System.out.println("We are sorry, there "
//             		+ "are no window or aisle seats");
//                     System.out.println();
//             }
//        System.out.print("Please enter your "
//        		+ "choice\n1.window seat\n2.Aisle seat\n0.Exit.\n");
//         choice = sc.nextInt();
//         }
//     }
//private static void printBoardingPass(int seatNumber) {
//	Date timenow = new Date();
//	System.out.println();
//	System.out.println("Date: "+timenow.toString());
//	System.out.println("Boarding pass for seat number: "+seatNumber);
//	System.out.println("Your Booking Successful!");
//	System.out.println("Have a nice day");
//	System.out.println();
//	
//}
//
//private static int bookWindow() {
//	for(int i=0;i<10;i++) {
//		if(seats[i]==0) {
//			seats[i]=1;
//			return i+1;
//		}
//	}
//	return -1;
//}
//
//private static int bookAisle() {
//	for(int i=10;i<20;i++) {
//		if(seats[i]==0) {
//			seats[i]=1;
//			return i+1;
//		}
//	}
//	return -1;
//}
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
	        	int ticketNumber = rand.nextInt();
	        	System.out.println("Enter person's number:");
	        	long contactNumber = input.nextLong();
	        	input.nextLine(); 
	        	System.out.println("Enter person's name:");
	        	String name = input.nextLine();
	        	record = new Record(seatNumber,ticketNumber,contactNumber,name);
	        	hr.add(record);
	        	System.out.println(record.toString());
	        	break;
	        case 6:
	        	System.out.println("Available seats:");
	        	System.out.println(seats);
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
