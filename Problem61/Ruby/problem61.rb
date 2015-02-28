def triangle()
  list = []
  (1..200).each do |i|
    tmp = i*(i+1)/2
    if tmp > 9999
      break
    end
    if tmp < 9999 && tmp > 1000
      list.push(tmp.to_s)
    end
  end
  list
end


def square()
  list = []
  (1..200000).each do |j|
    tmp = j*j
    if tmp > 1000 && tmp < 9999
      list.push(tmp.to_s)
    end
    if tmp > 9999
      break
    end
  end
  list
end

def pentagonal
  list = []
  (1..2000).each do |i|
    tmp = i*(3*i-1)/2
    if tmp > 9999
      break
    end
    if tmp > 1000
      list.push(tmp.to_s)
    end
  end
  list
end

def hexagonal
  list = []
  (1..2000).each do |i|
    tmp = i*(2*i-1)
    if tmp > 9999
      break
    end
    if tmp > 1000
      list.push(tmp.to_s)
    end
  end
  list
end

def heptagonal
  list = []
  (1..2000).each do |i|
    tmp = i*(5*i-3)/2
    if tmp > 9999
      break
    end
    if tmp > 1000
      list.push(tmp.to_s)
    end
  end
  list
end

def octagonal
  list = []
  (1..2000).each do |i|
    tmp = i*(3*i-2)
    if tmp > 9999
      break
    end
    if tmp > 1000
      list.push(tmp.to_s)
    end
  end
  list
end

def sortedList(arr)
  sortedArr = []
  arr.each do |i|
    list = []
    i.to_s.each_char do |j|
      list.push(j.to_i)
    end
    sortedArr.push(list.sort.join)
  end
  sortedArr
end


def genDict(list)
  dict = {}
  list.each do |i|
    if dict[i]
      dict[i] += 1
    else
      dict[i] = 1
    end
  end
  dict
end

list1 = triangle
list2 = square
list3 = pentagonal
list4 = hexagonal
list5 = heptagonal
list6 = octagonal

def main(list1, list2, list3, list4, list5, list6)
  newList = []
  list6.each do |i|
    list4.each do |j|
      if j[0, 2] == i[2, 4]
        newList.push(i+j)
      end
    end
  end
  nnewList = []
  newList.each do |i|
    list3.each do |j|
      if j[0, 2] == i[-2..-1]
        nnewList.push(i+j)
      end
    end
  end
  nnnewList = []
  nnewList.each do |i|
    list1.each do |j|
      if j[0, 2] == i[-2..-1]
        nnnewList.push(i+j)
      end
    end
  end
  nnnnewList = []
  nnnewList.each do |i|
    list2.each do |j|
      if i[-2..-1] == j[0, 2]
        nnnnewList.push(i+j)
      end
    end
  end
  b = []
  nnnnewList.each do |i|
    list5.each do |j|
      if j[0, 2] == i[-2..-1]
        b.push(i+j)
      end
    end
  end
  b.each do |i|
    if i[-2..-1] == i[0, 2]
      p i
      return i[0, 4].to_i + i[4, 4].to_i + i[8, 4].to_i + i[12, 4].to_i + i[16, 4].to_i + i[20, 4].to_i
    end
  end
end

main(list1, list2, list3, list4, list5, list6)
