def getCount(num)
	length = 1
	while (num != 1)
		num = num % 2 == 0 ? num / 2 : 3 * num + 1
		length += 1
	end
	return length
end

def main()
	key = 0
	value = 0
	1.upto(1000000) do |i|
		length = getCount(i)
		key,value = i,length if getCount(i) > value
	end
	puts key,value
end

main()
