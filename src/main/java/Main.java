import java.io.File;

public class Main {
  public static void main(String[] args) {
    PrintHandler printHandler = new PrintHandler();
    ReadImage readImage = new ReadImage();
    InputHandler inputHandler = new InputHandler();
    PasswordHashing hashing = new PasswordHashing();

    printHandler.printString("Please enter path of file: ");
    inputHandler.readString();
    String filePath = inputHandler.getString();

    readImage.readFile(filePath);
    File file = readImage.provideFile();
    printHandler.printString("File Path: " + file.getAbsolutePath());
    printHandler.printString("File Name: " + file.getName());

    printHandler.printString("Please enter a password: ");
    inputHandler.readString();
    String password = inputHandler.getString();
    String hash = hashing.stringToHash(password);

    System.out.println(hash);
  }
}