m,n=input().strip().split(' ')
m,n=[int(m), int(n)]
string1=input().strip().split(' ')
string2=input().strip().split(' ')
matrix =[[0]*(n+1) for it in range(m+1)]
ans=[]
for i in range(1,m+1):
    for j in range(1,n+1):
        if(string1[i-1]==string2[j-1]):
            matrix[i][j]=matrix[i-1][j-1] +1
        else:
            matrix[i][j]= max(matrix[i-1][j], matrix[i][j-1])
x, y = m, n
while x != 0 and y != 0:
    if matrix[x][y] == matrix[x-1][y]:
        x = x-1
    elif matrix[x][y] == matrix[x][y-1]:
        y = y-1
    else:
        assert string1[x-1] == string2[y-1]
        ans.append(string1[x-1])
        x = x - 1
        y = y - 1
print(*ans[::-1])
