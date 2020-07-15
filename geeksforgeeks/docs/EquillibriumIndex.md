# Equillibrium Index of Array [[Code](https://github.com/SarthakPatidar/Problem-Solving/blob/company-wise/geeksforgeeks/src/com/practice/company/amazon/EquillibriumIndex)]

## Algorithm 
1. Initialize leftsum  as 0
2. Get the total sum of the array as sum
3. Iterate through the array and for each index i, do following.
    ```
    a  Update sum to get the right sum.  
          sum = sum - arr[i] 
       // sum is now right sum
    b) If leftsum is equal to sum, then return current index. 
       // update leftsum for next iteration.
    c) leftsum = leftsum + arr[i]
    ```
4. return -1 <br />
// If we come out of loop without returning then there is no equilibrium index