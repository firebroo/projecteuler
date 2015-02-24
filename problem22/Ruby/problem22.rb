def generateDict()
	dict = {}
	('A'..'Z').zip(1..26).each do |i,j|
		dict[i] = j
	end
	return dict
end
# 全局字典
$dict = generateDict()
def getRank(word)
	rank = 0
	word.each_char do |i|
		rank += $dict[i]
	end
	return rank
end

file = File.open('1.txt','r')
file.each do |i|
	rank = 0
	lis = i.gsub('"','').split(/,/).sort
	helper = 1
	lis.each do |j|
		rank += getRank(j) * helper
		helper = helper.succ
	end
	puts rank
end
file.close	
