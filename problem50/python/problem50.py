import math
import time

def isPrime(x):
    high = int(math.sqrt(x))
    for i in range(2,high+1):
        if x % i == 0:
            return False
    return True


#The first step is to find what several of the former's sum is greater than one-million.
def generateLimitAndPrimeList():
    primesSum = 0
    counter = 0
    j = 2
    lis = []
    while primesSum < 1000000:
        if isPrime(j):
            primesSum += j
            counter += 1
            lis.append(j)
        j += 1
    return (counter - 1,lis)

def main():
    limit = generateLimitAndPrimeList()[0]
    primeList = generateLimitAndPrimeList()[1]
    for i in range(limit,1,-1):
        for j in range(len(primeList)-i):
            primesSum = sum(primeList[j:j+i])
            if primesSum > 1000000:
                break
            elif isPrime(primesSum):
                return primesSum
            
start = time.time()
print main()
print time.time() - start

