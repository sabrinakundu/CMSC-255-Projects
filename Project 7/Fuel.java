
/*
 * Sabrina Kundu
 * Fuel.java 
 * 
 * Description:
 * This program is an enumeration class for the fuel type,
 * which declares a variable of the type Fuel and takes values
 * of either Fuel.NITRATE or Fuel.PERCHLORATE, but nothing else. 
 * 
 * Instructions:
 * 1. Do not change the code in this program
 * 2. Make sure this Java file is saved in the
 * same folder as RocketClass.java, RocketTest.java, and Material.java
 */

public enum Fuel {
 /*
  * Defines list of permissable items in this construct
  */
 NITRATE(0.25), PERCHLORATE(0.45);

 /*
  * Declares variable for price of fuel
  */
 private double price;

 /*
  * Gets current data of fuel price and 
  * assigns to the price variable in enum class Fuel
  */
 Fuel(double price) {
  this.price = price;
 }

 /*
  * Returns price of fuel
  */
 public double getPrice() {
  return price;
 }
}