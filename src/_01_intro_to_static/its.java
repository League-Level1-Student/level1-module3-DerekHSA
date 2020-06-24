package _01_intro_to_static;


	public class its {
	     static int nextBibNumber;
	    static String raceLocation = "New York";
	    static String raceStartTime = "9.00am";

	    String name;
	    int speed;
	    static int bibNumber;

	    its (String name, int speed){
	        this.name = name;
	        this.speed = speed;
	    }

	    public static void main(String[] args) {
	    	its lol =  new its("Weather", 1000);
	    	its lel = new its("Pucci", 1);
	    	bibNumber = 1;
	    nextBibNumber = bibNumber + 1;
	    	System.out.println(lol.name +" "+ lol.bibNumber+" "+lol.raceLocation);
	    	System.out.println(lel.name +" "+ lel.nextBibNumber+" "+lel.raceLocation);
	        //create two athletes
	        //print their names, bibNumbers, and the location of their race. 
	    }
	}

