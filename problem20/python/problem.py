def fact(x):
    if (x == 1):
        return 1
    else:
        return x * fact(x - 1)

def main(x):
    result = 0
    for i in str(x):
        result += int(i)
    return result
print main(fact(100))
