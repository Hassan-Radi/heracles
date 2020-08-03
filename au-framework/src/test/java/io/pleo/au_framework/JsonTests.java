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
package io.pleo.au_framework;

import io.pleo.au_framework.data.Constants;
import io.pleo.au_framework.data.JsonConfig;
import io.pleo.au_framework.enums.ExecutionMode;
import io.pleo.au_framework.enums.Platform;
import io.pleo.au_framework.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/** A class that hosts all the unit test cases for working with JSON files. */
public class JsonTests {

  private static final Logger LOGGER = LogManager.getLogger(JsonTests.class);

  @Test
  public void readJsonFileFromResources() {
    JsonConfig jsonConfig =
        JsonUtils.readJson(
            JsonTests.class
                .getClassLoader()
                .getResource(Constants.LOCAL_SONY_PHONE_FILE_NAME)
                .getPath());
    LOGGER.info(String.format("Got a value of: %s", jsonConfig));
    Assert.assertEquals(
        jsonConfig.getExecutionMode(), ExecutionMode.LOCAL, Constants.VALUES_DONT_MATCH_MESSAGE);
    Assert.assertEquals(
        jsonConfig.getPlatform(), Platform.ANDROID, Constants.VALUES_DONT_MATCH_MESSAGE);
  }
}
