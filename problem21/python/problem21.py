def dividePair(x):
    result = 0
    for i in range(1,x):
        if (x % i == 0):
            result += i
        else:
            continue
    return (x,result)

def allPairList(fun):
    lis = []
    for i in range(2,10000):
        lis.append(fun(i))
    return lis

def amicablePair():
    lis2 = []
    lis = allPairList(dividePair)
    for i in lis:
        x,y = i
        tmp = (y,x)
        if tmp in lis:
            if(x != y):
                lis2.append(i)
    return lis2
            
def calculate(x):
    i,j = x
    return i + j

print reduce(lambda x,y: x + y,map(calculate,amicablePair())) / 2
    
