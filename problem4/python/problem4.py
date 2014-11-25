def palindromicNumberList():
    lis = []
    for i in range(999*999,100*100,-1):
        if str(i)[0:3] == (str(i)[::-1])[0:3]:
            lis.append(i)
    return lis
    
def isContain():
    lis = palindromicNumberList()
    for i in lis:
        if i in [x*y for x in range(999,100,-1) for y in range(999,100,-1)]:
            return i
print isContain()

