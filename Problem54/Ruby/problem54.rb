def replaceAndSortStr(str)
  maxNumber = 0
  str.each_char do |i|
    i = replaceCharToNumber(i)
    if i.to_i > maxNumber
      maxNumber = i.to_i
    end
  end
  maxNumber
end

def stringToList(str)
  list = []
  str.each_char do |char|
    list.push(char)
  end
  list
end

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
  char
end

def getCardValue(str)
  str[0] + str[2] + str[4] + str[6] + str[8]
end

def getCardSuit(str)
  str[1] + str[3] + str[5] + str[7] + str[9]
end

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

def getMaxNumber(str, num)
  number = 0
  dict = countCardValue(str)
  dict.each do |i, j|
    if j == num
      number = i
    end
  end
  replaceCharToNumber(number).to_i
end

def splitString(str)
  len = str.length
  rightStr = str[0, len/2]
  leftStr = str[len/2, len]
  return [rightStr, leftStr]
end

def sameSuit(str)
  cardSuit = getCardSuit(str)
  cardSuit.count(cardSuit[0]) == 5
end

def consecutiveValue(str)
  cardValue = getCardValue(str)
  list = stringToList(cardValue)
  /#{list.sort.join}/ =~ '23456789AJKQT'
end

def getRank(str)
  rank = 1
  if sameSuit(str) && consecutiveValue(str)
    rank = 9             #Straight Flush
    if str[0] == 'T'     #Royal Flush
      rank = 10
    end
    return rank
  end
  count = countCardValue(str)
  if count.values.include? 4   #Four of a Kind:
    rank = 8
    return rank
  end
  if (count.values.include? 3) && (count.values.include? 2) #Full House
    rank = 7
    return rank
  end
  if sameSuit(str)  #Flush
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
  if count.values.include? 2 and count.values.length == 3  #Two Pairs
    rank = 3
    return rank
  end
  if count.values.include? 2    #One Pair
    rank = 2
    return rank
  end
  return rank                   #High Card
end

#Spade is the max，second is the Heart, third is the Diamond, min is the Club
def colorCompare(str1, str2)
  str1 > str2
end

def handleFile
  count = 0
  open('./p054_poker.txt').each do |i|
    i.gsub!(' ', '')
    str = splitString(i)
    player1 = str[0]
    player2 = str[1]
    player1Rank = getRank(player1)
    player2Rank = getRank(player2)
    if player1Rank > player2Rank
      count += 1
    end
    if player1Rank == player2Rank
      if player1Rank == 1 || player1Rank == 9 || player1Rank == 5
        str1 = player1[0] + player1[2] + player1[4] + player1[6] + player1[8]
        str2 = player2[0] + player2[2] + player2[4] + player2[6] + player2[8]
        maxNumber1 = replaceAndSortStr(str1)
        maxNumber2 = replaceAndSortStr(str2)
        #print maxNumber1,"\t",str1,"\t",maxNumber2, "\t",str2,"\n"
        if maxNumber1 > maxNumber2
          count += 1
        end
      end
      if player1Rank == 2
        maxNumber1 = getMaxNumber(player1, 2)
        maxNumber2 = getMaxNumber(player2, 2)
        #print maxNumber1,"\t",player1,"\t",maxNumber2, "\t",player2,"\n"
        if maxNumber1 > maxNumber2
          count += 1
        end
        if maxNumber1 == maxNumber2
          str1 = player1[0] + player1[2] + player1[4] + player1[6] + player1[8]
          str2 = player2[0] + player2[2] + player2[4] + player2[6] + player2[8]
          a = replaceAndSortStr(str1)
          b = replaceAndSortStr(str2)
          if a > b
            count += 1
          end
        end
      end
      if player1Rank == 3
        #4个对子都不同,取决最大的对子

      end
      #一副扑克牌每张牌最多4张
      if player1Rank == 4
        maxNumber1 = getMaxNumber(player1, 3)
        maxNumber2 = getMaxNumber(player2, 3)
        if maxNumber1 > maxNumber2
          count += 1
        end
      end
      if player1Rank == 6
        suit1 = getCardSuit(player1)
        suit2 = getCardSuit(player1)
        if suit1 > suit2
          count += 1
        end
      end
      if player1Rank == 7
        maxNumber1 = getMaxNumber(player1, 3)
        maxNumber2 = getMaxNumber(player2, 3)
        if maxNumber1 > maxNumber2
          count += 1
        end
        if maxNumber1 == maxNumber2
          nextMaxNumber1 = getMaxNumber(player1, 2)
          nextMaxNumber2 = getMaxNumber(player1, 2)
          if nextMaxNumber1 > nextMaxNumber2
            count += 1
          end
        end
      end
      if player1Rank == 8
        maxNumber1 = getMaxNumber(player1, 4)
        maxNumber2 = getMaxNumber(player2, 4)
        if maxNumber1 > maxNumber2
          count += 1
        end
      end
    end
  end
  count
end

#p consecutiveVlaue '3231415161'
#p sameSuit 'T2J1Q1K1A1'
#p getRank '2151212151'
#countCarValue('rqerq')
p handleFile

