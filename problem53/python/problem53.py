def fact(n):
    result = 1
    start = 1
    while (start <= n):
        result *= start
        start += 1
    return result


def combinatorics(x):
    return lambda y : fact(x) / fact(y) / fact(x - y)

print sum(map((lambda y : len(filter(lambda x : x > 1000000,map(combinatorics(y),range(1,y + 1))))),range(1,101)))
