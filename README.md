# True/False Quiz App 📱🧠

A simple Android quiz app built in Java using the Android SDK. The app presents the user with a series of True/False questions, tracks their score, and includes a **cheat feature** that users can use — at a cost!

## ✨ Features

-  Series of True/False questions with immediate feedback
-  **Orientation change support** — state (score, current question) is preserved
-  Navigation between questions using Next/Previous buttons
-  Click on question text to move to the next question
-  **CheatActivity**: Users can reveal the correct answer — but they'll be caught!
-  Tracks cheating per-question and displays a judgment toast if cheated
-  Final score displayed after the last question
-  Clean, responsive UI with support for portrait and landscape layouts

## 🛠 Technologies Used

- Java
- Android SDK
- Android Studio
- XML (for UI)
- Activity lifecycle handling
- Intent data passing
- Toast messages
- `onSaveInstanceState()` to retain state on rotation

## 📷 Screenshots
![IMAGE 2025-07-02 17:05:49](https://github.com/user-attachments/assets/4f731225-666d-4039-b5df-eb8e94ab2fb9)
![IMAGE 2025-07-02 17:06:20](https://github.com/user-attachments/assets/c1504942-85c0-4d82-bb2c-17ee56501570)
![IMAGE 2025-07-02 17:06:24](https://github.com/user-attachments/assets/8487972d-1131-4be5-8198-34317879780b)
![IMAGE 2025-07-02 17:06:28](https://github.com/user-attachments/assets/2eb58a82-26db-4337-a8bd-737f1b07ee40)




## 🧠 How It Works

1. User starts the quiz on the `MainActivity`.
2. Each question can be answered with **True** or **False** buttons.
3. User can click the **Cheat** button to reveal the answer.
4. If the user cheats, this is recorded in a `boolean[] mIsCheater`.
5. When the user answers a question:
   - If they cheated, a **judgment toast** appears.
   - If not, a **correct/incorrect** toast is shown.
6. At the end of the quiz, the app hides the buttons and displays the score.

## 🔧 Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/muhammadkhasanboev/advTrueFalseQuizApp.git
