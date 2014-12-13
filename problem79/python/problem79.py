# -*- coding: cp936 -*-
import itertools
import collections

'''
此算法根据概率产生最有可能的密码，一般情况下可以工作的良好.
'''

def filterPasswordText():
    #假定在3位密码中第一个的值的rank标记为3，第二个为2，第三个为1.
    lis = []
    for i in open("p079_keylog.txt"):
        lis.append(i.replace('\n',''))
    return list(set(lis))

def generateRankDict():
    lis = filterPasswordText()
    rankDict = {}
    for j in lis:
        ord = 3
        for k in j:
            if rankDict.has_key(k):
                rankDict[k] += ord
            else:
                rankDict[k] = ord
            ord -= 1
    li = [k for j in lis for k in j]
    countDict = {}
    for k in rankDict:
        countDict[k] = li.count(k)
    for (k,v) in countDict.items():
        rankDict[k] /=  float(v)                                         #按照出现概率计算平均rank
    return rankDict

def main():
    rankDict = generateRankDict()                      
    lis = sorted(rankDict.iteritems(),key=lambda x:x[1],reverse=True)    #根据字典value进行正序排序.
    return ''.join([x for (x,y) in lis])

print main()

#验证
def verif():
    li2 = []
    #需要验证的密码可能列表
    lis = filterPasswordText()
    string = main()
    #生成main()的所有正排列可能组合
    for c in itertools.combinations(string, 3):
        li2.append(''.join(str(x) for x in c))
    for j in lis:
        if j not in li2:
            return False
        else:
            continue
    return True

print verif()
    
