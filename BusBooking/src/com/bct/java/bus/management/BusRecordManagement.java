package com.bct.java.bus.management;

import java.util.LinkedList;
import java.util.Scanner;

import com.bct.java.bus.model.Record;

public class BusRecordManagement {
	LinkedList<Record> list;
	

	public BusRecordManagement() {
		list = new LinkedList<>();
	}
	
	public void add(Record record) {
		if (!find(record.getSeatNumber())) {
            list.add(record);
	}
}
	public boolean find(int seatNumber) {
		for (Record l : list) {
            if (l.getSeatNumber() == seatNumber) {
                System.out.println(l);
                return true;
            }
        }
        return false;
	}
	@SuppressWarnings("unused")
	public int delete(int ticketNumber, int seatNumber) {
		Record recordDel = null;
		for(Record ll: list) {
			if(ll.getTicketNumber()==ticketNumber) {
				recordDel = ll;
			}
		}
		int seat = recordDel.getSeatNumber();
		if(recordDel == null) {
			System.out.println("Invalid record");
			return 0;
		}
		else {
			list.remove(recordDel);
			System.out.println("Successfully removed record from the list");
		}
		return seat;
	}
	public Record findRecord(int ticketNumber) {
		for(Record l : list) {
			if(l.getTicketNumber() == ticketNumber) {
				return l;
			}
		}
		return null;
	}
	public void update(int ticketNumber,int seatNumber) {
		Scanner input = new Scanner(System.in);
		if(find(seatNumber)) {
			Record rec = findRecord(ticketNumber);
			System.out.println("Enter person's number:");
        	long contactNumber = input.nextLong();
        	input.nextLine(); 
        	System.out.println("Enter person's name:");
        	String name = input.nextLine();
        	rec.setContactNumber(contactNumber);
        	rec.setName(name);
        	System.out.println("Record Updated Successfully");
		}
		else {
			System.out.println("Record Not Found in the booking list");
		}
		
	}
	public void display() {
		if(list.isEmpty()) {
			System.out.println("The list has no records\n");
		}
		for(Record record: list) {
			System.out.println(record.toString());
		}
	}
}
