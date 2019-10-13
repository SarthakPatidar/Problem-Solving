# -*- coding: utf-8 -*-
"""
Created on Wed Nov 29 20:13:20 2017

@author: sarthak
"""

rows,columns = [int(x) for x in input().split()]
v = []
result = {}
max_out = 0

def pick_one(p,q,v,i,j,count):

    if v[p][q] == 'G':                
        if p-i>=0 and p+i<=len(v)-1 and q-j>=0 and q+j<=len(v[p])-1:
            
            top = v[p-i][q]
            left = v[p][q-j]
            right = v[p][q+j]
            bottom = v[p+i][q]
           
            if top == 'G' and bottom == 'G' and left == 'G' and right == 'G':
                v[p-i][q] = v[p][q-j] = v[p][q+j] = v[p+i][q] = v[p][q] = 'X'
                
                if result.get(count+1,-999) < check_for_all(v):
                    result[count+1] = check_for_all(v)
                
                v[p][q] = 'G'
                return pick_one(p,q,v,i+1,j+1,count+1)
            else:
                v[p][q] = 'X'
                if result.get(count,-999) < check_for_all(v):
                    result[count] = check_for_all(v)
                
                v[p][q] = 'G'
                for r in range(1,count):
                    v[p-r][q] = 'G'
                    v[p][q-r] = 'G'
                    v[p][q+r] = 'G'
                    v[p+r][q] = 'G'
                    

        else:
            v[p][q] = 'X'
            if result.get(count,-999) < check_for_all(v):
                result[count] = check_for_all(v)
            
            v[p][q] = 'G'
            for r in range(1,count):
                v[p-r][q] = 'G'
                v[p][q-r] = 'G'
                v[p][q+r] = 'G'
                v[p+r][q] = 'G'    
    return result

def check_for_all(v):
    
    maximum = 0
    for p in range(rows):
        for q in range(columns):
            
            count1 = 1

            if v[p][q] == 'G':
                i = 1 
                j = 1
                
                while p-i>=0 and p+i<=len(v)-1 and q-j>=0 and q+j<=len(v[p])-1:
                    top = v[p-i][q]
                    left = v[p][q-j]
                    right = v[p][q+j]
                    bottom = v[p+i][q]
           
                    if top == 'G' and bottom == 'G' and left == 'G' and right == 'G':
                        count1 += 1
                        #print(count1)
                    else:
                        break
                    i += 1
                    j += 1
                        
                if maximum < count1:
                    maximum = count1
                

    return maximum   
    
for i in range(rows):
    a = list(map(str, input()))
    v.append(a)

for m in range(rows):
    for n in range(columns):
        
        res = pick_one(m,n,v,1,1,1)
 
 
for k in res:
    area_1 = 1 + 4*(k-1)
    area_2 = 1 + 4*(res[k]-1)
    
    if max_out < area_1 * area_2:
        max_out = area_1 * area_2

print(max_out)           
 