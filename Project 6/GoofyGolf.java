import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Sabrina Kundu
* CMSC 255-001
* Project 6 - GoofyGolf.java
* 
* Description:
* This program reads an input file containing each player's name, age, and
* score for each of the nine holes. Then the program displays each golfer's
* name and score on each of the nine holes, with one of the phrases: Over par,
* Par, or Under par next to each score. The program also displays each player's
* total score and the score's overall relation to the par for the entire course.
* 
* Instructions:
* 1. Follow the instruction given when you run the program.
* 2. The instruction gives an example of input the program can
* read. Always type "java GoofyGolf" before typing the name of your
* input file.
* 3. Make sure the structure and type of information is similar to the
* sample file "project6GoodData.txt" or "project6BadData.txt".
* 4. If the file can not be found, check if it's saved in the same
* folder as GoofyGolf.java.
* 5. Press the Enter key and the program will display output.
*/

public class GoofyGolf {
 
 /**
  * Output identifying information
  */
 public static void printHeading() {
  System.out.println("Sabrina Kundu");
  System.out.println("CMSC 255-001");
  System.out.println("Project 6 - GoofyGolf.java");
 }
 
 public static void main(String[] args) {
   
  /**
   * Try to output my identification information
   * Try to read arguments (information the user entered)
   */
  try {
   printHeading();
   readData(args[0]);
  } catch (ArrayIndexOutOfBoundsException e) {
    
   /**
    * Show message to allow user to type in an input file
    */
   System.out.println("Type in an existing file. For example: java GoofyGolf project6GoodData.txt");
  }
  
 }
 
 /**
  * Processes one data file
  * @param fileName - name of a file with input data 
  */
 public static void readData(String fileName) {
   
  /**
   * 2-dimensional array of integers assigned to table
   */
  int [][] table = { 
         {8, 8, 9, 7, 5, 7, 8, 5, 8},
         {7, 7, 8, 6, 5, 6, 7, 5, 6},
         {6, 5, 6, 5, 4, 5, 5, 4, 5},
         {5, 4, 4, 4, 3, 4, 3, 3, 4},
         {4, 3, 3, 3, 2, 3, 2, 3, 3}};
  
  /**
   * Try to open the input file
   */
  try {
   Scanner input = new Scanner(new File(fileName));
   
   /**
    * While loop to read each line of the data
    */
   while (input.hasNextLine()) {
     
    /**
     * Try to split each line of input file data by splitting values that
     * are separated by more that one space and assign splitted
     * line of data to variable line.
     */
    try {
     String[] line =  input.nextLine().split("\\s+");
     
     /**
      * Output the value of line[0], which is the name of the player
      * Parse the string in line[1] to integer and assign that value
      * to age variable
      * Declare an array rangeForAge and set equal to null, because the 
      * array values are unknown for now
      */
     System.out.println(line[0] + ":");
     int age = Integer.parseInt(line[1]);
     int [] rangeForAge = null;
     
     /**
      * If player's age is 4 or under, the assign first row of table data
      * to rangeForAge variable
      */
     if(age <= 4)
      rangeForAge = table[0];
     
     /**
      * If player's age is 5, 6, or 7, then assign the second row of table data
      * to rangeForAge variable
      */
     if(age >= 5 && age <= 7)
      rangeForAge = table[1];
     
     /**
      * If player's age is 8, 9, 10, or 11, then assign the third row of table data
      * to rangeForAge variable
      */
     if(age >= 8 && age <= 11)
      rangeForAge = table[2];
     
     /**
      * If player's age is 12, 13, 14 or 15, then assign the fourth row of table data
      * to rangeForAge variable
      */
     if(age >= 12 && age <= 15)
      rangeForAge = table[3];
     
     /**
      * If player's age is 16 or over, then assign the fifth row of table data
      * to rangeForAge variable
      */
     if(age >= 16)
      rangeForAge = table[4];
     
     /**
      * Assign totalScore to 0
      * For loop to iterate through each value in the line
      * Declare String variable par
      * Parse each data value to integer and assign to currentScore
      * Calculate the total Score for each player by adding all of the current scores
      * to totalScore variable
      * Assign Par to String par if current score matches expected
      * score for player's age range and for that hole
      * Assign Under par to String par if current score is less than
      * expected score for player's age range and for that hole
      * Assign Over par to String par if current score is more than
      * expected score for player's age range and for that hole
      * Output score of each of the nine holes
      * and output Over par, Par, or Under par next to each score
      */
     int totalScore = 0;
     for (int i = 2; i < line.length; i++) {
      String par = "";
      int currentScore = Integer.parseInt(line[i]);
      totalScore += currentScore;
    
      if(rangeForAge[i - 2] == currentScore)
       par = "Par";
      if(rangeForAge[i - 2] > currentScore)
       par = "Under par";
      if(rangeForAge[i - 2] < currentScore)
       par = "Over par";
      
      System.out.println("Hole " + (i - 1) + " - " + currentScore + " " + par);
     }
     
     /**
      * Assign parScores to 0
      * For loop to iterate through rangeForAge array
      * Calculate sum by adding each data value in rangeForAge
      * to parScores
      * parScores is the expected sum of scores for the player's
      * age range.
      */
     int parScores = 0;
     for (int i = 0; i < rangeForAge.length; i++) {
      parScores += rangeForAge[i];
     }
     
     /**
      * Output the total score
      * Output the number of points over or below par
      */
     System.out.print("Total score: " + totalScore);
     if(totalScore - parScores > 0)
      System.out.println(" (" + (totalScore - parScores) + " points over par)");
     if(totalScore - parScores == 0)
      System.out.println(" (" + (totalScore - parScores) + " points equal to par)");
     if(totalScore - parScores < 0)
      System.out.println(" (" + Math.abs(totalScore - parScores) + " points below par)");
     System.out.println("-----------------------------------------");
    } catch (NumberFormatException e) {
      
     /**
      * If there is a data value in the person's scores that is not a number,
      * skip the entire line and continue calculations for the next person.
      */
     System.out.println("Skipping bad data...");
     continue;
    } 
   }
  } catch (FileNotFoundException e) {
    
   /**
    * Show error message if the user's inputted file is not found
    */
   System.out.println("File not found!");
  } 
 }
}
