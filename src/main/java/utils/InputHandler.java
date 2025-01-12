package utils;

import java.util.Scanner;

public class InputHandler {
  private final Scanner scanner;
  private String stringInput;
  private int intInput;

  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  public void readString() {
    stringInput = scanner.nextLine();
  }

  public String getString() {
    return stringInput;
  }

  public void readInt() {
    intInput = scanner.nextInt();
  }

  public int getInt() {
    return intInput;
  }
}