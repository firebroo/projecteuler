def sumOfDivisors(n)
  prod = 1
  (2..Math.sqrt(n)+1).each do |k|
    p = 1
    while (n % k == 0)
      p = p * k + 1
      n /= k
    end
    prod *= p
  end
  if n > 1
    prod *= 1 + n
  end
  prod
end

def isAbundantNumber(num)
  sumOfDivisors(num) > num + num
end

def allAbundantNumber
  abundantNumber = []
  (1..28123).each do |i|
    if isAbundantNumber(i)
      abundantNumber.push(i)
    end
  end
  abundantNumber
end

def main
  result = []
  arr = allAbundantNumber
  len = allAbundantNumber.length
  (0...len).each do |i|
    (i...len).each do |j|
      tmp = arr[i] + arr[j]
      if tmp > 28123
        break
      end
      result.push(tmp)
    end
  end
  result.uniq!
  abundantNumberSum = result.inject { |i, sum| sum += i }
  sum = 0
  (1..28123).each { |i| sum += i }
  sum - abundantNumberSum
end

p main
