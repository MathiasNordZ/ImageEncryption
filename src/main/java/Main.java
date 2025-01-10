import java.io.File;

public class Main {
  public static void main(String[] args) {
    PrintHandler printHandler = new PrintHandler();
    ReadImage readImage = new ReadImage();
    InputHandler inputHandler = new InputHandler();

    printHandler.printString("Please enter path of file: ");
    inputHandler.readString();
    String filePath = inputHandler.getString();

    readImage.readFile(filePath);
    File file = readImage.provideFile();
    printHandler.printString("File Path: " + file.getAbsolutePath());
    printHandler.printString("File Name: " + file.getName());
  }
}