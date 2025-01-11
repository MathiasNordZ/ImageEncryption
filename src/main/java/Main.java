import encryption.Encryption;
import encryption.PasswordHashing;
import utils.InputHandler;
import utils.PrintHandler;

import javax.crypto.SecretKey;
import java.io.File;

public class Main {
  public static void main(String[] args) {
    PrintHandler printHandler = new PrintHandler();
    ReadImage readImage = new ReadImage();
    InputHandler inputHandler = new InputHandler();
    PasswordHashing hashing = new PasswordHashing();
    Encryption encryption = new Encryption();

    printHandler.printString("Please enter path of file to encrypt: ");
    inputHandler.readString();
    String inputPath = inputHandler.getString();
    readImage.readFile(inputPath);
    File inputFile = readImage.provideFile();

    printHandler.printString("Please enter output path of encrypted file: ");
    inputHandler.readString();
    String outputPath = inputHandler.getString();
    File outputFile = new File(outputPath);

    printHandler.printString("Please enter a password: ");
    inputHandler.readString();
    String password = inputHandler.getString();
    hashing.stringToHash(password);
    SecretKey key = hashing.getKey();
    encryption.encrypt(inputFile, outputFile, key);

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
    encryption.decrypt(decryptInputFile, decryptOutputFile, decryptKey);
  }
}