fact :: (Eq a, Num a) => a -> a
fact 1 = 1
fact x = x * fact (x - 1)

toDigits :: Integer -> [Integer]
toDigits x = map (\x -> (toInteger . digitToInt) x) (show x)

foldr (\x y -> x + y) 0 (toDigits . fact $ 100)
