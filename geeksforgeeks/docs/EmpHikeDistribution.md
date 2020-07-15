# Employee Hike Distribution [[Code](https://github.com/SarthakPatidar/Problem-Solving/blob/company-wise/geeksforgeeks/src/com/practice/company/amazon/EmpHikeDistribution)]

## Algorithm
This problem can be solved using Greedy Approach. As employees know hike and ratings of only their neighbor only then following would be one of the conditions which will hold true on the given ratings:
```
Type 1: Hi – 1 > Hi < Hi + 1
Type 2: Hi – 1 < Hi < Hi + 1
Type 3: Hi – 1 > Hi > Hi + 1
Type 4: Hi – 1 < Hi > Hi + 1
```

For each employee based on the above-mentioned conditions set hike of each employee as:
```
For Type 1: Set hike to 1.
For Type 2: Raised his hike by Hi-1 + 1.
For Type 3: Raised his hike by Hi+1 + 1.
For Type 4: Raised his hike by max(Hi-1, Hi+1) + 1.
```