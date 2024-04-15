## Android coding challenge

** Task 1 (Introduce a new feature that allows the user to view their past transactions)
Step 1) create a new activity to display the screen for the transactions list. This includes adding
a few things such as creating an new .xml that will display the recyclerView, I also added another 
.xml file that will create the layout for each slot. After which I need to build a 
TransactionListActivity class to navigate to the next page. I also needed a TransactionAdapterClass
for the recyclerView and a TransactionDataClass to display the deposits/withdraw list.

Finally once it was all made, it was time to run some tests that we are tracking each transaction 
and returning all the correct information for the recyclerView

So i build some unit tests to make sure i get if its been deposited or withdraw and other test to
make sure it's displaying the right amount for each transaction.


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

- For focus on testability I moved a lot of the business logic into the MainViewModel as it is a lot
  more concise and keep to the relevant object.

- I built a bit of unit testing for the MainViewModel Specifically for updating and returning the 
  correcting information for the MainViewActivity. Which passed all tests and edge cases I could 
  think of.
