import java.io.File;

public class ReadImage {
  private File imageInput;

  ReadImage() {
  }

  public void readFile(String filePath) {
    this.imageInput = new File(filePath);
  }

  public File provideFile() {
    return this.imageInput;
  }

}