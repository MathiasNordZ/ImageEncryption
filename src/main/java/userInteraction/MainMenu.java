package userInteraction;

import utils.PrintHandler;

public class MainMenu {
  private StringMenu stringMenu;
  private PrintHandler printHandler;

  public MainMenu() {
    this.stringMenu = new StringMenu();
    this.printHandler = new PrintHandler();
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
        commandValue = inputHandler.intReader("Enter command: ");
        command = MainCommands.fromValue(commandValue);
        commandHandler(command);
      }

    } while (command != MainCommands.EXIT);
  }

  private void commandHandler(MainCommands command) {
    switch (command) {
      case ENCRYPT ->
    }
  }
}
