toDigits :: Integer -> [Integer]
toDigits x = map (\x -> (toInteger . digitToInt) x) (show x)

toString :: [Integer] -> String
toString x = foldl (++) "" $ map show x

main = toString . drop (2357207 - 10) $ toDigits $ 28433 * (2 ^ 7830457) + 1
