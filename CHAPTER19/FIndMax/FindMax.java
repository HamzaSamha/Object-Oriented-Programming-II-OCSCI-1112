

public class FindMax {
	public static <E extends Comparable<E>> E findMax(E[] array) {
	    if (array == null || array.length == 0) {
	        return null;
	    }

	    E max = array[0];
	    for (int i = 1; i < array.length; i++) {
	        if (max.compareTo(array[i]) < 0) {
	            max = array[i];
	        }
	    }

	    return max;
	}
	
	/*
	Author: 
	Date: 

	Description: 
	 */
	
	  public static void main(String[] args) {
	    Integer[] numbers = {1, 2, 3};
	    System.out.println(findMax(numbers));
	    
	    String[] words = {"red", "green", "blue"};
	    System.out.println(findMax(words));
	    
	    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
	    System.out.println(findMax(circles));
	  }
	  
	  static class Circle implements Comparable<Circle> {
	    double radius;
	    
	    public Circle(double radius) {
	      this.radius = radius;
	    }
	    
	    @Override
	    public int compareTo(Circle c) {
	      if (radius < c.radius) 
	        return -1;
	      else if (radius == c.radius)
	        return 0;
	      else
	        return 1;
	    }
	    
	    @Override
	    public String toString() {
	      return "Circle radius: " + radius;
	    }
	  }
	

	
	
	

}
