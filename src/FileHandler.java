import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
	
	BufferedReader input;
	
	public FileHandler() throws FileNotFoundException{
		try{
			FileReader reader = new FileReader("rum.txt");
			input = new BufferedReader(reader);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public String readFromFile(){
		try{
			return input.readLine();
		} catch(IOException e){
			return null;
		}
	}
}
