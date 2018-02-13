
/*
 * Sabrina Kundu
 * RocketClass.java
 * 
 * Description:
 * This program contains an object class called RocketClass that builds instances
 * of rocket objects. The instance passes in dimensions of the rocket and has a method
 * to access and mutate all the dimensions. It accesses the Material and Fuel enum classes
 * from Material.java and Fuel.java to calculate the material price and fuel price to
 * build the rocket. The class also calculates the volume and surface area of the rocket
 * as well as the build cost, fuel cost, and overall cost of the rocket. The price is 
 * determined by the size of the rocket, the cost of the rocket, and the cost of the rocket
 * material. This program also creates a default rocket where the user does not provide any values
 * and a default size rocket is created.
 * 
 * Instructions:
 * 1. Do not run this program. It will show a static error because this 
 * program does not have a static void main method accepting String[].
 * 2. Run the RocketTest.java program, which uses this Java file to create 
 * the rocket objects.
 * 3. Make sure this file is saved in the same folder as RocketTest.java,
 * Material.java, and Fuel.java. 
 */

/*
 * Declares dimensions, material type, and fuel type variables in object class RocketClass
 */
public class RocketClass {
 private double cylinderHeight;
 private double cylinderRadius;
 private double coneHeight;
 private double finHeight;
 private double finBase;
 private Material material;
 private Fuel fuel;

 /*
  * Sets dimensions, material type, and fuel type to default values
  */
 public RocketClass() {
  this.cylinderHeight = 150;
  this.cylinderRadius = 25;
  this.coneHeight = 45;
  this.finHeight = 50;
  this.finBase = 30;
  /*
   * Call Material type with default value STEEL and assign to material variable
   * Call Fuel type with default value PERCHLORATE and assign to fuel variable
   */
  this.material = Material.STEEL;
  this.fuel = Fuel.PERCHLORATE;
 }

 /*
  * Gets current data of dimensions, material type, or fuel type and 
  * assigns to the variables in object class RocketClass
  * @param cylinderHeight - height of cylinder of rocket 
  * @param cylinderRadius - radius of cylinder of rocket
  * @param coneHeight - height of cone of rocket 
  * @param finHeight - height of fin of rocket 
  * @param finBase - base of fin of rocket
  * @param material - material type for rocket
  * @param fuel - fuel type for rocket
  */
 public RocketClass(double cylinderHeight, double cylinderRadius, double coneHeight, double finHeight,
   double finBase, Material material, Fuel fuel) {
     this.cylinderHeight = cylinderHeight;
     this.cylinderRadius = cylinderRadius;
     this.coneHeight = coneHeight;
     this.finHeight = finHeight;
     this.finBase = finBase;
     this.material = material;
     this.fuel = fuel;
 }
 
 /*
  * Calculates surface area of cylinder of rocket
  */
 public double calcCylinderSurfaceArea() {
  return 2 * Math.PI * cylinderRadius * cylinderHeight + 2 * Math.PI * Math.pow(cylinderRadius, 2);
 }

 /*
  * Calculates surface area of cone of rocket
  */
 public double calcConeSurfaceArea() {
  return Math.PI * cylinderRadius * Math.sqrt(Math.pow(coneHeight, 2) + Math.pow(cylinderRadius, 2));
 }

 /*
  * Calculates surface area of fin of rocket 
  */
 public double calcFinSurfaceArea() {
  return finBase * finHeight;
 }

 /*
  * Calculates total surface area of rocket
  */
 public double calcTotalSurfaceArea() {
  return calcCylinderSurfaceArea() + calcConeSurfaceArea() + calcFinSurfaceArea() * 3;
 }

 /*
  * Calculates material cost to build rocket 
  */
 public double calcTotalMaterialCost() {
  return calcTotalSurfaceArea() * material.getPrice();
 }

 /*
  * Calculates the amount of fuel the rocket uses
  */
 public double calcTotalFuel() {
  return Math.PI * Math.pow(cylinderRadius, 2) * cylinderHeight;
 }

 /*
  * Calculates the total cost of fuel
  */
 public double calcTotalFuelCost() {
  return calcTotalFuel() * fuel.getPrice();
 }

 /*
  * Calculates the total cost of building the rocket by adding total fuel cost and total material cost
  */
 public double calcGrandRocketCost() {
  return calcTotalFuelCost() + calcTotalMaterialCost();
 }

 /*
  * Returns height of cylinder of rocket
  */
 public double getCylinderHeight() {
  return cylinderHeight;
 }

 /*
  * Returns radius of cylinder of rocket
  */
 public double getCylinderRadius() {
  return cylinderRadius;
 }

 /*
  * Outputs rocket information
  */
 @Override
 public String toString() {
  /*
   * Creates empty string builder, capacity 16
   */
  StringBuilder sb = new StringBuilder();
  sb
  /*
   * Adds strings to the builder
   */
  .append("\n")
  .append("   The rocket total measurements are:")
  .append("\n")
  .append("    Cylinder Surface area: " + String.format("%.2f", calcCylinderSurfaceArea()) + " square centimeters")
  .append("\n")
  .append("    Cone Surface area: " + String.format("%.2f", calcConeSurfaceArea()) + " square centimeters")
  .append("\n")
  .append("    Fin Surface area: " + String.format("%.2f", calcFinSurfaceArea()) + " x 3 = " + String.format("%.2f", calcFinSurfaceArea() * 3) + " square centimeters")
  .append("\n")
  .append("    Total Surface area in square centimeters to build the rocket: " + String.format("%.2f", calcTotalSurfaceArea()))
  .append("\n")
  .append("    The material cost to build the rocket using " + material + " at $" + String.format("%.2f", material.getPrice()) + " per square centimeter is $" + String.format("%.2f", calcTotalMaterialCost()))
  .append("\n")
  .append("    The rocket uses " + String.format("%.2f", calcTotalFuel()) +  " cubic centimeters of fuel")
  .append("\n")
  .append("    The cost of the " + fuel + " fuel at " + String.format("%.2f", fuel.getPrice()) + " dollars per milliliter is $" + String.format("%.2f", calcTotalFuelCost()))
  .append("\n")
  .append("    The grand cost of the rocket is: $" + String.format("%.2f", calcGrandRocketCost()));
  return sb.toString();
 }

}
