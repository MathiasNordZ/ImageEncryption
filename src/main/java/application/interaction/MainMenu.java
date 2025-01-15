package application.interaction;

import application.utils.InputHandler;
import application.utils.PrintHandler;

/**
 * The MainMenu class manages the main user interface for the application.
 * It provides options for encrypting and decrypting files and handles user input.
 */
public class MainMenu {
  private final StringMenu stringMenu;
  private final PrintHandler printHandler;
  private final InputHandler inputHandler;
  private final CommandHandler commandHandler;

  /**
   * Initializes the MainMenu with necessary utility classes.
   */
  public MainMenu() {
    this.stringMenu = new StringMenu();
    this.printHandler = new PrintHandler();
    this.inputHandler = new InputHandler();
    this.commandHandler = new CommandHandler();
  }

  /**
   * Enum representing the main commands available in the menu.
   */
  private enum MainCommands {
    ENCRYPT(1),
    DECRYPT(2),
    EXIT(0);

    private final int value;

    MainCommands(int value) {
      this.value = value;
    }

    /**
     * Converts an integer value to a corresponding MainCommands enum.
     *
     * @param value the integer value representing a command
     * @return the corresponding MainCommands enum
     * @throws IllegalArgumentException if the value does not match any command
     */
    private static MainCommands fromValue(int value) {
      for (MainCommands command : MainCommands.values()) {
        if (command.value == value) {
          return command;
        }
      }
      throw new IllegalArgumentException("The command value is invalid: " + value);
    }
  }

  /**
   * Displays the main menu and processes user commands.
   * Continues to prompt the user until the exit command is selected.
   */
  public void mainMenu() {
    MainCommands command = null;

    do {
      printHandler.printString(stringMenu.getMainMenu());
      int commandValue;

      try {
        inputHandler.readInt();
        commandValue = inputHandler.getInt();
        command = MainCommands.fromValue(commandValue);
        commandHandler(command);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }

    } while (command != MainCommands.EXIT);
  }

  /**
   * Executes the appropriate action based on the user's command.
   *
   * @param command the command selected by the user
   */
  private void commandHandler(MainCommands command) {
    switch (command) {
      case ENCRYPT -> commandHandler.encrypt();
      case DECRYPT -> commandHandler.decrypt();
      case EXIT -> System.out.println("Exiting program...");
      default -> System.out.println("Wrong command.");
    }
  }
}