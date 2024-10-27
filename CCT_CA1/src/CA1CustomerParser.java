import java.util.List;

public class CA1CustomerParser {
  public static CA1Customer parseCA1Customer(List<String> customerData) {
    // Validate that the input contains exactly 4 lines of data
    if (customerData.size() != 4) {
      throw new IllegalArgumentException("Invalid customer data format: expected 4 lines of data.");
    }

    // Extract first name and last name from the first line
    String firstNameLastName = customerData.get(0);
    String[] names = firstNameLastName.split(" ");
    // Validate that the name format contains exactly two parts: first name and last
    // name
    if (names.length != 2) {
      throw new IllegalArgumentException("Invalid name format: expected first name and last name.");
    }
    String firstName = names[0]; // Assign the first part to firstName
    String secondName = names[1]; // Assign the second part to secondName

    // Parse the total purchase value from the second line
    double totalPurchase;
    try {
      totalPurchase = Double.parseDouble(customerData.get(1)); // Convert the string to a double value
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid total purchase value: must be a valid number.");
    }

    // Parse the customer class from the third line
    int customerClass;
    try {
      customerClass = Integer.parseInt(customerData.get(2)); // Convert the string to an integer
      // Validate that the customer class is between 1 and 3 (inclusive)
      if (customerClass < 1 || customerClass > 3) {
        throw new IllegalArgumentException("Customer class must be between 1 and 3.");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid customer class value: must be an integer.");
    }

    // Parse the last purchase year from the fourth line
    int lastPurchaseYear;
    try {
      lastPurchaseYear = Integer.parseInt(customerData.get(3)); // Convert the string to an integer
      // Validate that the last purchase year is within a realistic range (e.g.,
      // between 1900 and 2024)
      if (lastPurchaseYear < 1900 || lastPurchaseYear > 2024) {
        throw new IllegalArgumentException("Invalid last purchase year: must be between 1900 and 2024.");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid last purchase year value: must be an integer.");
    }

    // If all data is valid, create and return a new CA1Customer object
    return new CA1Customer(firstName, secondName, totalPurchase, customerClass, lastPurchaseYear);
  }
}
