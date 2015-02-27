def isPrime(number)
  (2..Math.sqrt(number)+1).each do |i|
    return false if number % i == 0
  end
  return true
end

def main()
  listCount = 1
  step = 2
  primeCount = 0
  nextNumber = 1
  while true do
    4.times do
      nextNumber += step
      primeCount += 1 if isPrime(nextNumber)
    end
    listCount += 4
    step += 2
    return step - 1 if primeCount.to_f / listCount.to_f < 0.1
  end
end

p main
