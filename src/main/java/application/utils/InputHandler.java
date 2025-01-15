package application.utils;

import java.util.Scanner;

/**
 * The InputHandler class is responsible for handling user input from the console.
 * It provides methods to read and retrieve string and integer inputs.
 */
public class InputHandler {
  private final Scanner scanner;
  private String stringInput;
  private int intInput;

  /**
   * Constructs a new InputHandler instance with a Scanner for console input.
   */
  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  /**
   * Reads a line of text from the console and stores it as a string.
   */
  public void readString() {
    stringInput = scanner.nextLine();
  }

  /**
   * Returns the last string input read from the console.
   *
   * @return the string input
   */
  public String getString() {
    return stringInput;
  }

  /**
   * Reads an integer from the console and stores it.
   */
  public void readInt() {
    intInput = scanner.nextInt();
  }

  /**
   * Returns the last integer input read from the console.
   *
   * @return the integer input
   */
  public int getInt() {
    return intInput;
  }
}