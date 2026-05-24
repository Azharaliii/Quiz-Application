# 📝 Simple Minds — Interactive Quiz Application

![Java](https://img.shields.io/badge/Java-JDK%208+-ED8B00?logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-GUI-007396?logo=java&logoColor=white)
![AWT](https://img.shields.io/badge/AWT-Graphics-orange)
![Platform](https://img.shields.io/badge/Platform-Desktop-lightgrey)
![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-000000?logo=intellijidea&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green)

**Simple Minds** is a desktop-based Quiz Application built with Java Swing and AWT. It offers a smooth, multi-screen interface for conducting timed quizzes with multiple-choice questions, a 50:50 lifeline, auto-scoring, and a play-again loop.

---

## 📌 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [App Flow](#-app-flow)
- [Tech Stack](#️-tech-stack)
- [Quiz Details](#-quiz-details)
- [Project Structure](#-project-structure)
- [How to Run](#-how-to-run)
- [Class Breakdown](#-class-breakdown)
- [Screenshots](#-screenshots)
- [Author](#-author)
- [License](#-license)

---

## 🌍 Overview

**Simple Minds** is a 4-screen Java desktop application that walks the user through a complete quiz experience: from entering their name at the login screen, reading the rules, answering 10 timed multiple-choice questions, and finally viewing their personalized score with an option to play again.

The app is built entirely using **Java Swing** and **AWT** — no external libraries or database required.

---

## ✨ Features

- 🔐 **Named Login** — User enters their name before starting; blank names are rejected with a validation message
- 📋 **Rules Screen** — Dedicated screen displays quiz rules and guidelines before the quiz begins
- ❓ **10 Multiple Choice Questions** — General knowledge questions across science, geography, animals, and more
- ⏱️ **Per-Question Timer** — Each question has a **15-second countdown**; unanswered questions auto-advance when time runs out
- 🔘 **Radio Button Options** — 4 options per question using a `ButtonGroup` to allow only one selection
- 🃏 **50:50 Lifeline** — Eliminates two wrong options per question (one use per quiz)
- ➡️ **Next & Submit Buttons** — Navigate through questions; Submit activates only on the last question
- 🏆 **Automatic Scoring** — 10 points per correct answer, maximum score of 100
- 📊 **Personalized Score Screen** — Displays the player's name and final score
- 🔁 **Play Again** — Instantly restarts the quiz from the login screen
- 🖼️ **Custom Visual Assets** — Branded images on login, quiz, and score screens (`login.jpeg`, `quiz.jpg`, `score.png`, `QuizLogo.jpg`)

---

## 🔄 App Flow

```
Launch App
    │
    └── Login Screen (Login.java)
            Enter Name → Click "Rules"
            │
            └── Rules Screen (Rules.java)
                    Read guidelines → Click "Start Quiz"
                    │
                    └── Quiz Screen (Quiz.java)
                            10 Questions × 15 seconds each
                            [Next] → advance questions
                            [50:50 Lifeline] → eliminate 2 wrong options
                            [Submit] → on question 10
                            │
                            └── Score Screen (Score.java)
                                    "Thank You <Name> for Playing Simple Minds"
                                    "Your Score is: <score>/100"
                                    [Play Again] → back to Login
```

---

## 🛠️ Tech Stack

| Component | Technology |
|---|---|
| Language | Java (JDK 8+) |
| GUI Framework | Java Swing (`javax.swing`) |
| Graphics | AWT (`java.awt`, `java.awt.event`) |
| Layout | Null layout (absolute positioning) |
| Image Handling | `ImageIcon`, `Image.getScaledInstance()` |
| IDE | IntelliJ IDEA (`.iml` included) |
| Package | `QuizApplication.icons` |

---

## 🧠 Quiz Details

The quiz contains **10 general knowledge questions**, each with 4 options and one correct answer:

| # | Question | Correct Answer |
|---|----------|---------------|
| 1 | Which animal is known as the 'Ship of the Desert'? | Camel |
| 2 | How many colors are in a rainbow? | Seven |
| 3 | Which is the largest ocean in the world? | Pacific Ocean |
| 4 | What is the capital city of France? | Paris |
| 5 | Which planet is known as the 'Red Planet'? | Mars |
| 6 | What do bees make? | Honey |
| 7 | Which is the fastest land animal? | Cheetah |
| 8 | What do you call a baby dog? | Puppy |
| 9 | Which body part do you use to hear? | Ears |
| 10 | How many legs does a spider have? | Eight |

**Scoring:** 10 points per correct answer — maximum score **100/100**

---

## 📂 Project Structure

```
Quiz-Application/
│
├── Login.java          # Screen 1: Name entry + login
├── Rules.java          # Screen 2: Quiz rules & guidelines
├── Quiz.java           # Screen 3: 10 questions with timer, lifeline, scoring logic
├── Score.java          # Screen 4: Final score display + play again
│
├── Login.class         # Compiled bytecode
├── Quiz.class          # Compiled bytecode
├── Rules.class         # Compiled bytecode
├── Score.class         # Compiled bytecode
│
├── login.jpeg          # Background image for Login screen
├── quiz.jpg            # Header banner image for Quiz screen
├── score.png           # Trophy/result image for Score screen
├── QuizLogo.jpg        # Application logo / branding
│
├── QuizApp.iml         # IntelliJ IDEA module config
├── .gitignore          # Git ignored files
└── README.md           # Project documentation
```

---

## ▶️ How to Run

### Prerequisites

- [Java JDK 8+](https://www.oracle.com/java/technologies/downloads/) installed
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (recommended) or any Java IDE

### Step 1 — Clone the Repository

```bash
git clone https://github.com/Azharaliii/Quiz-Application.git
cd Quiz-Application
```

### Step 2 — Open in IntelliJ IDEA

1. Open IntelliJ IDEA → `File → Open` → select the cloned folder
2. The `.iml` file will auto-configure the module
3. Make sure the image assets (`login.jpeg`, `quiz.jpg`, `score.png`, `QuizLogo.jpg`) are inside the `QuizApplication/icons/` resource folder

### Step 3 — Run

Right-click `Login.java` → `Run 'Login.main()'`

Or compile and run from the command line:

```bash
# Compile all files
javac -d . Login.java Rules.java Quiz.java Score.java

# Run
java QuizApplication.icons.Login
```

> ⚠️ **Important:** Image assets must be accessible via the classpath at `QuizApplication/icons/`. Place them in your `src/QuizApplication/icons/` folder if running from an IDE.

---

## 🗂️ Class Breakdown

### `Login.java` — 82 lines
The entry point of the application. Displays a branded login screen with:
- A left-side background image (`login.jpeg`)
- A **"Simple Minds"** heading in `Bradley Hand ITC` font
- A name text field with validation (empty name → dialog warning)
- **Rules** button → passes the name to `Rules.java`
- **Back** button → closes the window

### `Rules.java`
Displays the quiz rules and guidelines before the quiz begins. Contains a **Start Quiz** button that opens `Quiz.java` with the player's name.

### `Quiz.java` — 254 lines
The core game engine. Handles:
- Rendering 10 questions sequentially with 4 `JRadioButton` options
- A **15-second countdown timer** drawn via `Graphics.drawString()` in the `paint()` method using `Thread.sleep(1000)` and `repaint()`
- **Auto-advance** when timer hits 0 — records blank answer and moves on
- **50:50 Lifeline** — disables two wrong option buttons (single-use)
- **Next** button (questions 1–9) and **Submit** button (question 10 only)
- Score calculation: iterates all 10 answers and adds 10 per correct match
- Passes `name` and `score` to `Score.java`

### `Score.java` — 59 lines
The results screen. Displays:
- A centered score image (`score.png`)
- Personalized message: `"Thank You <name> for Playing Simple Minds"`
- Final score label: `"Your Score is: <score>"`
- **Play Again** button — hides the score screen and opens a fresh `Login`

---

## 🔮 Future Improvements

- 🗃️ Load questions dynamically from a file or database
- 🔀 Randomize question and option order each session
- 🌗 Dark mode toggle
- 📈 Leaderboard to track high scores across sessions
- 🔊 Sound effects for correct/wrong answers and timer
- ⏸️ Pause quiz functionality

---

## 👤 Author

**Azhar Ali Soomro**
[![GitHub](https://img.shields.io/badge/GitHub-Azharaliii-181717?logo=github&logoColor=white)](https://github.com/Azharaliii)
[![Kaggle](https://img.shields.io/badge/Kaggle-azharalisoomro-20BEFF?logo=kaggle&logoColor=white)](https://www.kaggle.com/azharalisoomro)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

⭐ **If you found this project helpful, please consider giving it a star!**
