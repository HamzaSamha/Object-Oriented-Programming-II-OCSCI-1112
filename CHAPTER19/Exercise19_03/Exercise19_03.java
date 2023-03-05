/*
Author: Hamza 
Date: 12-27-2022

Description: 
 */
import java.util.ArrayList;

public class Exercise19_03 {
	public static <E> ArrayList<E>  deleteCopies(ArrayList<E> list){
		ArrayList<E> newList = new ArrayList<E>();
		for(int i = 0; i < list.size(); ++i){
			if (!newList.contains(list.get(i))){
				newList.add(list.get(i)); 
				
				
			}
			
			
			
		}
		return newList; 
		
	}
	
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);
    
    ArrayList<Integer> newList = deleteCopies(list);
    
    System.out.print(newList);
	System.out.println("Starting list: "+ list); 
	System.out.println("List after removing the multible copies: "+ deleteCopies(list));
  }
}