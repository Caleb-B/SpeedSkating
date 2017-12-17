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
	 
	 public String getAvgTime() {
		 int sum = 0;			// total sum of all times in timeList, in seconds
		 int avg;				// average time in seconds
		 
		 String avgStr;			// average time in minutes and seconds, as string
		 for (int i = 0; i < count; i++) {
			 sum += timeList[i].getMinutes() * 60;
			 sum += timeList[i].getSeconds();
		 } // end for int i
		 
		 avg = sum / count;
		 
		 avgStr = String.format("%02d:%02d", (avg / 60), (avg % 60));
		 
		 return avgStr;
	 } // end getAvgTime
	 
 	// ********** mutators **********
	 
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