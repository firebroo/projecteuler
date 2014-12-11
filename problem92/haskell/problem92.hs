toDigits :: Integer -> [Integer]
toDigits x = map (\x -> (toInteger . digitToInt) x) (show x)

squareDigit :: Integer -> Bool
squareDigit 1 = False
squareDigit 89 = True
squareDigit n = squareDigit $ foldl (+) 0 . map square $ toDigits n

calculateNumbers :: [Integer] -> Int
calculateNumbers x = length . filter (\x -> x) $ map squareDigit x
