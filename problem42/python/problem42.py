def handldingText():
    for i in open("p042_words.txt"):
        lis = i.replace('"','').split(',')
    return lis

def generateTriangleNumbers():
    lis = []
    for i in range(1,100):
        tmp = i * (i + 1) / 2
        lis.append(tmp)
    return lis

def generateDictionary():
    dic = {}
    tmp = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    lis = []
    for i in tmp:
        lis.append(i)
    dic = dict([(i,j) for (i,j) in zip(lis,range(1,27))])
    return dic

def main():
    lis = []
    dic = generateDictionary()
    triangleNumbers = generateTriangleNumbers()
    for words in handldingText():
        tmp = 0
        for word in words:
            tmp += dic[word]
        if tmp in triangleNumbers:
            lis.append(words)
    return lis

print len(main())
