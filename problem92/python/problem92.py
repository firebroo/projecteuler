import time

def test(x):
    if x == 1:
        return False
    elif x == 89:
        return True
    else:
        result = 0
        for i in str(x):
            result += int(i) * int(i)
        return test(result)

start = time.time()
print len(filter(lambda x : x,map(test,range(1,10000000))))
print time.time() - start
