def test(x):
    lis = []
    for i in range(1,x+1):
        if(x % i == 0):
            lis.append(i)
    return lis
def generate():
    #lis = []
    tmp = 0
    for i in range(1,10000000):
        tmp += i
        if len(test(tmp)) > 50:
            return tmp
print generate()
    
