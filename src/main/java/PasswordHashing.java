import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * This class provides functionality for hashing passwords using the PBKDF2
 * algorithm with HMAC-SHA512. It includes methods to convert a string password
 * into a hashed representation.
 * The hashing process uses a fixed salt and a specified number of iterations
 * and key length to generate a secure hash.
 */
public class PasswordHashing {
  private static final int ITERATIONS = 10000;
  private static final int KEY_LENGTH = 512;
  private static final String SALT = "saltKey";

  /**
   * Converts a provided password into a hashed representation.
   *
   * @param providedPassword the password to be hashed
   * @return the hashed password as a hexadecimal string
   */
  public String stringToHash(String providedPassword) {
    return Hex.encodeHexString(hashPassword(providedPassword.toCharArray()));
  }

  /**
   * Hashes the provided password using PBKDF2 with HMAC-SHA512.
   *
   * @param password the password to be hashed as a character array
   * @return the hashed password as a byte array
   * @throws RuntimeException if the hashing process encounters an error
   */
  private byte[] hashPassword(final char[] password) {
    try {
      SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
      PBEKeySpec spec = new PBEKeySpec(password, SALT.getBytes(), ITERATIONS, KEY_LENGTH);
      SecretKey key = secretKeyFactory.generateSecret(spec);

      return key.getEncoded();
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}