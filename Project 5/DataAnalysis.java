import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Sabrina Kundu
 * CMSC 255-001 Fall 2017
 * Project 5 - DataAnalysis.java
 * 
 * Description: 
 * This program reads an input file containing the high temperature,
 * low temperature and rainfall amount for each day of a given month
 * of the year for a certain city. First, it reads in the month and
 * year to determine the number of days in the month that the data
 * was collected. Next, it calculates the average high temperature,
 * average low temperature, and total rainfall for the month. Then,
 * the program adds a "+" beside the temperature that is above the
 * average and adds a "-" beside the temperature that is below the
 * average. It also add a "*" beside every rainfall amount that is 
 * greater than 0.00. The results are written to a file called
 * "dataOutput.txt". Finally, the program asks the user if they want
 * to process another file. If yes, the program will go through the
 * process again and output dataOutput.txt. If no, the program will
 * stop.
 * 
 * Instructions:
 * 1. Enter the name of the text file that contains the weather data
 * information (month, day, year, number of days, high temperatures,
 * low temperatures, and rainfall amount) for every day of the month.
 * Make sure the structure and type of information is similar to the
 * sample file "weatherData.txt". If the file can not be found, check
 * if it's saved in the same folder as DataAnalysis.java
 * 2. Press the Enter key
 * 3. Go to the folder that contains DataAnalysis.java and find the
 * file names "dataOutput.txt"
 * 4. Open the file with Notepad++ to see the results
 * 5. If you want to process another weather data file, type "yes" into
 * the input box that exists in the console. If you are done, type "no"
 * and the program will stop. Make sure "yes" or "no" has all lowercase
 * letters and is spelled correctly. Do not type additional characters.
 */

public class DataAnalysis {

    public static void printHeading() {
      System.out.println("Sabrina Kundu");
      System.out.println("CMSC 255-001");
      System.out.println("Project 5 - DataAnalysis.java");
    }
    
    /**
     * Calculates number of days in some month of some year
     * @param month - month of the calculations
     * @param year - year of the calculations
     * @return number of days that month
     */
  
    private static int numDaysInMonth(String month, int year) {
        if (month.equals("January")) {
            return 31;
        } else if (month.equals("February")) {
          
            /**
             * Leap year check 
             */
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                return 29;
            /**
             * Regular year
             */
            } else { 
                return 28;
            }
        } else if (month.equals("March")) {
            return 31;
        } else if (month.equals("April")) {
            return 30;
        } else if (month.equals("May")) {
            return 31;
        } else if (month.equals("June")) {
            return 30;
        } else if (month.equals("July")) {
            return 31;
        } else if (month.equals("August")) {
            return 31;
        } else if (month.equals("September")) {
            return 30;
        } else if (month.equals("October")) {
            return 31;
        } else if (month.equals("November")) {
            return 30;
        } else if (month.equals("December")) {
            return 31;
        }

        /**
         * Default value
         */
        return 0;
    }

    /**
     * Calculates average value of the integer array
     * @param temp - array of the integers
     * @return average of the array
     */
    private static int calculateAverage(int [] temp) {
      
        /**
         * Calculate the sum of the array's elements
         */
        int sum = 0;
        for (int value : temp) {
            sum += value;
        }

        /**
         * Return calculated average
         */
        return (int) Math.round(((double) sum) / temp.length);
    }

    /**
     * Calculates the sum of the doubles array
     * @param rainfall - array of doubles
     * @return sum of elements
     */
    private static double calculateSum(double [] rainfall) {
      
        /**
         * Calculate the sum of the array's elements
         */
        double sum = 0;
        for (double value : rainfall) {
            sum += value;
        }

        return sum;
    }

    /**
     * Processes one data file
     * @param fileName - name of a file with input data
     */
    private static void processFileData(String fileName) {
        /**
         * Try to open the input file
         */
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
        } catch (Exception e) { 
            /**
             * Show error message if something goes worng
             */
            System.out.println("Can't open the input file!");
            return;
        }

        /**
         * Open scanner to read from file
         */
        Scanner fileScanner = new Scanner(fileReader);

        /**
         * Read month information 
         */
        int year = fileScanner.nextInt();
        String month = fileScanner.next();
        String city = fileScanner.next();

        /**
         * Calculate number of days in the month and assign to daysCount variable
         */
        int daysCount = numDaysInMonth(month, year);

        /**
         * Create three arrays 
         */
        int[] daysTemperatureLow = new int[daysCount];
        int[] daysTemperatureHigh = new int[daysCount];
        double[] daysRainfall = new double[daysCount];

        /**
         * Read days
         */
        for (int i = 0; i < daysCount; i++) {
          
            /**
             * Read day number from the file
             */
            int day = fileScanner.nextInt() - 1;

            /**
             * Read day data
             */
            daysTemperatureHigh[day] = fileScanner.nextInt();
            daysTemperatureLow[day] = fileScanner.nextInt();
            daysRainfall[day] = fileScanner.nextDouble();
        }

        /**
         * Close input file
         */
        fileScanner.close();

        /**
         * Calculate average temperatures and total rainfall
         */
        int averageLow = calculateAverage(daysTemperatureLow);
        int averageHigh = calculateAverage(daysTemperatureHigh);
        double totalRainfall = calculateSum(daysRainfall);

        /**
         * Try opening output file
         */
        PrintWriter fileWriter;
        try {
            fileWriter = new PrintWriter(new FileWriter("dataOutput.txt"));
        } catch (IOException e) { 
            /**
             * If something went wrong
             */
            System.out.println("Can't open the output file!");
            return;
        }

        /**
         * Output month, year, city, average temperatures, and total rainfall to output file
         */
        fileWriter.format("For the month of %s %d in %s:\r\n", month, year, city);
        fileWriter.format("The average high temperature was %d degrees.\r\n", averageHigh);
        fileWriter.format("The average low temperature was %d degrees.\r\n", averageLow);
        fileWriter.format("The total rainfall was %.2f inches.\r\n", totalRainfall);

        /**
         * Print each day
         */
        for (int i = 0; i < daysCount; i++) {
            /**
             * Determine additional characters that will be printed
             */
            final String comparisonString = "- +";
            char lowChar = comparisonString.charAt(new Integer(daysTemperatureLow[i]).compareTo(averageLow) + 1);
            char highChar = comparisonString.charAt(new Integer(daysTemperatureHigh[i]).compareTo(averageHigh) + 1);
            char rainfallChar = (daysRainfall[i] > 0) ? '*' : ' ';

            /**
             * Print day information
             */
         
            fileWriter.format("%-2d\t%d%c\t%d%c\t%.2f%c\r\n", i + 1, daysTemperatureHigh[i], highChar, daysTemperatureLow[i],
                    lowChar, daysRainfall[i], rainfallChar);
        }

        /**
         * Close output file
         */
        fileWriter.close();
    }

    public static void main(String[] args) {
      
        printHeading();
        
        /**
         * For decimal format
         */
        Locale.setDefault(Locale.US);
        /**
         * Read from console
         */
        Scanner scanner = new Scanner(System.in);
        
        /**
         * Store answer from user about processing another file
         */
        String repeatAnswer; 

        do {
            /**
             * Read file name
             */
            System.out.println("Enter input file name: ");
            String fileName = scanner.nextLine();

            /**
             * Process file
             */
            processFileData(fileName);

            /**
             * Prompt user, should we do one more iteration?
             */
            System.out.println("Process another file (yes/no): ");
            repeatAnswer = scanner.nextLine();
        } while (repeatAnswer.equals("yes"));
    }
}
