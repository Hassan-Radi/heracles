/**
 * Copyright (c) 2020 Hassan Radi
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in
 * writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * <p>See the License for the specific language governing permissions and limitations under the
 * License.
 */
package io.pleo.au_framework.data;

import io.pleo.au_framework.enums.ExecutionMode;
import io.pleo.au_framework.enums.Platform;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.MutableCapabilities;

/**
 * A POJO (Plain Old Java Object) that contains all the information needed to instantiate a
 * WebDriver.
 *
 * <p>Notice that we are using Lombok here to prevent having to implement a lot of boilerplate code
 * (like getters and setters) as they would be generated automatically.
 */
@Getter
@Setter
@ToString
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
