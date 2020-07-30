# Heracles: Pleo's Test Engineer Challenge
<img src="https://upload.wikimedia.org/wikipedia/commons/4/48/Twelve_Labours_Altemps_Inv8642.jpg" height="300px"/>

[For the original readme file detailing the challenge, click [here](./OLD-README.md)]

## 1. The App
For this challenge and instead of building the solution as a website, I decided to step out of my comfort zone and build an Android mobile app instead. This is mainly because I never tried building apps, yet I anticipated it would be a great learning experience for me (it turned out to be one 😉) .

 - The app takes any valid number and formats it into the requested money format.
 - If the value provided is invalid (e.g. any ASCII characters) it shows an error message.
 - The app can format double values, which gives 
 - The app runs on any Android device/emulator from Android 4.x and above.

<img src="https://raw.githubusercontent.com/Hassan-Radi/heracles/master/app.gif" width="360" height="640" />

## 2. Unit testing
Testing on a lower level of the app to make sure certain functionalities are working as expected. Testing on a unit testing level is always favoured over UI testing as it is faster to build and execute and also less expensive in resources (time/money).

This part was done using Junit 5.x, instead of the default Junit 4.x for Android projects to provide better flexibility when building parameterized tests.

### Test cases:
| Test case             | Description       |
| -----------           | -----------       |
| Integers              |                   |
| Float values          |                   |
| Double values         | Instead of being limited to de                  |

#### How to run it?

## 3. UI testing
UI testing is still needed to ensure that certain parts of the app are functioning as expected (e.g. showing error messages). For this, I created two testing techniques, one is black-box and the other is white-box to showcase 

### 3.1 Espresso tests
White-box testing of the app.

#### How to run it?

### 3.2 Appium tests
Black-box testing of the app.

#### How to run it?