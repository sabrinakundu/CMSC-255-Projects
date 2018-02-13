import java.util.Scanner;

/*
 * Sabrina Kundu
 * CMSC 255-001
 * RocketTest.java - Project 7
 * 
 * Description:
 * Test program that instantiates three rockets. One rocket is a default 
 * rocket, which accesses data from RocketClass.java to build a default size
 * rocket. Second rocket is built using data that is hardcoded in this program for
 * new RocketClass rocket2. Third rocket is built using data collected from the
 * user's input. This program uses the RocketClass.java file to create these
 * three objects.
 * 
 * Instructions:
 * 1. Run the program. It will output the programmer's identifying information,
 * the default rocket, the rocket with some data the programmer hardcoded, and
 * will ask you to input the height of the cylinder of the rocket you want to build.
 * 2. Type in only integers and decimals for all dimensions. If you type invalid characters,
 * the program will shut down.
 * 3. There are only three types of materials: aluminum, steel, and titanium. The program will
 * continue as long as one of these words is in your answer, even if it's capitalized of if you have numbers. If you type
 * in two of these materials, then it will calculate the material cost for the first material inputted
 * from the left side of the input box. 
 * 3. There are only two types of fuel: ammonium nitrate and ammonium perchlorate. The program will
 * continue as long as the word "nitrate" or "perchlorate" is in your answer, even if it's capitalized or
 * if you have numbers. If you type in both of these fuel types, then it will calculate the fuel cost for the 
 * first one inputted from the left side of the input box.
 * 4. The program will build the rocket and output the surface areas and costs.
 * 5. If program does not run correctly, make sure this Java file is saved in the same folder
 * as RocketClass.java, Material.java, and Fuel.java.
 */

public class RocketTest {

 public static void main(String[] args) {
  /*
   * Outputs identifying information
   */
  printHeading();
  
  /*
   * Declares new object class for RocketClass() and
   * assigns to rocketClass variable.
   * Outputs default rocket created
   * Outputs rocket with some data that was hardcoded into RocketClass()
   * and assigned to rocketClass2
   * Outputs rocket with user data for dimensions, materal type, and fuel type
   */
  RocketClass rocketClass = new RocketClass();
  System.out.println("\n Default rocket:");
  System.out.println(rocketClass);
  System.out.println("\n Rocket with some data:");
  RocketClass rocketClass2 = new RocketClass(50, 50, 50, 50, 50, Material.TITANIUM, Fuel.NITRATE);
  System.out.println(rocketClass2);
  System.out.println("\n Rocket with user data:");
  
  /*
   * Try to prompt user to enter input
   * Try to read user input and assign as values to 
   * dimension, material type, and fuel type variables
   * Try to declare a third object class for RocketClass()
   * which passes values of measurements, fuel type, and material type and
   * build new rocket.
   * Try to output third rocket created
   * Try to close scanner
   */
  try {
   Scanner scanner = new Scanner(System.in);
   System.out.println("Enter the height of the cylinder of the rocket (cm) : ");
   double cylinderHeight = Double.parseDouble(scanner.nextLine());
   System.out.println("Enter the radius of the cylinder of the rocket (cm) : ");
   double cylinderRadius = Double.parseDouble(scanner.nextLine());
   System.out.println("Enter the height of the cone of the rocket (cm) : ");
   double coneHeight = Double.parseDouble(scanner.nextLine());
   System.out.println("Enter the height of the fin of the rocket (cm) : ");
   double finHeight = Double.parseDouble(scanner.nextLine());
   System.out.println("Enter the base of the fin of the rocket (cm) : ");
   double finBase = Double.parseDouble(scanner.nextLine());
   System.out.println("Select the material for the rocket : ");
   Material material = selectMaterial(scanner.nextLine());
   System.out.println("Select the type of fuel for the rocket : ");
   Fuel fuel = selectFuel(scanner.nextLine());
   RocketClass rocketClass3 = new RocketClass(cylinderHeight, cylinderRadius, coneHeight, finHeight, finBase,
     material, fuel);
   System.out.println(rocketClass3);
   scanner.close();
  } catch (Exception e) {
   /*
    * Outputs error message and stops the program if 
    * user input is not valid
    */
   System.err.println("\nWrong input data! Program shutdown. \n");
   System.exit(0);
  }
 }
 
  /*
   * Outputs identifying information
   */
  private static void printHeading() {
  System.out.println("Sabrina Kundu");
  System.out.println("RocketClass.java");
 }

 /*
  * Gets user input for fuel type, converts characters to uppercase letters,
  * and if input contains nitrate or perchlorate, return the respective prices
  * Handles all exceptions
  * @param input - user input for fuel type
  */
 private static Fuel selectFuel(String input) throws Exception {
  if (input.toUpperCase().contains("NITRATE")) {
   return Fuel.NITRATE;
  }
  if (input.toUpperCase().contains("PERCHLORATE")) {
   return Fuel.PERCHLORATE;
  }
  throw new Exception();
 }

 /*
  * Handles all exceptions
  * Gets user input for material type, converts characters to uppercase letters,
  * and if input contains aluminum, steel, or titanium, return the respective prices
  * @param input - user input for material type
  */
 private static Material selectMaterial(String input) throws Exception {
  if (input.toUpperCase().contains("ALUMINUM")) {
   return Material.ALUMINUM;
  }
  if (input.toUpperCase().contains("STEEL")) {
   return Material.STEEL;
  }
  if (input.toUpperCase().contains("TITANIUM")) {
   return Material.TITANIUM;
  }
  throw new Exception();
 }
}
