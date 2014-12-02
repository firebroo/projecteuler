def fact(x):
    tmp = 1
    while x > 1:
        tmp *= x
        x -= 1
    return tmp

def main():
    lis = []
    for i in range(3,100000):
        tmp = 0
        for j in str(i):
            tmp += fact(int(j))
        if tmp == i:
            lis.append(i)
    return lis

print sum(main())
