def main():
    a = 1
    add = 2
    lis = [1]
    while (a < 1001*1001):
        for i in range(4):
            a += add
            lis.append(a)
        add += 2
    return lis

print reduce(lambda x,y: x+y,main())
