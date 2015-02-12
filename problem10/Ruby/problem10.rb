def isPrime(num)
	2.upto(Math.sqrt(num)) do |i|
		if num % i == 0
			return false
		end
	end
	return true
end

result = 0
2.upto(2000000) do |i|
	if isPrime(i)
		result += i
	end
end
puts result

