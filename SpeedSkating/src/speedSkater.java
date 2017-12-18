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
 
 
 public class speedSkater
 {  // begin class
 	
 	// *********** class constants **********
 	
	 private static int nextID = 1000;		// unique skater id
	 private int MAXTIME = 10;
	 
 	// ********** instance variable **********
 	
	 private int id;			// id for this object
	 
	 private Time[] timeList = new Time[MAXTIME];
	 private int count = 0;		// actual number of items in timeList
	 
 	// ********** constructors ***********
 	
	 public speedSkater() {
		 id = nextID++;
		 
		 for (int i = 0; i < MAXTIME; i++) {
			 timeList[i] = new Time();
		 }
	 } // end default constructor
	 
 	// ********** accessors **********
 	
	//*****************************************************
	// Purpose: get the time object at the given index
	//			of timeList
	// Interface: IN: none
	// Returns: timeList[idx]
	// *****************************************************
	 public Time getATime(int idx) {
		 return timeList[idx];
	 } // end getATime
	 
	//*****************************************************
	// Purpose: get the time
	// Interface: IN: none
	// Returns: timeList[idx].getTime()
	// *****************************************************
	 public String getTime(int idx) {
		 return timeList[idx].toString();
	 } // end getTime
	 
	//*****************************************************
	// Purpose: get the average time for all races
	// Interface: IN: none
	// Returns: avgStr
	// *****************************************************
	 public String getAvgTime() {
		 int avg;				// average time in seconds
		 
		 String avgStr;			// average time in minutes and seconds, as string
		 
		 avg = this.getSum() / count;
		 
		 avgStr = String.format("%02d:%02d", (avg / 60), (avg % 60));
		 
		 return avgStr;
	 } // end getAvgTime
	 
	//*****************************************************
	// Purpose: get the sum of times for all races
	// Interface: IN: none
	// Returns: sum
	// *****************************************************
	 public int getSum() {
		 int sum = 0;			// total sum of all times in timeList, in seconds
		 
		 for (int i = 0; i < count; i++) {
			 sum += timeList[i].getMinutes() * 60;
			 sum += timeList[i].getSeconds();
		 } // end for int i
		 
		 return sum;
	 } // end getSum
	 
	//*****************************************************
	// Purpose: get the average speed over all races
	//			in kilometers per hour
	// Interface: IN: none
	// Returns: avgSpeed
	// *****************************************************
	 public String getAvgSpeed() {
		 String avgSpeed;			// string of the average speed in km/hour
		 avgSpeed = Double.toString(this.getSum() * timeList[0].getDistance() * 3.6);
		 return avgSpeed;
	 } // end for getAvgSpeed
	 
 	// ********** mutators **********
	 
	//*****************************************************
	// Purpose: adds a time to timeList
	// Interface: IN: index (int),
	//				time (Time)
	// Returns: none
	// *****************************************************
	 public void addTime(int idx, Time t) {
		 if (count < timeList.length) {
			 timeList[count] = t;

			 count++;
		 }
		 else {
			 for (int i = 0; i < timeList.length; i++) {
				 timeList[i] = timeList[i + 1];
			 } // end for int i
		 }
	 } // end addTime
 
 }  // end class