package application.interaction;

import application.encryption.Encryption;
import application.encryption.PasswordHashing;
import application.utils.InputHandler;
import application.utils.PrintHandler;
import application.ReadImage;

import javax.crypto.SecretKey;
import java.io.File;

public class CommandHandler {
  private final InputHandler inputHandler;
  private final PrintHandler printHandler;
  private final Encryption encryption;
  private final PasswordHashing hashing;
  private final ReadImage readImage;

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
    readImage.readFile(inputPath);
    File inputFile = readImage.provideFile();

    printHandler.printString("Please enter output path: ");
    inputHandler.readString();
    String outputPath = inputHandler.getString();
    File outputFile = new File(outputPath);

    printHandler.printString("Please enter a password: ");
    inputHandler.readString();
    String password = inputHandler.getString();
    hashing.stringToHash(password);
    SecretKey key = hashing.getKey();
    encryption.encrypt(inputFile, key);
  }

  public void decrypt() {
    printHandler.printString("Please enter path of file to decrypt: ");
    inputHandler.readString();
    String decryptInputPath = inputHandler.getString();
    File decryptInputFile = new File(decryptInputPath);

    printHandler.printString("Please enter output path of decrypted file: ");
    inputHandler.readString();
    String decryptOutputPath = inputHandler.getString();
    File decryptOutputFile = new File(decryptOutputPath);

    printHandler.printString("Please enter the password for decryption: ");
    inputHandler.readString();
    String decryptPassword = inputHandler.getString();
    hashing.stringToHash(decryptPassword);
    SecretKey decryptKey = hashing.getKey();
    encryption.decrypt(decryptInputFile, decryptKey);
  }
}
