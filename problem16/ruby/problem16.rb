def digitSum()
	sum = 0
	(2 ** 1000).to_s.each_char do |i|
		sum += i.to_i
	end
	puts sum
end

digitSum
