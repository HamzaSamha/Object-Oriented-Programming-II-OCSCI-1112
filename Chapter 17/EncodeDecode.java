import java.util.Scanner;
import java.io.*;
 public class EncodeDecode{
	 public static void main(String[] args) throws IOException {
		 Scanner k = new Scanner(System.in);
			System.out.println("Enter a file to encrypt:");
			FileInputStream in = new FileInputStream(k.next());
			System.out.println("Enter the output file: ");
			FileOutputStream output = new FileOutputStream(k.next());
		 int value; 
		 final int num = -1; 
		 while ((value = in.read()) != num){
			 output.write (value +5); 
			 
			 
		 }
		 in.close(); 
		 output.close(); 
		 
		 
		 
		 
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }