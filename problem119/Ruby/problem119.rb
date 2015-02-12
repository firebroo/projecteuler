def digitsSum(num)
	sum = 0
	num.to_s.each_char do |x|
		sum += x.to_i
	end
	sum
end
#puts digitsSum(123123)

def main()
	list = []
	2.upto(200) do |i|
		2.upto(200) do |j|
			tmp = i ** j
			if i == digitsSum(tmp)
				list.push(tmp)
			end
		end
	end
	list.sort[29]
end

puts main()
