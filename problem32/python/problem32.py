def isPandigital(x,y,z):
    lis = []
    result = str(x) + str(y) + str(z)
    if len(result) == 9:
        for i in result:
            lis.append(int(i))
        lis = sorted(lis)
        if lis == [1,2,3,4,5,6,7,8,9]:
            return True
    return False

def main():
    lis = []
    for i in range(1,5000):
        for j in range(1,5000):
            product = i * j
            if isPandigital(i,j,product):
                lis.append(product)
    lis = list(set(lis))
    return lis

print sum(main())
