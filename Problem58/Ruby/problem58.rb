def generator()
  init = 1
  list = [init]
  step = 2
  primeList = []
  count = 1
  while true do
    nextNumber = init + step
    list.push(nextNumber)
    if isPrime(nextNumber)
      primeList.push(nextNumber)
    end
    3.times do
      nextNumber += step
      if isPrime(nextNumber)
        primeList.push(nextNumber)
      end
      list.push(nextNumber)
    end
    step += 2
    init = nextNumber
    count += 1
    if primeList.length.to_f / list.length.to_f < 0.1
      return count
    end
  end
end


def isPrime(number)
  (2..Math.sqrt(number)+1).each do |i|
    if number % i == 0
      return false
    end
  end
  return true
end

p generator * 2 - 1

