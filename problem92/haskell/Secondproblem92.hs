import qualified Data.Map as Map

toDigits :: Integer -> [Integer]
toDigits x = map (\x -> (toInteger . digitToInt) x) (show x)

convert :: Integer -> Integer
convert x = sum . map square . toDigits $ x

zipp :: [Integer] -> [(Integer, Bool)]
zipp x = zip x $ map squareDigit x

look :: Integer -> Maybe Bool
look y = Map.lookup y $ Map.fromList $ zipp [1..567]

test :: [Integer] -> [Maybe Bool]
test x = map look . map convert $ x

main = length [x | x <- (test [1..100000]),x == Just True]
