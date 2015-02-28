def sortNumber(num)
  arr = []
  num.to_s.each_char do |i|
    arr.push(i)
  end
  arr.sort.join
end


def findResultString
  dict = {}
  (1..100000).each do |i|
    tmp = sortNumber(i**3)
    if dict[tmp]
      dict[tmp] += 1
      if dict[tmp] == 5
        return tmp
      end
    else
      dict[tmp] = 1
    end
  end
end

def main
  string = findResultString
  (1..10000).each do |i|
    if string == sortNumber(i ** 3)
      return i ** 3
    end
  end
  return nil
end

p main

