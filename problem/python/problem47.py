import math

def isPrime(x):
    high = int(math.sqrt(x))
    for i in range(2,high+1):
        if x % i == 0:
            return False
    return True

def generatePrimes():
    lis =[]
    for i in range(2,1000):
        if isPrime(i):
          lis.append(i)
    return lis

def primeFactors(x):
    lis =[]
    primes = generatePrimes()
    while not isPrime(x):
        for i in primes:
            if x % i == 0:
                lis.append(i)
                break
        x = x / i
    lis.append(x)
    return lis

def generate4Factors():
    lis = []
    for x in range(1,150000):
        factorsLen = len(list(set(primeFactors(x))))
        lis.append(factorsLen)
    return lis

def main():
    a = generate4Factors()
    n = len(a)
    for i in range(1,n+1-3):
        if (a[i]==4 and a[i+1]==4 and a[i+2]==4 and a[i+3]==4):
           return i

print main()


