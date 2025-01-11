import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.SecureRandom;

public class Encryption {
  private Cipher cipher;

  public void encrypt(File originalFile, Key secretKey) {
    try {
      Cipher.getInstance("AES/GCM/NoPadding");
      byte[] iv = new byte[16];
      SecureRandom random = new SecureRandom();
      random.nextBytes(iv);
      GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

      FileInputStream inputStream = new FileInputStream(originalFile);
      FileOutputStream outputStream = new FileOutputStream(originalFile);

      outputStream.write(iv);
      byte[] buffer = new byte[4096];
      int bytesRead;

      while (byt)

    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}