BITS = ['ONE', 'TWO', 'THREE', 'FOUR', 'FIVE', 'SIX', 'SEVEN', 'EIGHT', 'NINE', 'TEN']
TEENS = ['ELEVEN', 'TWELVE', 'THIRTEEN', 'FOURTEEN', 'FIFTEEN', 'SIXTEEN', 'SEVENTEEN', 'EIGHTEEN', 'NINETEEN']
TIES = ['TWENTY', 'THIRTY', 'FORTY', 'FIFTY', 'SIXTY', 'SEVENTY', 'EIGHTY', 'NINETY']
def toEnglish(num)
	result = ""
	if num == 1000
		return "ONE THOUSAND"
	end
	if num >= 100
		result = result + BITS[num/100-1] + ' HUNDRED'
		if num % 100 != 0
			result += ' AND '
		end
		num -= (num / 100) * 100
	end
	if num > 10 && num < 20
		result += TEENS[num - 11]
		num = 0
	end
	if num >= 20
		result += TIES[num/10-2]
		num -= (num / 10) * 10
	end
	if num > 0
		result = result + ' ' + BITS[num-1]
	end
	return result
end
	
def main()
	result = ''
	(1..1000).each do |i|
		result += toEnglish(i)
	end
	result.gsub(' ', '').length()
end

puts main()
