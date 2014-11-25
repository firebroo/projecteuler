prime = sieve [2..]         
sieve (x:xs) = x : sieve (filter (\y ->y `rem` x /= 0) xs)
sum $ takeWhile (\x -> x < 2000000) prime
