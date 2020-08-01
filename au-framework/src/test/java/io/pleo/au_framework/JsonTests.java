package io.pleo.au_framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/** A class that hosts all the unit test cases for working with JSON files. */
public class JsonTests {

  private static final Logger LOGGER = LogManager.getLogger(JsonTests.class);

  @Test
  public void readJsonFileFromResources() {
    LOGGER.info("Test Started.");
  }
}
