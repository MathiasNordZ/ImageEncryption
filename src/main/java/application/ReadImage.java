package application;

import java.io.File;

public class ReadImage {
  private File imageInput;

  public ReadImage() {
  }

  public void readFile(String filePath) {
    this.imageInput = new File(filePath);
  }

  public File provideFile() {
    return this.imageInput;
  }

}