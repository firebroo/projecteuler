import time
# 必须经过至少一次迭代不能到达回文的数才算Lychrel number.
def itereator(x):
    return x + int(str(x)[::-1])

def isPalindromes(x):
    tmp = str(x)
    if tmp == tmp[::-1]:
        return True
    return False

def producePalindromes(x):
    count = 0
    while count < 50:
        tmp = itereator(x)
        count += 1
        if isPalindromes(tmp):
            return True
        x = tmp
    return False

def main():
    count = 0
    for i in range(10000):
        if  not producePalindromes(i):
            count += 1
    return count

start = time.time()
print main()
print time.time() - start
