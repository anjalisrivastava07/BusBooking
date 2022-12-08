package com.bct.java.bus.model;

public class Record {
	private int seatNumber;
	private int ticketNumber;
	private long contactNumber;
	private String name;
	
	public Record(int seatNumber, int ticketNumber, long contactNumber, String name) {
		this.seatNumber = seatNumber;
		this.ticketNumber = ticketNumber;
		this.contactNumber = contactNumber;
		this.name = name;
	}
	public Record() {
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Record [seatNumber=" + seatNumber + ", ticketNumber=" + ticketNumber + ", contactNumber="
				+ contactNumber + ", name=" + name + "]";
	}
	
	
	
}
