--prime x = [i | i <- [1..x], x `mod` i == 0]
--isPrime x = (length $ prime x) == 2
--primeList = filter isPrime [1..]
prime = sieve [2..]         ---改进后的素数数列 
sieve (x:xs) = x : sieve (filter (\y ->y `rem` x /= 0) xs) 
prime !! 10000
