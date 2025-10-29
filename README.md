
Name: David Kennedy 
Student Number: W20119128

Description of Project:
===================================================

This project is a console-based Car Purchasing Assistant, written in Java. It employs a menu-style interface to calculate various car financing options such as Hire Purchase and Personal Contract Plans. It also allows the user to estimate monthly costs, fuel expenses, and offers car type-recommendations based on lifestyle. The project implements logic that deals with input validation, formatted output, and the use of emojis for a more colourful and user-friendly experience.


Instructions:
=============

How to run the program
* Open the project PROGASSIGNMENT-1 in an editor of choice.
* The project contains 2 files, CarPurchaserHelper.java and Driver.java.
* A run button runs the code.
* It reveals a welcome message and a menu with choices from 0-5.
* The choices request a user to calculate financial products and related costs: Hire Purchase, PCP, Monthly Costs, Projected Fuel Costs, and Car Type Recommendation.
* When a number is selected, the logic assigned to that individual number requests a user to enter financial details.
* There is also a choice to exit the program with a goodbye message.



Known bugs/problems:
====================

* Oversight on entering a non-numerical entry to the menu portion. Required to write an if statement after the menu, if(!input.hasNextInt()) to see if a number was entered.
* Entered input.close() within the last else block of the Invalid Choice output statement. The error was an IllegalStateException so this needed to be moved outside the loop, so it wouldn't close the original input (System.In) prematurely.
* input.nextLine() required to clear the buffer post-choice entered after choice = input.NextInt().



Extra Inclusions:
====================

* Formatting monetary outputs to two decimal places using String.format
* Installed Prettier for indentation purposes on VSC.


Considerations:
====================

* Re-writing logic to prevent a deposit amount that could exceed the cost amount.


Resources & References:
====================

https://www.geeksforgeeks.org/java/how-to-print-colored-text-in-java-console/

https://emojipedia.org/

https://medium.com/@fulton_shaun/brighten-up-your-terminal-with-ansi-codes-cb5f5d2ff085


