lis = []
dic = {}
i = 1
def positive():
    def positive2(x):
        readble = x
        def positive3(y):
            global i
            if y == 1:
                lis.append(i)
                dic[i] = readble
                i = 1
                return 
            if (y % 2 == 0):
                i += 1
                positive3(y/2)
            else:
                i += 1
                positive3(3*y+1)
        positive3(x)
    for j in range(1,1000001):
        positive2(j)
positive()
maxLength = max(lis)
print dic[maxLength]


