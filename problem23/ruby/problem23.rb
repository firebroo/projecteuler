def allDivisorsSum(num)
  sum = 0
  (1..num/2).each do |i|
    if num % i == 0
      sum += i
    end
  end
  sum
end

def isAbundantNumber(num)
  allDivisorsSum(num) > num ? true : false
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
  allAbundantNumber.each do |i|
    allAbundantNumber.each do |j|
      tmp = i + j
      if tmp <= 28123
        result.push(tmp)
      end
    end
  end
  result.uniq!
  result.inject { |i, sum| sum += i }
end

sum = 0
(1..28123).each { |i| sum += i }
puts sum - main


