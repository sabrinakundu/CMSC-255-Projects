import java.util.Scanner;

/********************************************************************************
 * Sabrina Kundu
 * CMSC 255-001
 * Fall 2017 Semester
 * RocketChoice.java - Project 3
 * 
 * Description:
 * A program to calculate the total cost building a model rocket. 
 * The price is determined by the size of the rocket, the cost of fuel, 
 * the cost of the rocket material, and the choice of where to build the rocket.
 * 
 * Instructions:
 * User must enter information about the sizes of all the parts
 * of the rocket, the type of material, and the type of fuel.
 * The program will give the user a choice to have the rocket
 * built for them at a fixed price. 
 * User must enter numbers for questions asking for numerical values and 
 * words for questions asking for string values. 
 *********************************************************************************/

public class RocketChoice {
     public static void main(String[] args) {
       
       /***************************************************************************************
        * Output name, course number and section, the Java Program name, and the project number
        ***************************************************************************************/
       
          System.out.println("Sabrina Kundu");
          System.out.println("CMSC 255-001");
          System.out.println("RocketChoice.java - Project 3");
        
         /**********************************************************************************************************
          * Set goAgain variable, which is used to allow user to run through different scenarios, to a value of true
          **********************************************************************************************************/
          
          boolean goAgain = true;
          
        /************************************************************************************
         * While goAgain variable is true, ask the user to enter information about the rocket
         * and output each total measurement and costs that go into building the rocket
         * Then ask user if they want to build the rocket again.
         ************************************************************************************/
          
        while (goAgain) {  
          
          /*************************************************************
           * Declare a new object Scanner of the class java.util.Scanner
           *************************************************************/
          
          Scanner in = new Scanner(System.in);
          
          /***********************************************************************************
           * Ask user to input numerical values of the height of cylinder, radius of cylinder, 
           * height of cone, height of fin, and base of fin in centimeters.
           * If input is not completely numerical, then the program will stop.
           ***********************************************************************************/
          
          System.out.print("Give me the height of the cylinder of your rocket (cm): ");
          float cylinderHeight = in.nextFloat();
          
          System.out.print("Now, give me the radius of the cylinder of your rocket (cm): ");
          float cylinderRadius = in.nextFloat();
          
          System.out.print("I need the height of the cone of the rocket (cm): ");
          float coneHeight = in.nextFloat();
          
          System.out.print("Enter the height of the fin of the rocket (cm): ");
          float finHeight = in.nextFloat();
          
          System.out.print("Give me the base of the fin of the rocket (cm): ");
          float finBase = in.nextFloat();
          
          /************************************************************************************
           * Ask the user to input string values for the type of material and the type of fuel.
           * Ask the user if they want to have the rocket built for them.
           * Convert user input to all lowercase letters.
           * If user input is not all string values, the program will stop.
           ************************************************************************************/
          
          System.out.println("Enter the type of material for the rocket (aluminum, steel, or titanium): ");
          String materialType = in.next().toLowerCase();
          in.nextLine();
          
          System.out.println("Enter the type of fuel for the rocket (ammonium nitrate fuel or ammonium perchlorate fuel): "); 
          String fuelType = in.nextLine().toLowerCase();
   
    
          System.out.print("Do you want to have the rocket built for you? Type Y or N.");
          String build = in.nextLine().toLowerCase();
          
          /************************************************************************************
           * Declare number of fins NUM_FINS, cost of aluminum per square cm ALUM_COST,
           * cost of steel per square cm STEEL_COST, cost of titanium per square cm TITAN_COST,
           * cost of ammonium nitrate fuel per milliliter AN_FUEL, cost of ammonium perchlorate
           * fuel per milliliter AP_FUEL, and additional fee to build the rocket BUILD. Declare
           * these as constant variables.
           ************************************************************************************/
          
          final float NUM_FINS = 3;
          final double ALUM_COST = 1.25;
          final double STEEL_COST = 3.00;
          final double TITAN_COST = 5.50;
          final double AN_FUEL = 0.25;
          final double AP_FUEL = 0.45;
          final double BUILD = 59.95;
          
          /**************************************************************************************************
           * Assign the value of cylinderRadius to the variable coneRadius.
           * Calculate the surface area of the cylinder and assign value to the cylinderSurfaceArea variable.
           * Calculate the cone surface area and assign value to the coneSurfaceArea variable.
           * Calculate the fin surface area by multiplying the base of the fin by the height of the fin.
           * Assign value to finSurfaceArea variable.
           * Calculate the total surface area by adding cylinderSurfaceArea to coneSurfaceArea to the number 
           * of fins times finSurfaceArea. Assign the value to the totalSurfaceArea variable.
           * Calculate the volume of the cylinder and assign the value to amountOfFuel variable.
           **************************************************************************************************/
          
          float coneRadius = cylinderRadius;
          double cylinderSurfaceArea = 2 * Math.PI * ((cylinderRadius * cylinderHeight) + Math.pow(cylinderRadius, 2)); 
          double coneSurfaceArea = Math.PI * coneRadius * (Math.sqrt(Math.pow(coneHeight, 2) + Math.pow(coneRadius, 2)));
          float finSurfaceArea = finBase * finHeight;
          double totalSurfaceArea = cylinderSurfaceArea + coneSurfaceArea + (NUM_FINS * finSurfaceArea);
          double amountOfFuel = Math.PI * Math.pow(cylinderRadius, 2) * cylinderHeight;
          
          /***********************************************************************************************
           * Calculate material cost of a rocket made of alumimum and assign value to alumRocket variable
           * Calculate material cost of a rocket made of steel and assign value to steelRocket variable
           * Calculate material cost of a rocket made of titanium and assign value to titanRocket variable
           * Calculate cost of ammonium nitrate fueled rocket and assign value to anRocket variable
           * Calculate cost of ammonium perchlorate fueled rocket and assign value to apRocket variable
           * Set materialCost variable equal to 0
           * Set fuelCost variable equal to 0
           ***********************************************************************************************/
          
          double alumRocket = ALUM_COST * totalSurfaceArea;
          double steelRocket = STEEL_COST * totalSurfaceArea;
          double titanRocket = TITAN_COST * totalSurfaceArea; 
          double anRocket = AN_FUEL * amountOfFuel;
          double apRocket = AP_FUEL * amountOfFuel;
          double materialCost = 0;
          double fuelCost = 0;
          
          /**********************************************************************************************
           * Output cylinderSurfaceArea, coneSurfaceArea, finSurfaceArea of three fins, totalSurfaceArea,
           * the materal cost (alumRocket, steelRocket, or titanRocket), the fuel cost
           * (anRocket or apRocket), the cost to build the rocket if user chooses to have the rocket
           * built for them, and the grand total. 
           **********************************************************************************************/

          System.out.println("The rocket total measurements are: ");
          System.out.printf("Cylinder Surface area: %.2f square centimeters\n", cylinderSurfaceArea);
          System.out.printf("Cone Surface area: %.2f square centimeters\n", coneSurfaceArea);
          System.out.printf("Fin Surface area: %.2f square centimeters\n", finSurfaceArea * NUM_FINS);
          System.out.printf("Total Surface area of rocket in square centimeters: %.2f\n", totalSurfaceArea);
          
          /********************************************************************************************
           * If user types aluminum, output value of alumRocket and assign same value to materialCost.
           * If user types steel, output value of steelRocket and assign same value to materialCost.
           * If user types titanium, output value of titanRocket and assign same value to materialCost.
           * If user input does not match any of the option, output error message and keep going through
           * the rest of the code.
           ********************************************************************************************/
          
          if (materialType.equals("aluminum")) {
            System.out.printf("The material cost to build the rocket using Aluminum at $1.25 per square cm is $%.2f\n",
                              alumRocket);
            materialCost = alumRocket;
          } else if (materialType.equals("steel")) {
            System.out.printf("The material cost to build the rocket using Steel at $3.00 per square cm is $%.2f\n",
                              steelRocket);  
            materialCost = steelRocket;
          } else if (materialType.equals("titanium")) {
            System.out.printf("The material cost to build the rocket using Titanium at $5.50 per square cm is $%.2f\n",
                              titanRocket);
            materialCost = titanRocket;
          } else {
            System.out.println("Sorry, we don't have that material.");
          }
          
          /*****************************************
           * Output the amount of fuel in the rocket
           *****************************************/
          
          System.out.printf("The rocket uses %.2f cubic centimeters of fuel\n", amountOfFuel);
          
          /*****************************************************************************************
           * If the type of fuel is ammonium nitrate, output value of anRocket and assign same value
           * to fuelCost.
           * If the type of fuel is ammonium perchlorate, output value of apRocket and assign same 
           * value to fuelCost.
           * If user input does not match either of the options, output error message and continue
           * outputing the rest of the code.
           *****************************************************************************************/
          
          if (fuelType.equals("ammonium nitrate fuel") || fuelType.equals("ammonium nitrate")) {
            System.out.printf("The cost of the Ammonium Nitrate fuel at 0.25 dollars per milliliter is $%.2f\n", anRocket);
            fuelCost = anRocket;
          } else if (fuelType.equals("ammonium perchlorate fuel") || fuelType.equals("ammonium perchlorate")) {
            System.out.printf("The cost of the Ammonium Perchlorate fuel at 0.45 dollars per milliliter is $%.2f\n", apRocket);
            fuelCost = apRocket;
          } else {
            System.out.println("Sorry, we don't have that kind of fuel.");
          }
          
          /**************************************************************************************
           * If user wants to have the rocket built for them, output the fixed price for building
           * the rocket and the total cost, including the additional fee.
           * If user opts out of having the rocket built for them, output the total cost, not
           * including the extra fee.
           **************************************************************************************/
          
          if (build.equals("y")) {
            System.out.println("The cost to build the rocket is $59.95");
            System.out.printf("The grand cost of the rocket is $%.2f\n", materialCost + fuelCost + BUILD);
          } else {
            System.out.printf("The grand cost of the rocket is $%.2f\n", materialCost + fuelCost);
          }
          
          /****************************************************
           * Ask user if they want to build the rocket again.
           * If yes, set goAgain equal to true and loop through 
           * the while loop again.
           * If no, break while loop. End program.
           ****************************************************/
          
          System.out.print("Would you like to build the rocket again? Type Y or N.");
          String redo = in.nextLine().toLowerCase();
          
          if (redo.equals("y")) {
            goAgain = true;
          } else {
            break;
          }
          
     }
   }
}