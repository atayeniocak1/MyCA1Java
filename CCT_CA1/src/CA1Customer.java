//https://github.com/atayeniocak1/MyCA1Java

public class CA1Customer {
  // This class represents a customer and contains information such as the
  // customer's name, total purchase amount,
  // customer class, last purchase year, and the calculated final value after
  // applying discounts.

  private String firstName; // The first name of the customer
  private String secondName; // The second name of the customer
  private double totalPurchase; // The total purchase amount by the customer
  private int customerClass; // The customer class (used to determine discounts)
  private int lastPurchaseYear; // The year of the customer's last purchase
  private double finalValue; // The final value after applying any discounts

  // Constructor initializes the customer fields and calculates the discount value
  public CA1Customer(String firstName, String secondName, double totalPurchase, int customerClass,
      int lastPurchaseYear) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.totalPurchase = totalPurchase;
    this.customerClass = customerClass;
    this.lastPurchaseYear = lastPurchaseYear;
    calculateFinalValue(); // Calculate the final value immediately after initialization
  }

  // Calculates the final value based on class and year criteria
  // This method applies a discount based on the customer class and the year of
  // the last purchase
  private void calculateFinalValue() {
    double discount = 0;
    // Determine the discount percentage based on customer class and last purchase
    // year
    // Determine the discount based on customer class and last purchase year

    // Check if the customer belongs to Class 1
    if (customerClass == 1) {
      // For Class 1 customers:
      // If the last purchase year is 2024, apply a 30% discount
      // If the last purchase year is between 2019 and 2023, apply a 20% discount
      // Otherwise, apply a 10% discount
      discount = lastPurchaseYear == 2024 ? 0.30 : (lastPurchaseYear >= 2019 ? 0.20 : 0.10);
    }
    // Check if the customer belongs to Class 2
    else if (customerClass == 2) {
      // For Class 2 customers:
      // If the last purchase year is 2024, apply a 15% discount
      // If the last purchase year is between 2019 and 2023, apply a 13% discount
      // Otherwise, apply a 5% discount
      discount = lastPurchaseYear == 2024 ? 0.15 : (lastPurchaseYear >= 2019 ? 0.13 : 0.05);
    }
    // Check if the customer belongs to Class 3
    else if (customerClass == 3) {
      // For Class 3 customers:
      // If the last purchase year is 2024, apply a 3% discount
      // Otherwise, apply no discount (0%)
      discount = lastPurchaseYear == 2024 ? 0.03 : 0.00;
    }

    // End of discount determination
    // Calculate the final value after applying the discount
    finalValue = totalPurchase * (1 - discount);
  }

  // Getter for first name
  public String getFirstName() {
    return firstName;
  }

  // Getter for second name
  public String getSecondName() {
    return secondName;
  }

  // Getter for final value after discount
  public double getFinalValue() {
    return finalValue;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  public double getTotalPurchase() {
    return totalPurchase;
  }

  public void setTotalPurchase(double totalPurchase) {
    this.totalPurchase = totalPurchase;
  }

  public int getCustomerClass() {
    return customerClass;
  }

  public void setCustomerClass(int customerClass) {
    this.customerClass = customerClass;
  }

  public int getLastPurchaseYear() {
    return lastPurchaseYear;
  }

  public void setLastPurchaseYear(int lastPurchaseYear) {
    this.lastPurchaseYear = lastPurchaseYear;
  }

  public void setFinalValue(double finalValue) {
    this.finalValue = finalValue;
  }
}