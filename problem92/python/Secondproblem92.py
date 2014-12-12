import time

def square(x):
    return x*x

def generateDict():
    dic = {}
    def generate(y):
        def test(x):
            if x == 1:
                dic[y] = False
                return
            elif x == 89:
                dic[y] = True
                return
            else:
                result = 0
                for i in str(x):
                    result += square(int(i))
                return test(result)
        return test(y)
    map(generate,range(1,568))
    return dic

def main():
    dic = generateDict()
    counter = 0
    for i in xrange(1,10000000):
        result = 0
        for i in str(i):
            result += square(int(i))
        if dic[result]:
            counter += 1
    return counter

start = time.time()
print main()
print time.time() - start
