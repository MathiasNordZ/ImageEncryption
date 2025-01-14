package application.interaction;

public class StringMenu {
  public StringMenu() {

  }

  public String getMainMenu() {
    return """
        ######## Welcome to the Image Encrypter ########
        
        [1] - Encrypt Image
        [2] - Decrypt Image
        [0] - Exit
        
        ################################################
        
        Please enter command:
        """
        ;
  }

}
