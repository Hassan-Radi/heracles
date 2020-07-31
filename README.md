# Heracles: Pleo's Test Engineer Challenge
<img src="https://upload.wikimedia.org/wikipedia/commons/4/48/Twelve_Labours_Altemps_Inv8642.jpg" height="300px"/>

[For the original readme file detailing the challenge, click [here](./OLD-README.md)]

## 1. The App
For this challenge and instead of building the solution as a website, I decided to step out of my comfort zone and build an Android mobile app instead. This is mainly because I never explored building apps before, yet I anticipated it would be a great learning experience (which turned out to be true 🙏) .

 - The app takes any valid number and formats it into the requested money format.
 - If the value provided is invalid (e.g. any ASCII characters, wrongly formatted numbers, invalid numbers, etc..) it shows an error message.
 - The app can format BigDecimal numbers; which gives a lot of freedom for the values you can provide.
 - The core code that is responsible for doing the money formatting is split from the UI and maintained in class `MoneyFormatterHelper`. This allows us to easily unit test it later on.
 - The app runs on any Android devices/emulators from Android 4.x and above.
 - The app is written in Android Studio using Java (JDK 1.8+) and built with Gradle.

<img src="https://raw.githubusercontent.com/Hassan-Radi/heracles/master/app.gif" width="360" height="640" />

#### How to run it?

 - Running the app from Android Studio: [TODO]
 - Running the app from the APK file: [TODO]

## 2. Unit testing
Testing on a lower level of the app to make sure certain functionalities are working as expected. Testing on a unit testing level is always favoured over UI testing as it is faster to build and execute and also less expensive in resources (time/money).

This part was done using Junit 5.x, instead of the default Junit 4.x, to provide better flexibility when building parameterized tests.

### Test cases:

 - Unit test cases are maintained in class `MoneyFormatUnitTest`.
 - All the test cases are maintained in a CSV file with the format `<Input>,<Output>`. 
 - For invalid test cases where an error message is expected, the `<Output>` value is left empty in the CSV file. The unit test case checks the output value before it starts executing and adapts the checks accordingly.

| Test case                             | Description & examples      |
| -----------                           | -----------       |
| Integers                              | You can use any integer value here with no decimal places.                 |
| Float/Double/BigDecimal values        | You can use any Float/Double/BigDecimal values here with as much precision as a [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) can handle.              |
| Text values                           | It can be any ASCII characters you want to test. The app will always reject any invalid numbers by throwing a RuntimeException.                 |
| Invalid numbers                       | like -0 or 62.986.84565 (valid number with two decimal points).               |
| Signed numbers                        | like -123.45, -8765.876, etc..              |
| Valid numbers with leading zeroes     | You can add any number of leading zeroes to a valid number and the app would remove the leading zeroes and format it correctly. |

#### How to run it?
 - Open the solution using Android Studio IDE and then [TODO]

## 3. UI testing
We still need to do UI testing to ensure that certain parts of the app are functioning as expected (e.g. showing error messages). For this, two testing techniques are implemented; one is black-box and the other is white-box. 

### 3.1 Espresso tests
White-box testing of the app using Espresso and Junit 4.x (as Junit 5 is still not supported with Android instrumented tests). Writing UI tests using White-box techniques requires familiarity with the codebase and are usually written in the same code repository as the application itself.

 - Espresso test cases are maintained in class `EspressoInstrumentedTest`.
 - [TODO]
 
#### How to run it?
 - Connect a physical device or setup a local emulator on your machine.
[TODO]

### 3.2 Appium tests
Black-box testing of the app. [TODO]

#### How to run it?
 - Connect a physical device or setup a local emulator on your machine.
[TODO]

---

#### General Notes:

 - Everything is developed on Windows 10 x64 machine.