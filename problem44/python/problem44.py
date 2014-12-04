#效率低的吓人，准备改算法.
def generate():
    lis = []
    for i in range(1,5000):
        tmp = i * (3 * i - 1) / 2
        lis.append(tmp)
    return lis

def generate2():
    lis = []
    for i in range(1,6000):
        tmp = i * (3 * i - 1) / 2
        lis.append(tmp)
    return lis



def main():
    lis = []
    generate1 = generate()
    number = generate2()
    for i in range(5000-1):
        for j in range(i):
            if (generate1[i] - generate1[j]) in generate1 and (generate1[i] + generate1[j]) in number:
                lis.append((generate1[i],generate1[j]))
    return lis

print main()
