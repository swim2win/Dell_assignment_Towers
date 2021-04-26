#Tower of Hanoi
###Introduction
The Tower of Hanoi (also called the Tower of Brahma or Lucas' Tower and sometimes pluralized as Towers, or simply pyramid puzzle) is a mathematical game or puzzle. It consists of three rods and a number of disks of different diameters, which can slide onto any rod. The puzzle starts with the disks stacked on one rod in order of decreasing size, the smallest at the top, thus approximating a conical shape.

###Methodology to find the solution
- For an even number of disks:

* make the legal move between pegs A and B (in either direction),
* make the legal move between pegs A and C (in either direction),
* make the legal move between pegs B and C (in either direction),
repeat until complete.
- For an odd number of disks:

* make the legal move between pegs A and C (in either direction),
* make the legal move between pegs A and B (in either direction),
* make the legal move between pegs B and C (in either direction),
repeat until complete.
In each case, a total of 2^n-1 moves are made.

###Comments
This solution has the time complexity of a^n. So, the maximum number of disks you can practicaly solve for using this algorithm is 31, which might end up taking years. 
For that matter you might need 1000s of years to solve the problem if the number of disks is 100, using this method.
This was just a fun project, and a more optimal solution does exist. I will be exploring that later.
