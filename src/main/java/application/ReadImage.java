package application;

import java.io.File;

/**
 * The ReadImage class provides functionality to read and store an image file.
 * It allows setting a file path and retrieving the corresponding File object.
 */
public class ReadImage {
  private File imageInput;

  /**
   * Constructs a new ReadImage instance.
   */
  public ReadImage() {
    // Default constructor
  }

  /**
   * Reads the file from the specified file path and stores it as a File object.
   *
   * @param filePath the path of the file to be read
   */
  public void readFile(String filePath) {
    this.imageInput = new File(filePath);
  }

  /**
   * Returns the File object representing the image file.
   *
   * @return the File object of the image
   */
  public File provideFile() {
    return this.imageInput;
  }
}