import math

def isPrime(x):
    if x == 1:
        return False
    high = int(math.sqrt(x))
    for i in range(2,high+1):
        if x % i == 0:
            return False
    return True

def generatePrime():
    lis = []
    for i in range(10,1000000):
        if isPrime(i):
            lis.append(i)
    return lis

def isTruncatablePrime1(x):
    if x == '':
        return True
    if isPrime(int(x)):
        return isTruncatablePrime1(x[1:])
    return False

def isTruncatablePrime2(x):
    if x == '':
        return True
    if isPrime(int(x)):
        return isTruncatablePrime2(x[:-1])
    return False

def main():
    lis = generatePrime()
    result = []
    for i in lis:
        if isTruncatablePrime1(str(i)) and isTruncatablePrime2(str(i)):
            result.append(i)
    return result

print sum(main())
    
