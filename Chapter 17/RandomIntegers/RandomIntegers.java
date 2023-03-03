import java.io.*;
import java.util.Scanner; 


public class RandomIntegers {
	 public static void main(String[] args){
		try (
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File("Exercise17-01.txt"), true));
		
		
		
		
		) {
			for (int i = 0; i < 100; i++){
				printWriter.print((int)(Math.random() * 100) + " ");
				
				
				
				
				
			}
			
			
			
			
		}
		catch (FileNotFoundException filefailed) {
			
			System.out.println("The Failed to be created");
			
			filefailed.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}