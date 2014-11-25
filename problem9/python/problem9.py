import math
def numberSqrt(x,y):
    result = math.hypot(x,y)
    return  result
def pythagoreanTriplet():
    for i in range(1,1000):
        for j in range(1,1000):
            if numberSqrt(i,j) + i + j == 1000:
                return i,j,int(numberSqrt(i,j))
def productABC():
    return reduce(lambda x,y: x*y, pythagoreanTriplet())
print productABC()
            


