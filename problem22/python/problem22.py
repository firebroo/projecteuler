def generateDictionary():
    dic = {}
    tmp = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    lis = []
    for i in tmp:
        lis.append(i)
    dic = dict([(i,j) for (i,j) in zip(lis,range(1,27))])
    return dic

def sumNamesScores():
    dic = generateDictionary()
    for i in open("p022_names.txt"):
        lis = sorted(i.replace('"',"").split(','))
        sumResult = 0
        for (i,j) in zip(lis,range(1,len(lis)+1)):
            tmp = 0
            for k in i:
                tmp += dic[k]
            sumResult += tmp * j
        return sumResult

print sumNamesScores()
