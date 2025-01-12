package interaction;

import utils.InputHandler;
import utils.PrintHandler;

public class MainMenu {
  private StringMenu stringMenu;
  private PrintHandler printHandler;
  private InputHandler inputHandler;

  public MainMenu() {
    this.stringMenu = new StringMenu();
    this.printHandler = new PrintHandler();
    this.inputHandler = new InputHandler();
  }

  private enum MainCommands {
    ENCRYPT(1),
    DECRYPT(2),
    EXIT(0);
    private final int value;

    MainCommands(int value) {
      this.value = value;
    }

    private static MainCommands fromValue(int value) {
      for (MainCommands command : MainCommands.values()) {
        if (command.value == value) {
          return command;
        }
      }
      throw new IllegalArgumentException("The command value is invalid" + value);
    }
  }


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

  private void commandHandler(MainCommands command) {
    switch (command) {
      case ENCRYPT ->
    }
  }
}
