def main():
    lis = []
    for i in range(1,10000):
        tmp1 = i * 1
        tmp2 = i * 2
        tmp = str(tmp1) + str(tmp2)
        result = sorted(tmp)
        if result == ['1','2','3','4','5','6','7','8','9']:
            lis.append(tmp)
    for j in range(1,1000):
        tm1 = j * 1
        tm2 = j * 2
        tm3 = j * 3
        tm = str(tm1) + str(tm2) + str(tm3)
        resul = sorted(tm)
        if resul == ['1','2','3','4','5','6','7','8','9']:
            lis.append(tm)
    return lis

print max(main())
