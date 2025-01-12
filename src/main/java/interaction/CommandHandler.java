package interaction;

import encryption.Encryption;
import encryption.PasswordHashing;
import utils.InputHandler;
import utils.PrintHandler;

import java.io.File;
import java.util.HashMap;

public class CommandHandler {
  private InputHandler inputHandler;
  private PrintHandler printHandler;
  private Encryption encryption;
  private PasswordHashing hashing;
  private ReadImage readImage;

  public CommandHandler() {
    this.inputHandler = new InputHandler();
    this.printHandler = new PrintHandler();
    this.encryption = new Encryption();
    this.hashing = new PasswordHashing();
    this.readImage = new ReadImage();
  }

  public void encrypt() {
    printHandler.printString("Please enter path of file to encrypt: ");
    inputHandler.readString();
    String inputPath = inputHandler.getString();
    readImage.
    File inputFile = readImage.provideFile();

    printHandler.printString("Please enter output path: ");
    inputHandler.readString();
    String outputPath = inputHandler.getString();
    File outputFile

    printHandler.printString("Please enter an encryption password: ");

  }
}
