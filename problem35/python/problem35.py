import math

def isPrime(x):
    high = int(math.sqrt(x))
    for i in range(2,high+1):
        if x % i == 0:
            return False   
    tmp = str(x)
    for j in tmp:
        if j not in '13579':
            return False
    return True

def generate():
    lis = []
    for i in range(10,1000000):
        if isPrime(i):
            lis.append(i)
    return lis

def main():
    result = [2,3,5,7]
    lis = generate()
    for i in lis:
        tmp = str(i)
        tmpLen = len(tmp)
        for j in range(tmpLen):
            tmp = tmp[1:] + tmp[0]
            if int(tmp) not in lis:
                break
            elif j == tmpLen - 2:
                result.append(i)
            else:
                continue
    return result

print len(main())
