import math

def generateDoubleSquareNumber():
    lis = []
    for i in range(1,100):
        lis.append(2 * i ** 2)
    return lis

def isPrime(x):
    high = int(math.sqrt(x))
    for i in range(2,high+1):
        if x % i == 0:
            return False
    return True

def generatePrime():
    lis = []
    for i in range(2,6000):
        if isPrime(i):
            lis.append(i)
    return lis

def generateOddCompositeNumber():
    lis1 = [i for i in range(9,6000) if i % 2 == 1]
    lis2 = generatePrime()
    for i in lis1:
        for j in lis2:
            if j in lis1:
                lis1.remove(j)
    return lis1
    
def main():
    OddCompositeNumber = generateOddCompositeNumber()
    primes = generatePrime()
    doubleSquareNumber = generateDoubleSquareNumber()
    for i in OddCompositeNumber:
        add = True
        for j in primes:
            if i > j:
                tmp = i - j
                if tmp in doubleSquareNumber :
                    add = False
                    break
        if add == True:
            return i
print main()

    
