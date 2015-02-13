def getDivisorsSum(num)
	sum = 0
	(1...num).each do |i|
		if num % i == 0
			sum += i
		end
	end
	return sum
end

def main()
	result = 0
	(1..10000).each do |i|
		sum = getDivisorsSum(i)
		if getDivisorsSum(sum) == i && sum != i
			result += i
		end
	end
	return result
end

puts main
