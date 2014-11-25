import math
def isaprime(num):
    i = int(math.sqrt(num))
    for i in range(2,i+1):
        if (num % i == 0):
            return 0
        else:
            pass
    return 1
def main():
    sum = 0
    for i in range(2,2000001):
        if (isaprime(i) == 1):
            sum += i
    print sum
main()
        
    


