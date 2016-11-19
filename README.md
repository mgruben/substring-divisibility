# substring-divisibility 
Finds the sum of all 0-9 pandigital numbers which are especially divisible

A number is 0-n pandigital if that number contains the digits 0 through n exactly once, in any order.  
* Ex. `3217896504` is 0-9 pandigital, since it contains `0, 1, 2, 3, 4, 5, 6, 7, 8, and 9`.

For a 10-digit number, let d<sub>1</sub> be the 1<sup>st</sup> digit, d<sub>2</sub> be the 2<sup>nd</sup> digit, etc.  
A 10-digit number is **especially divisible** if **all** of the following are true:  
* d<sub>2</sub>d<sub>3</sub>d<sub>4</sub> is divisible by 2
* d<sub>3</sub>d<sub>4</sub>d<sub>5</sub> is divisible by 3
* d<sub>4</sub>d<sub>5</sub>d<sub>6</sub> is divisible by 5
* d<sub>5</sub>d<sub>6</sub>d<sub>7</sub> is divisible by 7
* d<sub>6</sub>d<sub>7</sub>d<sub>8</sub> is divisible by 11
* d<sub>7</sub>d<sub>8</sub>d<sub>9</sub> is divisible by 13
* d<sub>8</sub>d<sub>9</sub>d<sub>10</sub> is divisible by 17

Let's consider the example number `3217896504` from above.  
Here, d<sub>2</sub>d<sub>3</sub>d<sub>4</sub> = 217, which is not divisible by 2, so `3217896504` is **not** especially divisible.

The included Java class implements [Heap's Algorithm](https://en.wikipedia.org/wiki/Heap's_algorithm) for generating permutations.

This project was completed for [Project Euler - Problem 43](https://projecteuler.net/problem=43).

I recommend that this code should only be viewed _after_ you've completed your own implementation.  
If you're super stuck, take a break, take a walk, and it will come to you; good luck.
