def isPrime(x)
	high = Math.sqrt(x).to_i
	for i in 2...(high+1)
		if x % i == 0
			return false
		end
	end
	return true
end

def generateLimitAndPrimeList()
	primesSum = 0     #素数和
	counter = 0       #计数器
	number = 2        #初始化为2
	lis = []          #素数列表
	while primesSum < 1000000
		if isPrime(number)
			primesSum += number
			counter += 1
			lis.push(number)
		end
		number += 1
	end
	return counter,lis
end

def main()
	limit = generateLimitAndPrimeList()[0]
	primeList = generateLimitAndPrimeList()[1]
	limit.downto(1) do |i|
		for j in 0..primeList.size
			primesSum = primeList[j,j+i].inject(0) {|sum,i| sum+i}
			if primesSum > 1000000
				break
			end
			if isPrime(primesSum)
				return primesSum
			end
		end
	end
end


print main()
