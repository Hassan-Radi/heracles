/*
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
package io.pleo.au_framework.core.creators;

import io.pleo.au_framework.data.JsonConfig;
import org.openqa.selenium.WebDriver;

/**
 * An interface that defines the behaviour of classes that can create WebDrivers. It serves as glue
 * to all the concrete WebDriver creators that ties them together in a chain of responsibility.
 */
public interface DriverCreator {

  /**
   * Each creator checks whether it can process the WebDriver creation request when you call this
   * method; If it can create the WebDriver, it consumes the request, otherwise it passes it to the
   * next creator in the chain of responsibility.
   *
   * @param jsonConfig The JSON file that contains all the necessary information to create the
   *     WebDriver.
   * @return A WebDriver instance.
   */
  public WebDriver createDriver(JsonConfig jsonConfig);

  /**
   * Links the current WebDriver creator to another one that comes after it. This linkage is
   * necessary to create the chain of responsibility of all the supported creators by the automation
   * framework.
   *
   * @param driverCreator A reference to another WebDriver creator.
   */
  public void setNext(DriverCreator driverCreator);
}
