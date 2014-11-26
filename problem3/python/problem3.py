def primeList(x):
    lis = []
    for i in range(1,x+1):
        if(x % i == 0):
            lis.append(i)
    return lis

def isPrime(x):
    if(len(primeList(x)) == 2):
        return True
    return False

PrimeList = filter(isPrime,range(1,10000))

def largestPrime(x):
    for i in PrimeList:
        if(x % i == 0):
            if (x in PrimeList):
                return x
            return largestPrime(x / i)
        else:
            continue
print largestPrime(600851475143)

    
