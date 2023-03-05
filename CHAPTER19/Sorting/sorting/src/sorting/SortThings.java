package sorting;
import java.util.ArrayList;

public class SortThings {
	public static <E extends Comparable<E>>
	void sorting(ArrayList<E> list) {
		E currentLowestNumber;
		int lowestNumberIndex; 
		
		for(int i = 0; i <list.size()-1; i++) {
			currentLowestNumber = list.get(i);
			lowestNumberIndex =i;
			
			for(int j =i+1;j<list.size();j++) {
				
				if(currentLowestNumber.compareTo(list.get(j))>0) {
					currentLowestNumber = list.get(j);
					lowestNumberIndex = j; 
					
					
				}
				
				
				
			}
			
			if (lowestNumberIndex !=i) {
				
				list.set(lowestNumberIndex, list.get(i));
				list.set(i,currentLowestNumber);
				
			}
			
		}
		
		
		
	}
	
		  public static void main(String[] args) {
		    ArrayList<Integer> list = new ArrayList<Integer>();
		    list.add(14);
		    list.add(24);
		    list.add(4);
		    list.add(42);
		    list.add(5);
		    SortThings.<Integer>sorting(list);
		    
		    System.out.print(list);
		  }
		

}
