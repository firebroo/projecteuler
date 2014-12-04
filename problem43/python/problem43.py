def initList():
    lis = []
    for i in range(102,999):
        if i % 2 == 0:
            tmp = []
            for j in str(i):
                if j not in tmp:
                    tmp.append(j)
            if len(tmp) == 3:
                lis.append(i)
    return lis

def stepList(x,li):
    lis = []
    for i in li:
        tmp = range(10)
        for j in str(i):
            tmp.remove(int(j))
        for k in tmp:
            result = int(str(i)[-2:] + str(k))
            if result % x == 0:
                lis.append(int(str(i) + str(k)))
    return lis

def main():
    lis = stepList(17,stepList(13,stepList(11,stepList(7,stepList(5,stepList(3,initList()))))))
    result = []
    tmp = range(10)
    for i in lis:
        for j in tmp:
            if str(j) not in str(i):
                result.append(int(str(j) + str(i)))
    return sum(result)

print main()
