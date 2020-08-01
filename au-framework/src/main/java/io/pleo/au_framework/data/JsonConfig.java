package io.pleo.au_framework.data;

import io.pleo.au_framework.enums.ExecutionMode;
import io.pleo.au_framework.enums.Platform;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.MutableCapabilities;

/**
 * A POJO (Plain Old Java Object) that contains all the information needed to instantiate a
 * WebDriver.
 *
 * <p>Notice that we are using Lombok here to prevent having to implement a lot of boilerplate code
 * (like getters and setters) --> they would be generated automatically.
 */
@Getter
@Setter
public class JsonConfig {

  private Platform platform;
  private ExecutionMode executionMode;
  /** This can be either DesiredCapabilities or ChromeOptions/FirefoxOptions */
  private MutableCapabilities capabilities;

  public JsonConfig(
      Platform platform, ExecutionMode executionMode, MutableCapabilities capabilities) {
    this.platform = platform;
    this.executionMode = executionMode;
    this.capabilities = capabilities;
  }
}
