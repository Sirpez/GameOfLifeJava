import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//import Board;

public class PrintBoard{
	
	public void writeFile(ArrayList<Square> squares){
		//ArrayList<Square> squares = new ArrayList<Square>();
		try{
			FileWriter writer = new FileWriter("Board.txt", true);
			for (Square square : squares){
				if(square.getAlive()){
					writer.write("*");
				}
				else{
					writer.write(".");
				}
			}
			writer.write("\n");
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}	
	}
}