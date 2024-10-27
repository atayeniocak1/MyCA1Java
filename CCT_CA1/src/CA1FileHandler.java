
import java.io.*;
import java.util.ArrayList;
import java.util.List;
// This class is for handling file operations, such as reading and writing to files.
// It allows you to read customer information from a file and write it back after processing.

public class CA1FileHandler {
  // Method to read all lines from a file and return them as a list of strings.
  // This is useful for reading data from a file line by line.

  public List<String> readLinesFromCA1File(String filePath) throws IOException {
    // Create a list to store the lines read from the file
    List<String> lines = new ArrayList<>();
    BufferedReader br = null;
    try {
      // Open the file for reading using BufferedReader
      br = new BufferedReader(new FileReader(filePath));
      String line;
      // Read each line from the file until there are no more lines
      while ((line = br.readLine()) != null) {
        // Add each line to the list
        lines.add(line);
      }
    } finally {
      // Close the BufferedReader to avoid memory leaks
      if (br != null) {
        br.close();
      }
    }
    // Return the list containing all lines from the file
    return lines;
  }

  // Method to write a list of customers to a file.
  // This is useful for saving customer information, such as their names and final
  // values.

  public void writeLinesToCA1File(String filePath, List<CA1Customer> customers)
      throws IOException {
    BufferedWriter bufferedWriter = null;
    try {
      // Open the file for writing using BufferedWriter
      bufferedWriter = new BufferedWriter(new FileWriter(filePath));
      for (CA1Customer customer : customers) {
        // Write customer details to the file in the format:
        // "FirstName SecondName \n FinalValue\n"
        bufferedWriter
            .write(customer.getFirstName() + " " + customer.getSecondName() + "\n" +
                customer.getFinalValue() + "\n\n");
      }
    } finally {
      // Close the BufferedWriter to avoid memory leaks
      if (bufferedWriter != null) {
        bufferedWriter.close();
      }
    }
  }
}
