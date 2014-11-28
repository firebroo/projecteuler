# -*- coding: cp936 -*-
def isaBundant(x):
    lis = []
    for i in range(1,x):
        if(x % i == 0):
            lis.append(i)
    sumResult = reduce(lambda x,y : x + y,lis,0)
    if sumResult > x:
        return True
    else:
        return False

def generateBundantList():
    lis = []
    for i in range(1,28124):
        result = isaBundant(i)
        if result:
            lis.append(i)
    return lis
def main():
    lis = generateBundantList()
    numberList = range(1,28124)
    twoAbundantSumList  = []
    for i in lis:
        for j in lis:
            tmpSum = i + j
            if(tmpSum <= 28123):
                twoAbundantSumList.append(tmpSum)
    #去除List中重复的元素,防止remove多次同个元素异常
    twoAbundantSumList = list(set(twoAbundantSumList))
    for i in twoAbundantSumList:
        numberList.remove(i)
    return reduce(lambda x,y: x + y,numberList)
print main()


