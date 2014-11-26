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
            print i
            return largestPrime(x / i)
        else:
            continue
    return 0
print largestPrime(600851475143)

    
