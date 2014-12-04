import math
#效率欠佳，超过几秒了。。。
def main():
    lis = []
    for i in range(1,1001):
        add = 0
        for j in range(1,i+1):
            for k in range(1,i+1-j):
                l = math.hypot(j,k)
                if j + k + l == i:
                    add += 1
        if add != 0:
            lis.append((i,add / 2))
    return lis

def maxNumber(x,y):
    x1,x2 = x
    y1,y2 = y
    if x2 > y2:
        return (x1,x2)
    else:
        return (y1,y2)

print reduce(maxNumber,main())[0]


