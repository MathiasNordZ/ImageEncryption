package application.interaction;

/**
 * The StringMenu class provides a textual representation of the main menu for the application.
 * It includes options for encrypting and decrypting images.
 */
public class StringMenu {

  /**
   * Constructs a new StringMenu instance.
   */
  public StringMenu() {
    // Default constructor
  }

  /**
   * Returns the main menu as a formatted string.
   * This menu includes options for encrypting and decrypting images.
   *
   * @return a string representing the main menu
   */
  public String getMainMenu() {
    return """
        ######## Welcome to the Image Encrypter ########
        
        [1] - Encrypt Image
        [2] - Decrypt Image
        [0] - Exit
        
        ################################################
        
        Please enter command:
        """;
  }
}