lis = [a ** b for a in range(2,101) for b in range(2,101)]
lis = list(set(lis))
print len(lis)
