# -*- coding: cp936 -*-
from decimal import *

#设置保留小数位数长度
getcontext().prec = 2000
def generate():
    lis = []
    for i in range(1,1001):
        result = str(Decimal(1)/Decimal(i))
        if len(result) > 10:
            result = result[2:]
            tmp = ""
            for j in range(10,1000):
                if result[0:j] == result[j:2*j]:
                    tmp = result[0:j]
                    break
            lis.append((tmp,i))
        else:
            lis.append(("",i))
    return lis

def maxLen(x,y):
    x1,y1 = x
    x2,y2 = y
    if len(x1) > len(x2):
        return x
    else:
        return y

def main():
    lis = generate()
    return reduce(maxLen,lis)

print main()[1]




