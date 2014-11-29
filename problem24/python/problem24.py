def permu(x,y,z):
    single = reduce(lambda x,y: x*y,range(1,x+1)) / x
    remain = z / single
    if remain * single == z:
        i1,i2,i3=y
        return [i2,i3,i1]
    else:
        ele = y[remain-]
        y.remove(ele)
        print y
        return [ele] + permu(x-1,y,z-remain*single)

result = permu(10,['0','1','2','3','4','5','6','7','8','9'],1000000)
print reduce(lambda x,y: x+y,result)
