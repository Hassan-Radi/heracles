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
package io.pleo.au_framework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.pleo.au_framework.data.Constants;
import io.pleo.au_framework.data.JsonConfig;
import io.pleo.au_framework.enums.ExecutionMode;
import io.pleo.au_framework.enums.Platform;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/** A utility class that provides common methods that can be used when working with JSON files. */
public class JsonUtils {

  private static final Logger LOGGER = LogManager.getLogger(JsonUtils.class);

  /**
   * Reads a JSON file from the specified filePathName and returns a JsonConfig object representing
   * the data in it.
   *
   * @param filePathName The file name (with the extension).
   * @return A JsonConfig object.
   */
  public static JsonConfig readJson(String filePathName) {
    JsonConfig jsonConfig;

    try (FileReader fileReader = new FileReader(filePathName)) {
      /**
       * Create the Gson object and register the type adaptors to be able to deserialize the json
       * file. This is needed as the POJO itself doesn't contain primitives and it is all custom
       * types.
       */
      Gson gson =
          new GsonBuilder()
              .registerTypeAdapter(
                  Platform.class,
                  (JsonDeserializer<Platform>)
                      (jsonElement, type, jsonDeserializationContext) ->
                          Platform.valueOf(jsonElement.getAsString().toUpperCase()))
              .registerTypeAdapter(
                  ExecutionMode.class,
                  (JsonDeserializer<ExecutionMode>)
                      (jsonElement, type, jsonDeserializationContext) ->
                          ExecutionMode.valueOf(jsonElement.getAsString().toUpperCase()))
              .registerTypeAdapter(
                  MutableCapabilities.class,
                  (JsonDeserializer<MutableCapabilities>)
                      (jsonElement, type, jsonDeserializationContext) ->
                          new MutableCapabilities(
                              new Gson().fromJson(jsonElement.getAsJsonObject(), Map.class)))
              .create();
      jsonConfig = gson.fromJson(fileReader, JsonConfig.class);
    } catch (IOException exception) {
      throw new RuntimeException(
          String.format(
              Constants.FAILED_TO_READ_JSON_FILE_MESSAGE, ExceptionUtils.getStackTrace(exception)));
    }

    return jsonConfig;
  }
}
