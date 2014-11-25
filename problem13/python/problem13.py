def main():
    lis = []
    for i in open("1.txt"):
        tmp = i.replace('\n','')
        lis.append(int(tmp))
    return lis

print str(reduce(lambda x,y: x+y,main()))[0:10]
