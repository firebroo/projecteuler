import math

def isPrime(x):
    high = int(math.sqrt(x))
    for i in range(2,high+1):
        if x % i == 0:
            return False
    return True
    
def maxNumber(x,y):
    if x > y:
        return x
    else:
        return y
        
def main():
    lis = []
    i = 1000000
    while i < 9999999:
        tmp = sorted(str(i))
        if tmp == ['1','2','3','4','5','6','7'] and isPrime(i):
            lis.append(i)
        i += 1
    return lis

print reduce(maxNumber,main())
