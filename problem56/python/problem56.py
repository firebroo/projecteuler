def main():
    lis = []
    for i in range(1,100):
        for j in range(1,100):
            tmp = str(i ** j)
            result = 0
            for k in tmp:
                result += int(k)
            lis.append(result)
    return lis

print max(main())
            
