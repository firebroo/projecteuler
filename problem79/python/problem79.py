# -*- coding: cp936 -*-
import itertools
import collections

lis = []
for i in open("p079_keylog.txt"):
    lis.append(i.replace('\n',''))
lis = list(set(lis))
dic = {}
for j in lis:
    ord = 3
    for k in j:
        if dic.has_key(k):
            dic[k] += ord
        else:
            dic[k] = ord
        ord -= 1
        
li = [k for j in lis for k in j]
dic2 = {}
for k in dic:
    dic2[k] = li.count(k)
for (k,v) in dic2.items():
    dic[k] /=  float(v)
dic = (sorted(dic.iteritems(),key=lambda asd:asd[1],reverse=True))
print ''.join([x for (x,y) in dic])

#验证
li2 = []
for c in itertools.combinations('73162890', 3):
    li2.append(''.join(str(x) for x in c))
for j in lis:
    if j not in li2:
        print j
    else:
        continue
