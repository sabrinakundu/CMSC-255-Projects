
/*
 * Sabrina Kundu
 * Material.java 
 * 
 * Description:
 * This program is an enumeration class for the material type,
 * which declares a variable of the type Material and takes values
 * of either Material.ALUMINUM, Material.STEEL, or Material.TITANIUM,
 * but nothing else.
 * 
 * Instructions:
 * 1. Do not change the code in this program
 * 2. Make sure this Java file is saved in the
 * same folder as RocketClass.java, RocketTest.java, and Fuel.java
 */

public enum Material {
 /*
  * Define list of permissable items in this construct
  */
 ALUMINUM(1.25), STEEL(3.00), TITANIUM(5.50);

 /*
  * Declares variable for price of material
  */
 private double price;

 /*
  * Gets current data of material price and
  * assigns to the price variable in enum class Material 
  */
 Material(double price) {
  this.price = price;
 }

 /*
  * Returns price of material
  */
 public double getPrice() {
  return price;
 }

}
