# -*- coding: utf-8 -*-
"""
Created on Fri Nov 24 12:21:00 2017

@author: sarthak
"""
    
t = int(input())
for j in range(t):
    n = int(input())
    count = 0
    a = list(map(int, input().split()))
    for i in range(len(a)):
        for j in range(i+1,len(a)):
            if a[i] > a[j]:
                count += 1
                
    if count%2 == 0:
        print("YES")
    else:
        print("NO")
