# Automated Test Scripts for theScore Assessment

This project showcases automated testing utilizing Appium 2, Java 11, Maven dependencies, and an Android emulator. It encompasses scripts designed to choose a team by leveraging distinctive elements such as xpath and id, ensuring the seamless execution of scripts for seamless navigation between pages. The tests verify the correct display of pages and smooth execution of automated scripts.

## Prerequisites

Before running the tests, make sure you have the following prerequisites installed on your machine:

- Java 11
- Appium 2 (run appium in terminal using appium --use-plugins=images)
- Maven
- Android Studio with an Android Emulator
- Eclipse IDE (or any other preferred IDE)


## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/your-appium-project.git


## Bonus 
Write a short description of the rationale you used to decide your test approach and provide a coverage assessment of the feature your tests targeted.

Test Approach Rationale:
**Functional Testing**:

Functional testing is chosen for its effectiveness in evaluating the software's functionality against specified requirements. Here's the rationale behind this choice:

**Requirement Validation**: Functional testing ensures that the application meets the specified requirements. Each step in the test plan corresponds to a functional aspect, from opening a page to verifying data correctness.

**End-to-End Validation**: The selected tests cover end-to-end scenarios, starting from opening a page to navigating back. This approach mimics user interactions and ensures that the entire workflow functions as expected.

**Data-Driven Approach**: The use of a data-driven approach, as suggested in the bonus points, enhances test coverage by allowing the same test logic to be applied with different data sets. This approach validates the flexibility and robustness of the application.

**Coverage Assessment**:

Step 1 - Open a page:
Objective: Verify the application's ability to open league, team, or player pages.
Coverage: Ensures basic navigation functionality.

Step 2 - Verify the expected page:
Objective: Confirm that the correct page opens after the user's selection.
Coverage: Validates page navigation accuracy.

Step 3 - Tap on a sub-tab:
Objective: Interact with sub-tabs like league tables, standings, leaders, or stats.
Coverage: Tests specific functionalities within the chosen sub-tabs.

Step 4 - Verify correct tab and data:
Objective: Ensure that the displayed data corresponds to the chosen league, team, or player.
Coverage: Validates data accuracy and tab-switching functionality.

Step 5 - Verify back navigation:
Objective: Confirm that navigating back returns to the previous page correctly.
Coverage: Tests the integrity of the application's navigation stack.

This functional testing approach,smoke testing and requirement traceability matrix offers comprehensive coverage of the specified features, ensuring the robustness and reliability of the application.





## Discovered a Software Bug:

While testing, When i tapped on the search menu on the teams selection page. Encountered this error as can be seen in the image attached. Wasn't able to search for a specific team because of that.




<img width="1280" alt="Screenshot 2024-02-08 at 12 08 30 AM" src="https://github.com/SeharAhmed1/QAAutomationAssessment/assets/159305921/db5fbd4d-3d39-470d-b79d-ad6d67d26387">






