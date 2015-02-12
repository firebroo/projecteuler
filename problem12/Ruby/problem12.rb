def main()
	tmp = 1
	2.upto(1000000) do |i|
		tmp += i
		count = 0
		1.upto(Math.sqrt(tmp) + 1) do |j|
			if tmp % j == 0
				count += 1
			end
		end
		if count >= 250
			return tmp
		end
	end
end
puts main()
