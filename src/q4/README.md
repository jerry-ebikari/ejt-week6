# Question 4

#### Question 4:
Suppose that A and B are variables of type set in Java. The mathematical operations on A and B can be computed using methods from the Set interface. In particular: A.addAll(B) computes the union of A and B; A.retainAll(B) computes the intersection of A and B; and A.removeAll(B) computes the difference of A and B. (These operations change the contents of the set A, while the mathematical operations create a new set without changing A, but that difference is not relevant to this exercise.)
Write a program that can be used as a "set calculator" for simple operations on sets of non-negative integers. A set of such integers will be represented as a list of integers, separated by commas and, optionally, spaces and enclosed in square brackets. For example: [1,2,3] or [17, 42, 9, 53, 108]. The characters +, *, and - will be used for the union, intersection, and difference operations respectively. The user of the program will type in lines of input containing two sets, separated by an operator. The program should perform the operation and print the resulting set. Here are some examples:

| Input                               | Output          |
|-------------------------------------|-----------------|
| [1, 2, 3]  +  [3,  5,  7]           | [1, 2, 3, 5, 7] |
| [10,9,8,7]  *  [2,4,6,8]            | [8]             |
| [ 5, 10, 15, 20 ]  -  [ 0, 10, 20 ] | [5, 15]         |

