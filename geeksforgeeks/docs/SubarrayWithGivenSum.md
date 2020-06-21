# Subarray with given sum

## Problem Statement
Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.

## Examples
```
Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4
Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33
```
```
Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4
Sum of elements between indices
1 and 4 is 4 + 0 + 0 + 3 = 7
```
```
Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There is no subarray with 0 sum
```

## Algorithm
1. Create 3 variables : start, end and curr_sum
2. Initialize start = 0 and curr_sum = arr[start]
3. Iterate the array from end = 1 to end = arr.length
    1. While sum > curr_sum and start < end-1 (Remove the start element)
        * curr_sum -= arr[start]
        * start++
    2. If curr_sum == sum
        * return start and end index
    3. If end < arr.length
        * curr_sum += arr[end]
4.  If (start, end) pair is not found
    * return -1

## Company Tag
* Adobe
* Amazon
* Facebook
* FactSet
* Google
* Morgan Stanley
* Visa
* Zoho

## Topic Tag
* Arrays
* prefix-sum
* Searching
* Sliding-window