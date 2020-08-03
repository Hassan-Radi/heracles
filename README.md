# Heracles: Pleo's Test Engineer Challenge
<img src="https://upload.wikimedia.org/wikipedia/commons/4/48/Twelve_Labours_Altemps_Inv8642.jpg" height="300px"/>

[For the original readme file detailing the challenge, click [here](./docs/OLD-README.md)]

## Introduction
For this challenge and instead of building the solution as a website, I decided to step out of my comfort zone and build an Android mobile app instead. This is mainly because I never explored building apps before, yet I anticipated it would be a great learning experience (which turned out to be true 🙏).

The solution is split into 3 parts.
 - **Part 1:** Android app
 - **Part 2:** UI automation framework
 - **Part 3:** Appium tests

## Part 1: The App
An Android app that has one activity and is used to format money values in a readable format. Next to the app, there is some unit tests and UI tests (using Espresso as a White-Box testing method).

 - The app takes any valid number and formats it into the requested money format.
 - If the value provided is invalid (e.g. any ASCII characters, wrongly formatted numbers, invalid numbers, etc..) it shows an error message.
 - The app can format BigDecimal numbers; which gives a lot of freedom for the values you can provide.
 - The core code that is responsible for doing the money formatting is split from the UI and maintained in class `MoneyFormatterHelper`, This provides the possibility to unit test it later on.
 - The app runs on any Android devices/emulators starting from Android 4.x and above.
 - The app is written in Android Studio using Java (JDK 8+) and built with Gradle.

<img src="https://raw.githubusercontent.com/Hassan-Radi/heracles/master/docs/app.gif" width="360" height="640" />

#### How to run it?

 - **Running the app from Android Studio:** Android Studio produces debug builds by default when you run the app from within it, please do the following:
    - Make sure that Android SDK is installed on your machine and [USB debugging](https://developer.android.com/studio/debug/dev-options#enable) is turned on under `Developer options`.
    - Open the `Android-app` project using Android Studio.
    - From the `Configurations` drop-down, please choose `app`.
    - From the `Devices` drop-down, please choose the device/emulator that you want to run on.
    - Click on the `Run app` button. <img src="https://raw.githubusercontent.com/Hassan-Radi/heracles/master/docs/Build-Android-Studio.jpg" />
 - **Running the app from the APK file:** The app's APK file can be found under `/Android-app/app/release/app-release.apk`. This is a signed release build that can be installed on devices/emulators like any other Android app. You can install the app using one of these options:
   - Install using `adb install app-release.apk` (Would only work if you have Android SDK installed on your machine).
   - Install by copying the APK file to your local phone storage and then opening it from your phone (Would only work if you have [Unknown sources](https://www.applivery.com/docs/troubleshooting/android-unknown-sources/) turned on under `Lock screen & security` settings). 

### Unit testing
Testing on a lower level of the app to make sure certain functionalities are working as expected. Testing on a unit testing level is always favoured over UI testing as it is faster to build and execute and also less expensive in resources (time/money).

This part was done using Junit 5.x, instead of the default Junit 4.x, to provide better flexibility when building parameterized tests.

#### Test cases:

 - Unit test cases are maintained in class `MoneyFormatUnitTest`.
 - All the test cases are maintained in a CSV file with the format `<Input>,<Output>`.
 - For invalid test cases where an error message is expected, the `<Output>` value is left empty in the CSV file. The unit test case checks the output value before it starts executing and adapts the checks accordingly.

| Test case                             | Description & examples      |
| -----------                           | -----------       |
| Integers                              | You can use any integer value here with no decimal places.                 |
| Float/Double/BigDecimal values        | You can use any Float/Double/BigDecimal values here with as much precision as a [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) can handle.              |
| Text values                           | It can be any ASCII characters you want to test. The app will always reject any invalid numbers by throwing a RuntimeException.                 |
| Invalid numbers                       | like 62.986.84565 (valid number with two decimal points).               |
| Signed numbers                        | like -123.45, -8765.876, etc..              |
| Valid numbers with leading zeroes     | You can add any number of leading zeroes to a valid number and the app would remove the leading zeroes and format it correctly. |

#### How to run it?
 - Open the solution using Android Studio IDE and then navigate to class `MoneyFormatUnitTest`.
 - Click on the button next to the test `parameterizedTest` and choose `Run 'parameterizedTest()'`.

### UI testing
We still need to do UI testing to ensure that certain parts of the app are functioning as expected (e.g. showing error messages). For this, two testing methods are implemented;
 - **White-box:** Implemented in project `Android-app` with the app itself.
 - **Black-box:** Implemented in a separate project `Appium-tests` ([part 3](#appiumTests)).

#### Espresso tests
Espresso is used to write White-Box UI test cases for the Android app. Writing UI tests using White-Box techniques requires familiarity with the codebase and is usually written in the same code repository as the application itself.

 - Espresso test cases are maintained in class `EspressoInstrumentedTest`.
 - Two test cases are implemented:
    - **testMoneyFormatIsCorrect:** To test that a valid number is correctly formatted and displayed as expected.
    - **testAlertIsShown:** To test that an alert is shown when you type an invalid number.
 - Written using Junit 4.x (as Junit 5 is still not supported with Android instrumented tests).

#### How to run it?
 - Open the solution using Android Studio IDE and then navigate to class `EspressoInstrumentedTest`.
 - Connect a physical device or setup a local emulator on your machine. If you connect a physical device, make sure that [USB debugging](https://developer.android.com/studio/debug/dev-options#enable) is turned on under `Developer options`.
 - From the `Devices` drop-down, please select the device/emulator you want to run the tests on.
 - Click on the button next to class `EspressoInstrumentedTest` and choose `Run 'EspressoInstrumentedTest'`.

## Part 2: UI Automation Framework
A very basic, extendable automation framework built on top of Selenium/Appium that can be used for both web & mobile websites/apps. It provides an easy way to write UI test cases out of box without having to deal with the setup/boilerplate code needed to get there.

 - Written in IntelliJ IDE using Java (JDK 8+) and built with Maven.
 - Unit tests are written using TestNG (As it allows the flexibility to create xml test suites). TestNG dependency is declared for the `test` scope only (which makes it non-transitive), this doesn't lock you in and gives you the freedom to use any other xUnit testing tool in your project.
 - Using [Project Lombok](https://projectlombok.org/) in the code whenever needed which helps inject getters, setters, toString, etc... within the code without having to declare them explicitly. This helps reduce the amount of boilerplate code needed usually by Java.
 - The WebDriver creation logic is built using the [Chain of responsibility](https://refactoring.guru/design-patterns/chain-of-responsibility) design pattern; which makes it super easy to support new WebDrivers with minimal work and without breaking the existing ones.
 - WebDrivers are created by passing a system property `driverConfig`; which maps to a JSON file that contains all the WebDriver configurations (platform, execution mode, capabilities, etc...). You can think of the JSON file as a representation to a single device/browser with all of its capabilities and settings.
 - The automation framework is deployed as a Maven package on GitHub, along with the source and Javadocs. It can later on be used as a dependency to jumpstart any project. 

<img src="https://raw.githubusercontent.com/Hassan-Radi/heracles/master/docs/Maven-Package.jpg" />

### System properties
The following is a list of all the system properties declared by the automation framework:

| Name       | Description                                   | Necessity         | Case-sensitivity  |
| -----------           | -----------              | -----------              | -----------              | 
| driverConfig | - The name (+extension) of the JSON file that includes all the driver configurations needed to create a new WebDriver. <br/> - The file is expected to be under the project resources folder. | Mandatory | case-sensitive |

### Future improvements
The following are ideas that can be added/improved in the automation framework:

 - **[Feature]** Add support to run in the cloud using SauceLabs or BrowserStack.
 - **[Improvement]** Make the WebDriver URL a variable inside the JSON file; which will allow the flexibility to run on custom grids/servers.
 - **[Improvement]** No need to provide the `.json` file extension in the `driverConfig` system property; the framework should be smart enough to know that.
 - **[Improvement]** start the Appium server programmatically from the code, instead of relying on doing it manually.

## <a name="appiumTests"></a>Part 3: Appium tests
An example of using the automation framework (build in part 2) to write some UI test cases for the Android app (using Appium as a Black-Box testing method).

 - Written in IntelliJ IDE using Java (JDK 8+) and built with Maven.
 - UI tests are written using TestNG (As it allows the flexibility to create xml test suites).
 - You need to have the Appium installed on your machine. You can either do this by installing Appium from the command line, or an easier way would be to install the [Appium Desktop app](https://github.com/appium/appium-desktop). 

#### How to run it?
 - Make sure that you have `JAVA_HOME` & `ANDROID_HOME` added to your environment variables (Otherwise the Appium session would fail to be created).
 - Connect a physical device or setup a local emulator on your machine. If you connect a physical device, make sure that [USB debugging](https://developer.android.com/studio/debug/dev-options#enable) is turned on under `Developer options`.
 - Start the Appium server on your `localhost` with port number `4723`.
 - [TODO]

---

#### General Notes:

 - Everything is developed on Windows 10 x64 machine.
 - You might have notice that the initial commits were not signed (as it took me a while to realise that 😂, but once I did, I started signing all of them from that moment forward).
