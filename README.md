# Dell_assignment_Towers

## Introduction

Tower of Hanoi game is a puzzle invented by French mathematician Édouard Lucas in 1883.

**History of Tower of Hanoi**

The legend has it there is a temple in Hanoi (Vietnam) that has a large room with three diamond towers surrounded by 64 golden disks (1.844674407371E+19 days).
According to a prophecy, when the last move of the puzzle is completed the world will end. These priests acting on the prophecy, follow the immutable rule by Lord Brahma
of moving these disk one at a time.Hence this puzzle is often called Tower of Brahma puzzle.

**Game Breakdown **

There is an 'n' number of disks.
The objective of the puzzle is to move the stack to another peg following these simple rules.
1) Only one disk can be moved at a time.
2) No disk can be placed on top of the smaller disk.

**Usage **

To start the app solution (set to 4-disk problem)
1) initiate a docker container pull command with docker pull krisjavaprojects/towers_of_hanoi_dell_assignment
2) Alternatively clone the github repo with the following git CLI command -  gh repo clone swim2win/Dell_assignment_Towers

**Algorithm breakdown** 

Using Java 11 Spring Boot image the following "solve" method breaks down the problem into a set of 2 disks and then creates a base(n=1) and a close case(n-1) near the base 
to perform the mathematical recurssion. This methodology yields the minimum required moves as (2^n)-1.
     public void solve(int n, char from, char inter, char to) {}
Breaking down the problem into sets of 2 disks in turn recursively breaks down the Towers of Hanoi task into 3 steps:
step 1) move n-1 disks (all on top) from A to B tower
step 2) move n disk from A to C
step 3) move n-1 disks from B to C (on top of the largest disk which we moved from A)

The time complexity of the algorithm increases as we increase the number of disk. The increment is not linear, it's in a geometric progression. 


For more information on the math and algo behind Towers of Hanoi visit https://www.hackerearth.com/blog/developers/tower-hanoi-recursion-game-algorithm-explained/
