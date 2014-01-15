import java.util.GregorianCalendar;
import java.util.*;

public class Rum {
	private int roomNumber;
	private int numberOfBeds;
	private int flatNumber;
	private boolean bokat;
	private ArrayList<Bokning> BokadeDatum;
	
	public Rum(int roomNumber, int numberOfBeds, int flatNumber){
		BokadeDatum = new ArrayList<Bokning>();
		this.roomNumber = roomNumber;
		this.numberOfBeds = numberOfBeds;
		this.flatNumber = flatNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public boolean isBokat() {
		return bokat;
	}

	public void setBokat(boolean bokat) {
		this.bokat = bokat;
	}
	
	public ArrayList<Bokning> getBookings(){
		if(BokadeDatum == null)
			return null;
		else 
			return this.BokadeDatum;
	}
	
	public void addBookings(Bokning bokning){
		BokadeDatum.add(bokning);
	}
}
