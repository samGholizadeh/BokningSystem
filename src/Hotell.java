import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Hotell {
	
	private ArrayList<Rum> HotellRum;
	private ArrayList<Rum> LedigaRum;
	private Random r;
	private long epoch = new GregorianCalendar().getTimeInMillis();
	private long randomTime = 0;
	private int[] nrOfBeds = {1, 2, 3, 4};
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	GregorianCalendar date;
	
	public Hotell() throws FileNotFoundException{
		date = new GregorianCalendar();
		HotellRum = new ArrayList<Rum>();
		LedigaRum = new ArrayList<Rum>();
		r = new Random();
		FileHandler Hotelrooms = new FileHandler();
		
		for(int i = 0; i < 5; i++){
			for(int k = 1; k < 6; k++){
				int randomNr = r.nextInt(4);
				Rum rum = new Rum(Integer.parseInt(Hotelrooms.readFromFile()), nrOfBeds[randomNr], i);
				for(int y = 0; y < 10; y++){
					int randomDays = r.nextInt(200);
					randomTime = epoch + (86400000 * randomDays);
					date.setTimeInMillis(randomTime);
					Bokning bokning = new Bokning(sdf.format(date.getTime()));
					rum.addBookings(bokning);
					randomTime = 0;
				}
				HotellRum.add(rum);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Hotell hotel = new Hotell();
		System.out.println("Welcome to my simple Hotel room booking system. \nEnter a date to see" +
				" what rooms are availabe at that date");
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Enter date in this format yyyy-mm-dd");
			String desiredDate = scanner.next();
			for(int i = 0; i < hotel.getHotellRum().size(); i++){
				for(int k = 0; k < hotel.getHotellRum().get(i).getBookings().size(); k++){
					String BookedDate = hotel.getHotellRum().get(i).getBookings().get(k).getDatum();
					if(desiredDate.equals(BookedDate)){
						break;
					} else if(k == hotel.getHotellRum().get(i).getBookings().size() - 1) {
						hotel.LedigaRum.add(hotel.getHotellRum().get(i));
					}
				}
			}
			System.out.println("Here are the available rooms at that date:");
			for(int i = 0; i < hotel.getLedigaRum().size(); i++){
				System.out.println((i + 1) + ". Roomnumber " + hotel.getLedigaRum().get(i).getRoomNumber());
			}
			while(true){
				System.out.println("Which room would you like too book at " + desiredDate + "? Enter " +
						"the number next to date in the list above.");
				try{
					int roomChoice = scanner.nextInt();
					Gäst gäst;
					if(roomChoice > 0 && roomChoice <= (hotel.LedigaRum.size() + 1)){
						System.out.print("Enter the name of the guest: ");
						String name = scanner.next();
						System.out.print("\nEnter his/her email adress: ");
						String email = scanner.next();
						System.out.print("\nEnter his her Address: ");
						String address = scanner.next();
						System.out.print("\nEnter his/her phonenumber: ");
						int phoneNumber = scanner.nextInt();
						gäst = new Gäst(name, address, email, phoneNumber);
						Bokning bokning = new Bokning(gäst, desiredDate);
						hotel.getLedigaRum().get(roomChoice - 1).addBookings(bokning);
					} else {
						System.out.println("You must enter an integer that is present in the list above.");
						continue;
					}
					System.out.println("Roomnumber: " + hotel.getLedigaRum().get(roomChoice - 1).getRoomNumber() + " " +
							"has been booked at date: " + desiredDate + " by " + gäst.getName());
					hotel.LedigaRum.clear();
					break;
				} catch (InputMismatchException e){
					System.out.println("Please enter an valid value.");
					continue;
				}
			}
			continue;
		}
	}
	
	public ArrayList<Rum> getHotellRum() {
		return HotellRum;
	}

	public void setHotellRum(ArrayList<Rum> hotellRum) {
		HotellRum = hotellRum;
	}

	public ArrayList<Rum> getLedigaRum() {
		return LedigaRum;
	}

	public void setLedigaRum(ArrayList<Rum> ledigaRum) {
		LedigaRum = ledigaRum;
	}
	
	public void addLedigRum(Rum rum){
		LedigaRum.add(rum);
	}

}
