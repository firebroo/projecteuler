def main():
    lis = []
    for j in range(1,1000):
        for i in range(1,10):
            tmp = str(i ** j)
            if len(tmp) == j:
                lis.append((tmp,i,j))
    return lis
print len(main())
