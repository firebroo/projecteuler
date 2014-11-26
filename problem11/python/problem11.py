def test():
    lis = []
    for i in open("1.txt"):
        result = i.replace('\n','')
        lis.append(result.split(" "))
    return lis

testlis1 = test()
def test1():
    lis = []
    for j in range(20):
        tmp = []
        for i in range(20):
            tmp.append(testlis1[i][j])
        lis.append(tmp)
    return lis
testlis2 = test1()

def main(z):
    lis = []
    
    def main1(x):
        lis = []
        low = 0
        high = 4
        while True:
            tmp = reduce(lambda x,y: int(x) * int(y),x[low:high])
            lis.append(tmp)
            low += 1
            high += 1
            if (high>len(x)):
                break
        return lis
    for i in range(20):
        tmp = main1(z[i])
        lis.append(tmp)
    return lis
print main(testlis2)

