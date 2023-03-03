import java.io.*;
public class Exercise_07 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
		Loan loan = new Loan(12,15,25000); 

       

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"))) {
		out.writeObject(loan);
		
           // double totalAmount = 0;
            {

                System.out.println("Total loan amount = " + totalAmount);
            }
        }
    }
}