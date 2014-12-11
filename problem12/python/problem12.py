import math

def main():
    tmp = 1
    for i in xrange(2,100000):
        tmp += i
        counter = 0
        for j in range(1,int(math.sqrt(tmp)) + 1):
            if tmp % j == 0:
                counter += 1
        if counter >= 250:
            return tmp
print main()
    
