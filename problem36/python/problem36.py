def palindromic(x):
    Len = len(x) / 2
    if x[0:Len] == x[::-1][0:Len]:
        return True
    return False

def dec2bin(x):
    return bin(x)[2:]

def main():
    lis = []
    for i in range(1,1000000):
        if palindromic(str(i)) and palindromic(dec2bin(i)):
            lis.append(i)
    return lis

print sum(main())

