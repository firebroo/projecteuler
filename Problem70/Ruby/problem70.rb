def isPrime(num)
  (2..Math.sqrt(num)).each do |i|
    if num % i == 0
      return false
    end
  end
  return true
end

def primes
  arr = []
  (2..1000).each do |i|
    if isPrime(i)
      arr.push(i)
    end
  end
  arr
end

$list = []
$a = primes

def getPrime(num)
  if isPrime(num)
    $list.push(num)
    return
  end
  $a.each do |i|
    if num % i == 0
      $list.push(i)
      return getPrime(num / i)
    end
  end
end

def main
  min = 100
  (10..10**7).each do |i|
    $list = []
    getPrime(i)
    tmp = i
    $list.uniq.each do |i|
      tmp *= (1 - 1.0/i)
    end
    if tmp < min
      min = tmp
    end
  end
  min
end
p main


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



