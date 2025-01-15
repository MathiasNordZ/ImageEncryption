package application;

import application.interaction.MainMenu;

/**
 * The Main class serves as the entry point for the application.
 * It initializes the main menu and starts the user interaction process.
 */
public class Main {

  /**
   * The main method is the entry point of the application.
   * It creates an instance of MainMenu and invokes the main menu interface.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    final MainMenu mainMenu = new MainMenu();

    mainMenu.mainMenu();
  }
}