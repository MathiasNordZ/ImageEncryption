package application.encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

public class Encryption {
  private Cipher cipher;

  public void encrypt(File inputFile, SecretKey secretKey) {
    try {
      cipher = Cipher.getInstance("AES/GCM/NoPadding");
      byte[] iv = new byte[16];
      SecureRandom random = new SecureRandom();
      random.nextBytes(iv);
      GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

      File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

      try (FileInputStream inputStream = new FileInputStream(inputFile);
           FileOutputStream outputStream = new FileOutputStream(tempFile)) {

        outputStream.write(iv);
        cryptoLogic(inputStream, outputStream);
      }

      if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
        throw new IOException("Failed to overwrite the original file.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public void decrypt(File inputFile, SecretKey secretKey) {
    try {
      cipher = Cipher.getInstance("AES/GCM/NoPadding");
      File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");

      try (FileInputStream inputStream = new FileInputStream(inputFile);
           FileOutputStream outputStream = new FileOutputStream(tempFile)) {

        byte[] iv = new byte[16];
        inputStream.read(iv);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

        cryptoLogic(inputStream, outputStream);
      }

      if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
        throw new IOException("Failed to overwrite the original file.");
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private void cryptoLogic(FileInputStream inputStream, FileOutputStream outputStream) throws IOException, IllegalBlockSizeException, BadPaddingException {
    byte[] buffer = new byte[4096];
    int bytesRead;

    while ((bytesRead = inputStream.read(buffer)) != -1) {
      byte[] output = cipher.update(buffer, 0, bytesRead);
      if (output != null) {
        outputStream.write(output);
      }
    }
    byte[] outputBytes = cipher.doFinal();
    if (outputBytes != null) {
      outputStream.write(outputBytes);
    }
  }
}