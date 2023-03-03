import java.util.Scanner;

                    public class Inverse {
                         public static void main(String[] args) {
                           Scanner k = new Scanner(System.in);

                           System.out.println("Please enter a string: ");
                           String value = k.next();

                           reverseString(value);




                         }

                         public static void reverseString(String value){

                           if(value.length() == 1) {
                             System.out.println(value);


                           } else {
                             System.out.println(value.charAt(value.length()-1));
                             reverseString(value.substring(0, value.length() - 1));
                           }



                         }


                    }
