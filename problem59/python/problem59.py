def splitEncryptedTextToList():
    for i in open("p059_cipher.txt"):
        lis = i.replace('\n',"").split(',')
        listLen = len(lis)
        lis1 = [int(lis[i]) for i in range(listLen) if i % 3 == 0]
        lis2 = [int(lis[i]) for i in range(listLen) if i % 3 == 1]
        lis3 = [int(lis[i]) for i in range(listLen) if i % 3 == 2]
        return lis1,lis2,lis3
    
    
def fuzzEncryptKey(lis):
    result = []
    common = range(65,91) + range(97,123)
    for j in range(97,123):                   #Ascii 'a'~'z'
        counter = 0
        for k in lis:
            if (j ^ k) in common:
                counter += 1
        result.append((counter,j))
    return result

def maxTuple(x,y):
    x1,x2 = x
    y1,y2 = y
    if x1 > y1:
        return x
    else:
        return y
    
def getMaybeKeysTuple():
    lis = splitEncryptedTextToList()
    maybeEncryptKey1 = reduce(maxTuple,fuzzEncryptKey(lis[0]))[1]
    maybeEncryptKey2 = reduce(maxTuple,fuzzEncryptKey(lis[1]))[1]
    maybeEncryptKey3 = reduce(maxTuple,fuzzEncryptKey(lis[2]))[1]
    return maybeEncryptKey1,maybeEncryptKey2,maybeEncryptKey3
    
def zipList():
    maybeKeys = getMaybeKeysTuple()
    lis = splitEncryptedTextToList()
    key1 = maybeKeys[0]
    key2 = maybeKeys[1]
    key3 = maybeKeys[2]
    lis1 = lis[0]
    lis2 = lis[1]
    lis3 = lis[2]
    li1 = []
    li2 = []
    li3 = []
    for i in lis1[:-1]:
        li1.append(chr(i ^ key1))
    for j in lis2:
        li2.append(chr(j ^ key2))
    for k in lis3:
        li3.append(chr(k ^ key3))
    return zip(li1,li2,li3) + [tuple(chr(lis1[-1] ^ key1))]

def asciiSum():
    result = "".join([j for i in zipList() for j in i])
    asciiSum = 0
    for i in result:
        asciiSum += ord(str(i))
    return asciiSum

print asciiSum()

