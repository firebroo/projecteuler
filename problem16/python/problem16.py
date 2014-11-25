def digitSum():
    sum = 0
    for i in str(2 ** 1000):
        sum += int(i)
    return sum
print digitSum()
