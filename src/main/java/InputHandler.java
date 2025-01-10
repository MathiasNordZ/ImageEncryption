import java.util.Scanner;

public class InputHandler {
  private final Scanner scanner;
  private String stringInput;

  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  public void readString() {
    stringInput = scanner.nextLine();
  }

  public String getString() {
    return stringInput;
  }
}