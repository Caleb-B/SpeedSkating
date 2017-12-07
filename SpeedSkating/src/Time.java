/* **********************************************************
 * Programmer:	Rob Sveinson
 * Class:		CS20S
 * 
 * Assignment:	aX  qY
 *
 * Description:	describe the class you are creating
 *
 * 
 * *************************************************************
 */
 
 // import files here as needed
 
 
 public class Time
 {  // begin class
 	
 	// *********** class constants **********
 	
	 private int DISTANCE = 5000;		// distance in meters
	 
 	// ********** instance variable **********
 	
	 private int minutes = 0;
	 private int seconds = 0;
	 
 	// ********** constructors ***********
	 
	//*****************************************************
	// Purpose: create a new time object with default values
	// Interface: IN: none
	// Returns: none
	// ***************************************************** 
	 public Time() {
	 } // end of default constructor
	 
 	// ********** accessors **********
	 
	//*****************************************************
	// Purpose: get minutes of a trial
	// Interface: IN: none
	// Returns: minutes
	// *****************************************************   
	 public int getMinutes() {
		 return minutes;
	 } // end getMinutes
	 
	//*****************************************************
	// Purpose: get seconds of a trial
	// Interface: IN: none
	// Returns: seconds
	// *****************************************************
	 public int getSeconds() {
		 return seconds;
	 } // end getSeconds
	 
	//*****************************************************
	// Purpose: get speed of a trial
	// Interface: IN: none
	// Returns: speed
	// *****************************************************
	 public double getSpeed() {
		 double speed;
		 speed = (DISTANCE / ((this.getMinutes() / 60) + this.getSeconds())) / 3.6;
		 return speed;
	 } // end getSpeed
	 
	//*****************************************************
	// Purpose: return the assessment details as a string
	// Interface: IN: none
	// Returns: strout
	// *****************************************************
	 public String toString() {
		 String strout = "";
		 
		 strout = String.format("%02d:%02d", this.getMinutes(), this.getSeconds());
		 return strout;
	 }
 	// ********** mutators **********
 
 }  // end class