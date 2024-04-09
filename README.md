## Android coding challenge

** Task 1 (Introduce a new feature that allows the user to view their past transactions)
Step 1) create a new activity to display the screen for the transactions list.
Step 2)

** Task 2 (Improve the current code which was intentionally made with poor programming practices and
a few bugs)
- Refactored the code and switched it from if/else statement to "when" statement for the onClick
  listener {
  Using a when statement in Kotlin can be advantageous over using an if/else statement in certain
  scenarios
  because it provides a more concise and expressive way to handle multiple conditions. I believe it
  preferable when dealing with something like waiting for a click
  }
- Had to add in if (balance >= amt) to the withdrawButton as before it would we could withdraw any
  that was equal to the amount in the balance

- I made a few chances to the activity_main.xml files so that the strings weren't hardcoded into
  the Buttons rather from the strings.xml file

- I moved the on-click listener options logic to their own functions. my reasoning for doing this is
  isolate their logic for testability purposes

** Task 3 (Improvements are to be made without rewriting the app)