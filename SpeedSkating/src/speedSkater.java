/* **********************************************************
 * Programmer:	Caleb Beynon
 * Class:		CS30S
 * 
 * Assignment:	2
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
			 this.timeList[i] = new Time();
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
		 return this.timeList[idx];
	 } // end getATime
	 
	//*****************************************************
	// Purpose: get a Time object
	// Interface: IN: none
	// Returns: timeList[idx].getTime()
	// *****************************************************
	 public String getTime(int idx) {
		 return this.timeList[idx].toString();
	 } // end getTime
	 
	//*****************************************************
	// Purpose: get the average time for all races
	// Interface: IN: none
	// Returns: avgStr
	// *****************************************************
	 public String getAvgTime() {
		 int avg;				// average time in seconds
		 
		 String avgStr;			// average time in minutes and seconds, as string
		 
		 avg = this.getSum() / this.count;
		 
		 avgStr = String.format("%02d:%02d", (avg / 60), (avg % 60));
		 
		 return avgStr;
	 } // end getAvgTime
	 
	//*****************************************************
	// Purpose: get the sum of times for all races
	// Interface: IN: none
	// Returns: sum
	// *****************************************************
	 private int getSum() {
		 int sum = 0;			// total sum of all times in timeList, in seconds
		 
		 for (int i = 0; i < this.count; i++) {
			 sum += this.timeList[i].getMinutes() * 60;
			 sum += this.timeList[i].getSeconds();
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
		 
		 avgSpeed = Double.toString((this.getSum() / 3600.0) * (this.timeList[0].getDistance() / 1000));
		 return avgSpeed;
	 } // end for getAvgSpeed
	 
	//*****************************************************
	// Purpose: get the speed of a specific race
	// Interface: IN: index (int)
	// Returns: timeList[idx].getSpeed()
	// *****************************************************
	 public String getSpeed(int idx) {
		 return Double.toString(1.0 * this.timeList[idx].getDistance() * this.count / this.getSum());
	 } // end getSpeed
	 
	//*****************************************************
	// Purpose: get the actual number of objects in timeList
	// Interface: IN: none
	// Returns: count
	// *****************************************************
	 public int getCount() {
		 return this.count;
	 } // end getCount
	 
 	// ********** mutators **********
	 
	//*****************************************************
	// Purpose: adds a time to timeList
	// Interface: IN: index (int),
	//				time (Time)
	// Returns: none
	// *****************************************************
	 public void addTime(int m, int s) {
		 if (this.count < this.timeList.length) {
			 this.timeList[this.count].setTime(m, s);

			 this.count++;
		 }
		 else {
			 for (int i = 0; i < this.timeList.length - 1; i++) {
				 this.timeList[i] = this.timeList[i + 1];
			 } // end for int i
			 this.timeList[this.count - 1].setTime(m, s);
		 }
	 } // end addTime
 
 }  // end class