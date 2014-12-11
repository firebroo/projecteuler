fact :: (Eq a, Num a) => a -> a
fact 0  = 1
fact n  = n * fact (n - 1)

combinatorics :: Integral a => a -> a -> a
combinatorics x y = fact x `div` fact y `div` fact (x - y)

countNumber :: [Integer] -> Int
countNumber = sum . map (\y -> length . filter (\x -> x > 1000000) . map (combinatorics y) $ [1..y])
