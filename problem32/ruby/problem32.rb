def isPandigital(x,y,z)
	lis = []
	result = x.to_s + y.to_s + z.to_s
	if result.length == 9
		result.each_char do |i|
			lis.push(i.to_i)
		end
		lis.sort!
		if lis == [1,2,3,4,5,6,7,8,9]
			return true
		end
	end
	return false
end

def main()
	lis = []
	(1..2000).each do |i|
		(1..1000).each do |j|
			product = i * j
			if isPandigital(i, j, product)
				lis.push(product)
			end
		end
	end
	return lis.uniq
end

puts main.inject {|i, sum| sum += i}
