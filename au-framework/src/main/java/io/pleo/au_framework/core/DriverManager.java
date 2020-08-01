package io.pleo.au_framework.core;

import org.openqa.selenium.WebDriver;

/**
 * Responsible for acting as a single point of access to the instantiated WebDriver instance. This
 * class is implemented using the Singleton design pattern as one single WebDriver instance can
 * exist at any point in time within the code.
 */
public class DriverManager {

  private static DriverManager instance;
  private static WebDriver driver;

  /** The constructor is made private, so no one can create an instance of this class. */
  private DriverManager() {}

  /**
   * Returns an instance of this class if it already exists, otherwise it creates a new one.
   *
   * @return An instance of DriverManager.
   */
  public static DriverManager getInstance() {
    if (instance == null) {
      return new DriverManager();
    }
    return instance;
  }

  /**
   * Returns the WebDriver instance that is currently running or creates a new one if none exists.
   * Keep in mind that only one single WebDriver instance can exist at any point in time.
   *
   * @return A WebDriver instance that represents the platform we are currently executing on.
   */
  public WebDriver getDriver() {
    if (driver == null) {
      // create the driver instance by calling the chain of responsibility
      return createChainOfResponsibility();
    }
    // driver is already created, just return it
    return driver;
  }

  private static WebDriver createChainOfResponsibility() {
    // TODO:
    return null;
  }
}