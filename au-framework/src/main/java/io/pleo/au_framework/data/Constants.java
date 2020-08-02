package io.pleo.au_framework.data;

/** A class to host all the public constants that are shared within the automation framework. */
public class Constants {
  // files
  public static final String LOCAL_SONY_PHONE_FILE_NAME = "local-sony-xperia-z5-premium.json";

  // messages
  public static final String NO_WEBDRIVER_IS_CREATED_YET =
      "No WebDriver instance is created yet. Starting to create a new one...";
  public static final String WEBDRIVER_INSTANCE_EXISTS =
      "An instance of WebDriver already exists, using it...";
  public static final String FAILED_TO_READ_JSON_FILE =
      "Failed to read the Json file. Exception: %s";
  public static final String VALUES_DONT_MATCH = "Values don't match.";
}
