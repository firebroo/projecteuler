def count_change(amount):
    return cc(amount,8)

def cc(amount,kinds_of_coins):
    if amount == 0:
        return 1
    elif (amount < 0 or kinds_of_coins == 0):
        return 0
    else:
        return cc(amount,(kinds_of_coins - 1)) + cc(amount - first_denomination(kinds_of_coins),kinds_of_coins)

def first_denomination(kinds_of_coins):
    if kinds_of_coins == 1:
        return 1
    elif kinds_of_coins == 2:
        return 2
    elif kinds_of_coins == 3:
        return 5
    elif kinds_of_coins == 4:
        return 10
    elif kinds_of_coins == 5:
        return 20
    elif kinds_of_coins == 6:
        return 50
    elif kinds_of_coins == 7:
        return 100
    elif kinds_of_coins == 8:
        return 200
print count_change(200)
