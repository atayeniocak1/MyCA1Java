//https://github.com/atayeniocak1/MyCA1Java

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

// Responsibilities of Main class :
// 1. Reads customer information from an input file.
// 2. Validates the customer data and creates customer objects.
// 3. Calculates discounts based on customer class.
// 4. Writes the customer information with discounts to an output file.

public class CA1Main {
  public static void main(String[] args) {
    String inputFilePath = "customers.txt";
    String outputFilePath = "customerdiscount.txt";

    try {
      // Read customer data from input file, validate, and store in a list
      List<CA1Customer> customers = readAndValidateCustomers(inputFilePath);
      // Write the discounted customer data to output file
      writeDiscountedCustomers(outputFilePath, customers);
    } catch (IOException e) {
      System.err.println("Error handling files: " + e.getMessage());
    }
  }

  // Reads and validates customer data from file
  // This method reads all lines from the input file, validates the data, and
  // creates customer objects
  public static List<CA1Customer> readAndValidateCustomers(String filePath) throws IOException {
    List<CA1Customer> customers = new ArrayList<>();
    List<String> lines = Files.readAllLines(Paths.get(filePath));
    int lineIndex = 0;

    while (lineIndex < lines.size()) {
      try {
        // Read the first name and last name from the current set of lines
        String firstNameLastName = lines.get(lineIndex);
        // Read and parse the total purchase value from the next line
        double totalPurchase = Double.parseDouble(lines.get(lineIndex + 1));
        // Read and parse the customer class from the next line
        int customerClass = Integer.parseInt(lines.get(lineIndex + 2));
        // Read and parse the last purchase year from the next line
        int lastPurchaseYear = Integer.parseInt(lines.get(lineIndex + 3));

        // Split the first name and last name
        String[] names = firstNameLastName.split(" ");
        // Validate that the name is in the correct format (first name and last name)
        if (names.length != 2 || !isAlpha(names[0]) || !isAlphaNumeric(names[1])) {
          throw new IllegalArgumentException("Invalid name format.");
        }

        // Validate that the customer class is between 1 and 3
        if (customerClass < 1 || customerClass > 3) {
          throw new IllegalArgumentException("Customer class must be between 1 and 3.");
        }

        // Validate that the last purchase year is within a realistic range (1900 to
        // 2024)
        if (lastPurchaseYear < 1900 || lastPurchaseYear > 2024) {
          throw new IllegalArgumentException("Invalid last purchase year.");
        }

        // Create customer object if validation passes and add it to the list
        customers.add(new CA1Customer(names[0], names[1], totalPurchase, customerClass, lastPurchaseYear));
      } catch (Exception e) {
        // Handle any validation or parsing errors and provide an error message with the
        // line number
        System.err.println("Error in customer data at line " + (lineIndex + 1) + ": " + e.getMessage());
      }
      // Move to the next set of 4 lines for the next customer
      lineIndex += 4;
    }
    return customers;
  }

  // Writes the customer discount data to output file
  // This method takes a list of customers and writes their discounted values to
  // the output file
  public static void writeDiscountedCustomers(String filePath, List<CA1Customer> customers) throws IOException {
    List<String> lines = new ArrayList<>();
    for (CA1Customer customer : customers) {
      // Format the output as "<First Name> <Second Name>\n<Final Value>"
      lines.add(customer.getFirstName() + " " + customer.getSecondName());
      lines.add(String.format("%.2f", customer.getFinalValue()));
      lines.add(""); // Add an empty line after each customer
    }
    Files.write(Paths.get(filePath), lines);
  }

  // Validates if a string contains only alphabetic characters
  // This method is used to validate first names, ensuring only letters are
  // present
  private static boolean isAlpha(String str) {
    return str.matches("[a-zA-Z]+");
  }

  // Validates if a string contains only alphanumeric characters
  // This method is used to validate second names, allowing letters and numbers
  private static boolean isAlphaNumeric(String str) {
    return str.matches("[a-zA-Z0-9]+");
  }
}
