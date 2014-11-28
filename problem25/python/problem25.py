def fibonacci():
    result = 3
    i1 = 1
    i2 = 2
    while (len(str(i2)) < 1000):
        result += 1
        i1,i2 = i2,i1+i2
    return result
print fibonacci()
