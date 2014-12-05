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
        if len(list(set(primeFactors(x)))) == 4:
           lis.append(x)
    return lis

def main():
    lis = generate4Factors()
    for i in range(len(lis) - 3):
        if lis[i] + 3 == lis[i+1] + 2 == lis[i+2] + 1 == lis[i+3]:
            return lis[i]

print main()


