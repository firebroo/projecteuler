def fact(num)
	result = 1
	1.upto(num) do |i|
		result *= i
	end
	return result
end

def digitSum(num)
	sum = 0
	num.to_s.each_char do |char|
		sum += char.to_i
	end
	return sum
end

puts digitSum(fact(100))
	
