def main():
    lis = []
    for i in range(2,999999):
        if sum([int(j) ** 5 for j in str(i)]) == i:
            lis.append(i)
    return lis
print sum(main())
        
