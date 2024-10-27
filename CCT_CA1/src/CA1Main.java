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

          }catch {
            System.err.println();
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
