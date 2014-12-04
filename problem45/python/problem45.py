def generatePentagonal():
    lis = []
    for i in range(1,50000):
        lis.append(i * (3 * i - 1) / 2)
    return lis

def generateHexagonal():
    lis = []
    for i in range(1,50000):
        lis.append(i * (2 * i -1))
    return lis


def generateTriangle():
    lis = []
    pentagonal = generatePentagonal()
    hexagonal = generateHexagonal()
    for i in range(1,60000):
        tmp = i * (i + 1) / 2
        if tmp in pentagonal and tmp in hexagonal:
            lis.append(tmp)
    return lis

print generateTriangle()[1]

