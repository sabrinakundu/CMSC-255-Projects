import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/****************************************************************************
 * Sabrina Kundu
 * CMSC 255-001 Fall 2017
 * Project 4 - RocketData.java
 * 
 * Description: 
 * This program calculates the thrust to weight ratio 
 * of each rocket. The program will read a file of data that
 * contains the rocket's name, the rocket's mass, and the
 * rocket's sea level thrust. Then it will calculate the thrust to weight
 * ratio and determine whether the rocket has a rocket engine or a jet engine 
 * 
 * Instructions: 
 * 1. When the computer prompts you for input, enter the text file that
 * you want the program to read. Make sure the file is saved in the 
 * same folder as this Java program.
 * 2. Then the program will allow you to type in a name for the text file
 * that it will create after it executes the code and makes changes
 * to the data.
 * 3. After the program ends, go to the folder where your output file
 * is stored (it should be in the same folder as this Java program)
 * and open. You should see the rocket name, thrust to weight ratio,
 * and engine type for each rocket.
 *****************************************************************************/

public class RocketData {
  public static void main(String[] args) throws FileNotFoundException {
    
    // Call the printHeading() method before reading and writing files
    printHeading();
    
    // Ask user for input and output files
    Scanner scanner = new Scanner(System.in);
    System.out.print("Input file: ");
    String inputFileName = scanner.next();
    System.out.print("Output file: ");
    String outputFileName = scanner.next();
    
    //Construct Scanner and PrintWriter objects to read and write the files
    File inputFile = new File(inputFileName);
    Scanner in = new Scanner(inputFile);
    PrintWriter out = new PrintWriter(outputFileName);
    
    
     // Declare variables to hold values of gravitational field strength
     // and thrust to weight ratio
     double gravFieldStr = 0.009807; 
     double thrustToWeight = 0;
    
    // While loop iterates through each data value that is separated by spaces
    while (in.hasNext()) {
      
      // Declare name, rocketMass, and rocketThrust as String variables
      String name = in.next();
      String rocketMass = in.next();
      String rocketThrust = in.next();
      
      // Change rocketMass from String to Integer and assign value to mass variable
      int mass = Integer.parseInt(rocketMass);
      // Change rocketThrust from String to Double and assign value to thrust variable
      double thrust = Double.parseDouble(rocketThrust);
      
      // Write output file
      // Call ratio() method to output thrust to weight ratios for each rocket in output file
      // Call engine() method to output rocket or jet engine for each rocket in output file
      out.printf("%-10s %-10.3f %-10s%n", name, ratio(thrustToWeight, thrust, mass, gravFieldStr), engine(thrustToWeight,
      thrust, mass, gravFieldStr));
    }
    
    // Close Scanner and PrintWriter objects
    in.close();
    out.close();
  }
  
  // printHeading() method to print identifying information
  public static void printHeading() {
    System.out.println("Sabrina Kundu");
    System.out.println("CMSC 255-001");
    System.out.println("Project 4 - RocketData.java");
  }
  
  // ratio() method to calculate thrustToWeight ratio
  public static double ratio(double thrustToWeight, double thrust, double mass, double gravFieldStr) {
    thrustToWeight = thrust / (mass * gravFieldStr);
    return thrustToWeight;
  }
  
 // engine() method to determine whether rocket has rocket engine or jet engine
 public static String engine(double thrustToWeight, double thrust, double mass, double gravFieldStr) {
    // if thrust to weight ratio is less than 20, rocket has jet engine
    // else rocket has rocket engine
    if (ratio(thrustToWeight, thrust, mass, gravFieldStr)  < 20) {
      return "Jet Engine";
    } else {
      return "Rocket Engine";
    }
  }

  
}