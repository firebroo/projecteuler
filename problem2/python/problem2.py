def fibonacci():
    lis=[1]
    i1 = 1
    i2 = 2
    while True:
        i1,i2=i2,i2+i1
        lis.append(i1) 
        if i2 > 4000000:
            break
    return lis
lis = fibonacci()
print sum([i for i in lis if i % 2 == 0])
