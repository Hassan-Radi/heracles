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

 - Running the app from Android Studio: [TODO]
 - Running the app from the APK file: [TODO]

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
 - Open the solution using Android Studio IDE and then [TODO]

### UI testing
We still need to do UI testing to ensure that certain parts of the app are functioning as expected (e.g. showing error messages). For this, two testing methods are implemented;
 - White-box: Implemented in this repo [TODO]
 - Black-box: [TODO]

#### Espresso tests
White-box testing of the app using Espresso and Junit 4.x (as Junit 5 is still not supported with Android instrumented tests). Writing UI tests using White-box techniques requires familiarity with the codebase and are usually written in the same code repository as the application itself.

 - Espresso test cases are maintained in class `EspressoInstrumentedTest`.
 - [TODO]

#### How to run it?
 - Connect a physical device or setup a local emulator on your machine.
 - [TODO]

## Part 2: UI Automation Framework
A very basic, extendable automation framework built on top of Selenium/Appium that can be used for both web & mobile websites/apps. It provides an easy way to write UI test cases out of box without having to deal with the setup/boilerplate code needed to get there.

 - Written in IntelliJ IDE using Java (JDK 8+) and built with Maven.
 - Unit tests are written using TestNG (As it allows the flexibility to create xml test suites).
 - Using [Project Lombok](https://projectlombok.org/) in the code whenever needed which helps inject getters, setters, toString, etc... within the code without having to declare them explicitly. This helps reduce the amount of boilerplate code needed usually by Java.
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

## Part 3: Appium tests
An example of using the automation framework (build in part 2) to write some UI test cases for the Android app (using Appium as a Black-Box testing method).

 - You need to have the Appium server running on your machine. You can either do this by installing Appium from the command line, or an easier way would be to install the [Appium Desktop app](https://github.com/appium/appium-desktop). 

#### How to run it?
 - Connect a physical device or setup a local emulator on your machine.
 - Start the Appium server on your `localhost` with port number `4723`.
 - [TODO]

---

#### General Notes:

 - Everything is developed on Windows 10 x64 machine.
 - You might have notice that the initial commits were not signed (as it took me a while to realise that 😂, but once I did, I started signing all of them from that moment forward).
