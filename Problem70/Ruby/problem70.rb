def isPrime(num)
  (2..Math.sqrt(num)).each do |i|
    if num % i == 0
      return false
    end
  end
  return true
end

def stringToList(str)
  list = []
  str.each_char do |char|
    list.push(char)
  end
  list
end

def DigitsIsSame(num1, num2)
  return stringToList(num1) == stringToList(num2)
end

def getPrimeNum(num)
  divisors = []
  (2..Math.sqrt(num)+1).each do |i|
    if num % i == 0 && isPrime(i)
      divisors.push(i)
    end
  end
  count = []
  divisors.each do |j|
    (1..100000000).each do |k|
      tmp = j*k
      if tmp >= num
        break
      else
        count.push(tmp)
      end
    end
  end
  return num - count.uniq.length - 1
end

def main
  (87109..100000).each do |i|
    if not isPrime(i)
      tmp = getPrimeNum(i)
      if DigitsIsSame(tmp.to_s, i.to_s)
        return tmp
      end
    end
  end
end

p getPrimeNum(87109)
p main





=begin
min = 100
num = 0
(10**7).downto(10**6).each do |i|
  if isPrime(i)
    #p i
    tmp = i / getPrimeNum(i)
    if tmp < min
      min = tmp
      num = i
    end
  end
end

p num
=end

