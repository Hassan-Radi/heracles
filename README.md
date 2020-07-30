# Heracles: Pleo's Test Engineer Challenge
<img src="https://upload.wikimedia.org/wikipedia/commons/4/48/Twelve_Labours_Altemps_Inv8642.jpg" height="300px"/>

[For the original readme file detailing the challenge, click [here](./OLD-README.md)]

## 1. The App
For this challenge and instead of building the solution as a website, I decided to step out of my comfort zone and build an Android mobile app instead. This is mainly because I never tried building apps, yet I anticipated it would be a great learning experience for me (it turned out to be one 😉) .

 - The app takes any valid number and formats it into the requested money format.
 - If the value provided is invalid (e.g. any ASCII characters, wrongly formatted numbers, invalid numbers, etc..) it shows an error message.
 - The app can format BigDecimal numbers; which gives a lot of freedom to play with it, but also complicates testing as a lot of edge cases need to be covered.
 - The app runs on any Android device/emulator from Android 4.x and above.

<img src="https://raw.githubusercontent.com/Hassan-Radi/heracles/master/app.gif" width="360" height="640" />

## 2. Unit testing
Testing on a lower level of the app to make sure certain functionalities are working as expected. Testing on a unit testing level is always favoured over UI testing as it is faster to build and execute and also less expensive in resources (time/money).

This part was done using Junit 5.x, instead of the default Junit 4.x for Android projects to provide better flexibility when building parameterized tests.

### Test cases:
| Test case                             | Description & examples      |
| -----------                           | -----------       |
| Integers                              | You can use any integer value here with no decimal places                  |
| Float/Double/BigDecimal values        | You can use any Float/Double/BigDecimal values here with as much precision as a [BigDecimal](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html) can handle.              |
| Text values                           | It can be any ASCII characters you want to test. You can go crazy, the app will always reject any invalid numbers.                 |
| Invalid numbers                       | like -0 or 62.986.84565 (valid number with two decimal points)                 |
| Signed numbers                        | like -123.45, -8765.876, etc..              |
| Valid numbers with leading zeroes     | You can add any number of leading zeroes to a valid number and the app would remove the leading zeroes and format it correctly. |

#### How to run it?

## 3. UI testing
UI testing is still needed to ensure that certain parts of the app are functioning as expected (e.g. showing error messages). For this, I created two testing techniques, one is black-box and the other is white-box. 

### 3.1 Espresso tests
White-box testing of the app.

#### How to run it?

### 3.2 Appium tests
Black-box testing of the app.

#### How to run it?