def main():
    for i in xrange(1,1000000):
        tmp = sorted(str(i))
        tmp2 = sorted(str(2 * i))
        tmp3 = sorted(str(3 * i))
        tmp4 = sorted(str(4 * i))
        tmp5 = sorted(str(5 * i))
        tmp6 = sorted(str(6 * i))
        if tmp == tmp2 == tmp3 == tmp4 == tmp5 == tmp6:
            return i
print main()
