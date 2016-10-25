# String Calculator TDD Workshop


## Step 1 
Create a simple String calculator with a method int Add(string numbers).

1. The method can take 0, 1 or 2 numbers, separated by commas, and will return their sum, examples: 
  * **“”** should return **0**
  * **“1”** should return **1**
  * **“1,2”** should return **3**
2. Start with the simplest test case of an empty string and move to one and two numbers.
3. Remember to solve things as simply as possible so that you force yourself to write tests you did not think about.
4. Remember to refactor after each passing test.


## Step 2
Allow the Add method to handle an unknown amount of numbers.


## Step 3
Allow the Add method to handle new lines between numbers (instead of commas).

1. the following input is ok:  **“1\n2,3”**  and should return **6**
2. the following input is NOT ok:  **“1,\ n”** (not need to prove it - just clarifying)


## Step 4
Support different delimiters

1. to change a delimiter, the beginning of the string will contain a separate line that looks like this:   **“//[delimiter]\n[numbers…]”** for example **“//;\n1;2”** should return **3** where the default delimiter is **‘;’** .
2. the first line is optional. All existing scenarios should still be supported


## Step 5
Calling Add with a negative number will throw an exception **“negatives not allowed”** - and the negative that was passed.

If there are multiple negatives, show all of them in the exception message


## Step 6
Numbers bigger than 1000 should be ignored, for example **“1000,2”** should return **2**


## Step 7
Delimiters can be of any length with the following format: 
  
* **“//[delimiter]\n”**
  
for example: 

* **“//[\*\*\*]\n1\*\*\*2\*\*\*3”**
  
should return **6**


## Step 8
Allow multiple delimiters like this:  

* **“//[delim1][delim2]\n”**

for example 

* **“//[\*][%]\n1\*2%3”**

should return **6**


## Step 9
Make sure you can also handle multiple delimiters with length longer than one char
