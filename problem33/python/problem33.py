from decimal import *
import fractions

getcontext().prec = 10
def generateFraction():
    lis = []
    for i in range(10,100):
        for j in range(10,100):
            tmp = Decimal(i) / Decimal(j)
            if tmp < 1:
                i1 = str(i)
                i2 = str(j)
                i11,i12 = int(i1[0]),int(i1[1])
                i21,i22 = int(i2[0]),int(i2[1])
                if i12 != 0 and i22 != 0:
                    if i11 == i21 and i22 != 0 and (Decimal(12) / Decimal(i22)) == tmp:
                        lis.append((i,j))
                    elif i11 == i22 and i21 != 0 and (Decimal(i12) / Decimal(i21)) == tmp:
                        lis.append((i,j))
                    elif i12 == i21 and i22 != 0 and (Decimal(i11) / Decimal(i22)) == tmp:
                        lis.append((i,j))
                    elif i12 == i22 and i21 != 0 and (Decimal(i11) / Decimal(i21)) == tmp:
                        lis.append((i,j))
    return lis
def main():
    lis = generateFraction()
    result = 1
    for i in lis:
        x1,x2 = i
        tmp = fractions.Fraction(x1,x2)
        result *= tmp
    return result
print main()
                
        
                
            
        
