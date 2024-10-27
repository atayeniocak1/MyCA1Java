
public class CA1Assignment {
  // fields needed for the asignment:
  // Line 1 – <First Name> <Second Name>
  // Line 2–<
  // Total Purchase>
  // Line 3–<Class>
  // Line 4-<Last Purchase>
  public static void main(String[] args) {

    // This main method can be used to initiate the customer processing by calling
    // other methods
    // For now, it serves as an entry point to the application, which can be
    // expanded later
  }

  // Validates if the given first name is valid, i.e., contains only letters
  // The method iterates through each character of the firstName and checks if
  // it's a letter
  // If any character is not a letter, the method returns false, indicating that
  // the name is invalid otherwise, it returns true
  public boolean isValidFirstName(String firstName) {
    // Loop through each character in the first name string
    for (int i = 0; i < firstName.length(); i++) {
      // Character.isLetter() returns true if the character is a letter; false
      // otherwise
      if (!Character.isLetter(firstName.charAt(i))) {
        // If any character is not a letter, the name is considered invalid
        return false;
      }
    }
    // If we reach here, it means all characters are valid letters

    return true;
  }

}
