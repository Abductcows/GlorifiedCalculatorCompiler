package utilities;

import java.io.*;
import java.time.LocalDateTime;

/**
 * MIPS assembly code writer class
 * <p>
 * initialiseFiles() is initially called to create the .asm file and the temporary files for the current program
 * </p>
 * <p>
 * following are 0 or more calls of writeData() and/or writeText(), which append lines of code to the tempData and
 * tempText files
 * </p>
 * <p>
 * finally, mergeFiles() is called, which merges the contents of both temp files and creates the final .asm file. This
 * method also deletes the temporary files
 * </p>
 */
public class MIPSWriter {

  public static String lastMIPSFileName;

  private File outputFile;
  private File tempData;
  private File tempText;

  private BufferedWriter dataWriter;
  private BufferedWriter textWriter;

  /**
   * Argument String specifies the name for the output .asm file. Defaults to current time-data if not specified
   * @param outputFileName  desired output file name
   */
  public MIPSWriter(String outputFileName) {
    if (outputFileName.isBlank()) {
      outputFileName = LocalDateTime.now().toString();
    }
    MIPSWriter.lastMIPSFileName = outputFileName;
  }

  /**
   * Creates the .asm and temp files and adds the boilerplate to the temp data and text files
   */
  public void initialiseFiles() {
    // create temp file objects
    tempData = new File(lastMIPSFileName + "tempData");
    tempText = new File(lastMIPSFileName + "tempText");
    // create final file object
    lastMIPSFileName = lastMIPSFileName + ".asm";
    outputFile = new File(lastMIPSFileName);

    try {
      dataWriter = new BufferedWriter(new FileWriter(tempData));
      textWriter = new BufferedWriter(new FileWriter(tempText));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Create the data and text files
    appendData(".data");
    appendText(".text");
  }

  /**
   * Appends data string to the tempData file
   *
   * @param s  String to be appended
   */
  public void appendData(String s) {
    try {
      dataWriter.append(s);
      dataWriter.append("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Appends text string to the tempText file
   *
   * @param s  String to be appended
   */
  public void appendText(String s) {
    try {
      textWriter.append(s);
      textWriter.append("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Copies the contents of both temporary files to create the final .asm file. Copies data first
   */
  public void mergeFiles() {
    // Close temp writers
    try {
      dataWriter.close();
      textWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
      String nextLine;
      // Copy the two files in (data, text) order
      File[] tempFiles = { tempData, tempText };
      for (File file : tempFiles) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
          while ( (nextLine = reader.readLine()) != null ) {
            writer.append(nextLine);
            writer.append("\n");
          }
        }
      }
      // delete the temp files
      tempData.delete();
      tempText.delete();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void abortAndCleanupInitializedFiles() {
    if (tempData.exists()) {
      mergeFiles();
      new File(outputFile + ".asm").delete();
    }
  }
}
