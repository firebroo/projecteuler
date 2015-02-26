def replaceAndSortStr(str)
  list = []
  number = 0
  str.each_char do |i|
    list.push(i)
  end
  list.sort!
  if list[4] == 'T'
    number = 10
  end
  if list[4] == 'J'
    number = 11
  end
  if list[4] == 'Q'
    number = 12
  end
  if list[4] == 'K'
    number = 13
  end
  if list[4] == 'A'
    number = 14
  end
  number
end

def countCarValue(str)
  dict = {}
  str = str[0] + str[2] + str[4] + str[6] + str[8]
  str.each_char do |i|
    if dict[i]
      dict[i] += 1
    else
      dict[i] = 1
    end
  end
  dict
end

def getMaxNumber(str)
  number = '0'
  dict = countCarValue(str)
  dict.each do |i,j|
    if j == 2
      number = i
    end
  end
  if number == 'T'
    number = 10
  end
  if number == 'J'
    number = 11
  end
  if number == 'Q'
    number = 12
  end
  if number == 'K'
    number = 13
  end
  if number == 'A'
    number = 14
  end
  number
end

def getRank(str)
  rank = 1
  if sameSuit(str) && consecutiveValue(str)
    rank = 9
    if str[0] == 'T'
      rank = 10
    end
    return rank
  end
  count = countCarValue(str)
  if count.values.include? 4
    rank = 8
    return rank
  end
  if count.values.include? 3 and count.values.include? 2
    rank = 7
    return rank
  end
  if sameSuit(str)
    rank = 6
    return rank
  end
  if consecutiveValue(str)
    rank = 5
    return rank
  end
  if count.values.include? 3
    rank = 4
    return rank
  end
  if count.values.include? 2 and count.values.length == 3
    rank = 3
    return rank
  end
  if count.values.include? 2
    rank = 2
    return rank
  end
  return rank
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
      if player1Rank == 1
        str1 = player1[0] + player1[2] + player1[4] + player1[6] + player1[8]
        str2 = player2[0] + player2[2] + player2[4] + player2[6] + player2[8]
        maxNumber1 = replaceAndSortStr(str1)
        maxNumber2 = replaceAndSortStr(str2)
        #print maxNumber1,"\t",str1,"\t",maxNumber2, "\t",str2,"\n"
        if maxNumber1.to_i > maxNumber2.to_i
          count += 1
        end
      end
      if player1Rank == 2
        maxNumber1 = getMaxNumber(player1)
        maxNumber2 = getMaxNumber(player2)
        if maxNumber1.to_i > maxNumber2.to_i
          count += 1
        end
      end
    end
  end
  count
end


def splitString(str)
  len = str.length
  rightStr = str[0, len/2]
  leftStr = str[len/2, len]
  return [rightStr, leftStr]
end

def sameSuit(str)
  if str[1] == str[3] && str[1]== str[5] &&str[1] == str[7] && str[1]== str[9]
    return true
  end
  return false
end

def consecutiveValue(str)
  cardValue = '23456789TJQKA'
  strSuite = str[0] + str[2] + str[4] + str[6] + str[8]
  if /#{strSuite}/ =~ cardValue
    return true
  end
  false
end

#p consecutiveVlaue '3231415161'
#p sameSuit 'T2J1Q1K1A1'
#p getRank '2151212151'
#countCarValue('rqerq')
p handleFile
