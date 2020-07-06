# Maximum Index [[Code]](https://github.com/SarthakPatidar/Problem-Solving/blob/company-wise/geeksforgeeks/src/com/practice/company/google/MaximumIndex.java)

## Problem Statement
Given an array arr[], find the maximum j – i such that arr[j] >= arr[i]

## Examples 
```
  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)
```
```
  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)
```
```
  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)
```
```
  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
```

## Algorithm
* Construct LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i])
* Construct RMax[] such that RMax[j] stores the maximum value form (arr[j], arr[j+1], ... arr[n-1])
* Traverse both arrays from left to right to find optimum ( j-i ). This process is similar to merge() of MergeSort

## Company Tags
* Amazon
* Google
* Snapdeal
* VMWare

## Topic Tags
* Arrays