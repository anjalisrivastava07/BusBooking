package com.bct.java.bus.management;

import java.util.LinkedList;
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

	private boolean find(int seatNumber) {
		for (Record l : list) {
			 
            // Checking record by id Number
            if (l.getSeatNumber() == seatNumber) {
 
                System.out.println(l);
                return true;
            }
        }
        return false;
	}
}
