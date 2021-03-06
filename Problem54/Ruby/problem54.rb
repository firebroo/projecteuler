=begin
游戏规则: 一副扑克牌, 双方各5张牌比较大小
=end
#getMaxChar :: String -> Int
def getMaxChar(str)
  maxNumber = 0
  str.each_char do |i|
    i = replaceCharToNumber(i)
    maxNumber = i.to_i if i.to_i > maxNumber
  end
  maxNumber
end

#stringToList :: String -> [Char]
def stringToList(str)
  list = []
  str.each_char do |char|
    list.push(char)
  end
  list
end

#replaceNumberToChar :: Int -> String
def replaceNumberToChar(number)
  case number
    when 10
    then
      number = 'T'
    when 11
    then
      number = 'J'
    when 12
    then
      number = 'Q'
    when 13
    then
      number = 'K'
    when 14
    then
      number = 'A'
  end
  number.to_s
end

#replaceCharToNumber :: String -> Int
def replaceCharToNumber(char)
  case char
    when 'T'
    then
      char = 10
    when 'J'
    then
      char = 11
    when 'Q'
    then
      char = 12
    when 'K'
    then
      char = 13
    when 'A'
    then
      char = 14
  end
  char.to_i
end

#获取卡组的值
#getCharValue :: String -> String
def getCardValue(str)
  str[0] + str[2] + str[4] + str[6] + str[8]
end

#获取卡组的花色
#getCharSuit :: String -> String
def getCardSuit(str)
  str[1] + str[3] + str[5] + str[7] + str[9]
end

#countCardValue :: String -> {String=>Int}
def countCardValue(str)
  dict = {}
  str = getCardValue(str)
  str.each_char do |i|
    if dict[i]
      dict[i] += 1
    else
      dict[i] = 1
    end
  end
  dict
end

#getMaxNumber :: String -> Int -> Int
def getMaxNumber(str, num)
  number = 0
  dict = countCardValue(str)
  dict.each do |i, j|
    if j == num
      number = i
    end
  end
  replaceCharToNumber(number)
end

#splitString :: String -> [String]
def splitString(str)
  len = str.length
  rightStr = str[0, len/2]
  leftStr = str[len/2, len]
  return [rightStr, leftStr]
end

#花色是否全部相同
#sameSuit :: String -> Boolean
def sameSuit(str)
  cardSuit = getCardSuit(str)
  cardSuit.count(cardSuit[0]) == 5
end

#牌组是否连续
#consecutiveValue :: String -> Boolean
def consecutiveValue(str)
  cardValue = getCardValue(str)
  list = stringToList(cardValue)
  /#{list.sort.join}/ =~ '23456789AJKQT'
end

#得到牌组的权重
#getRank :: String -> Int
def getRank(str)
  rank = 1
  if sameSuit(str) && consecutiveValue(str)
    rank = 9 #Straight Flush
    if str[0] == 'T' #Royal Flush
      rank = 10
    end
    return rank
  end
  count = countCardValue(str)
  if count.values.include? 4 #Four of a Kind:
    rank = 8
    return rank
  end
  if (count.values.include? 3) && (count.values.include? 2) #Full House
    rank = 7
    return rank
  end
  if sameSuit(str) #Flush
    rank = 6
    return rank
  end
  if consecutiveValue(str) #Straight
    rank = 5
    return rank
  end
  if count.values.include? 3 #Three of a Kind
    rank = 4
    return rank
  end
  if count.values.include? 2 and count.values.length == 3 #Two Pairs
    rank = 3
    return rank
  end
  if count.values.include? 2 #One Pair
    rank = 2
    return rank
  end
  return rank #High Card
end

#Spade is the max，second is the Heart, third is the Diamond, min is the Club
#colorCompare :: String -> String -> Boolean
def colorCompare(str1, str2)
  str1 > str2
end

#handleTwoCardSameValue :: String -> [Int]
def handleTwoCardSameValue(str)
  max = 0
  list = []
  str.each_char do |i|
    if str.count(i) == 2
      max = replaceCharToNumber(i)
    else
      list.push(replaceCharToNumber(i))
    end
  end
  return [max] + list.sort.reverse
end

#handleTwoPairs :: String -> [Int]
def handleTwoPairs(str1)
  min = 0
  str1.each_char do |i|
    if str1.count(i) == 1
      min = i
    end
  end
  str1.gsub!(min, '')
  list = []
  str1.each_char do |j|
    list.push(replaceCharToNumber(j))
  end
  list.uniq!
  max = list.max
  second = list.min
  return [max, second, replaceCharToNumber(min)]
end

#得到牌值的花色
#findNextChar :: String -> Char -> Int
def findNextChar(str1, char)
  index = 0
  getCardValue(str1).each_char do |i|
    if i == char
      break
    end
    index += 2
  end
  index + 1
end

#handleFile :: Int
def handleFile
  count = 0
  open('./p054_poker.txt').each do |i|
    i.gsub!(' ', '')
    str = splitString(i)
    player1 = str[0]
    player2 = str[1]
    player1Rank = getRank(player1)
    player2Rank = getRank(player2)
    count += 1 if player1Rank > player2Rank
    if player1Rank == player2Rank
      if player1Rank == 1 || player1Rank == 9 || player1Rank == 5
        str1 = getCardValue(player1)
        str2 = getCardValue(player2)
        maxNumber1 = getMaxChar(str1)
        maxNumber2 = getMaxChar(str2)
        #print maxNumber1,"\t",str1,"\t",maxNumber2, "\t",str2,"\n"
        count += 1 if maxNumber1 > maxNumber2
      end
      if player1Rank == 2
        maxNumber1 = getMaxNumber(player1, 2)
        maxNumber2 = getMaxNumber(player2, 2)
        #print maxNumber1,"\t",player1,"\t",maxNumber2, "\t",player2,"\n"
        count += 1 if maxNumber1 > maxNumber2
        if maxNumber1 == maxNumber2
          str1 = getCardValue(player1)
          str2 = getCardValue(player2)
          arr1 = handleTwoCardSameValue(str1)
          arr2 = handleTwoCardSameValue(str2)
          count += 1 if arr1[1] > arr2[1]
          if arr1[1] == arr2[1]
            count += 1 if arr1[2] > arr2[2]
            if arr1[2] == arr2[2]
              count += 1 if arr1[3] > arr2[3]
              if arr1[3] == arr2[3]
                suit1 = findNextChar(player1, replaceCharToNumber(arr1[0]))
                suit2 = findNextChar(player2, replaceCharToNumber(arr2[0]))
                count += 1 if colorCompare(suit1, suit2)
              end
            end
          end
        end
      end
      if player1Rank == 3
        arr1 = handleTwoPairs(getCardValue(player1))
        arr2 = handleTwoPairs(getCardValue(player2))
        #4个对子都不同,取决最大的对子
        count += 1 if arr1[0] > arr2[0]
        #大一点的对子相同时
        if arr1[0] == arr2[0]
          count += 1 if arr1[1] > arr2[1]
          #两个对子都相同时
          if arr1[1] == arr2[1]
            count += 1 if arr1[3] > arr1[3]
            #第三张牌也相同时，比较大对子的花色
            if arr1[3] == arr2[3]
              suit1 = player1[findNextChar(player1, arr1[0])]
              suit2 = player2[findNextChar(player2, arr2[0])]
              count += 1 if colorCompare(suit1, suit2)
            end
          end
        end
      end
      if player1Rank == 4 || player1Rank == 7
        maxNumber1 = getMaxNumber(player1, 3)
        maxNumber2 = getMaxNumber(player2, 3)
        count += 1 if maxNumber1 > maxNumber2
      end
      #在花色相同时没有处理
      if player1Rank == 6
        suit1 = getCardSuit(player1)
        suit2 = getCardSuit(player2)
        if suit1 > suit2
          count += 1
        end
      end
      if player1Rank == 8
        maxNumber1 = getMaxNumber(player1, 4)
        maxNumber2 = getMaxNumber(player2, 4)
        count += 1 if maxNumber1 > maxNumber2
      end
    end
  end
  count
end

p handleFile

