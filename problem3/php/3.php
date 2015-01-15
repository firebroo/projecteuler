<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/15
 * Time: 20:04
 */
function isPrime($num)
{
    $high = (intval(sqrt($num)));
    for ($i = 2; $i <= $high; $i++) {
        if ($num % $i == 0) {
            return false;
        }
    }
    return true;
}

function primeList()
{
    $result = array();
    for ($i = 2; $i < 10000; $i++) {
        if (isPrime($i)) {
            $result[] = $i;
        }
    }
    return $result;
}

function largestPrime($result, $num)
{
    foreach ($result as $value) {
        if (fmod($num,$value) == 0) {
            if (isPrime($num)) {
                return $num;
            }
            return largestPrime($result, $num / $value);
        }
    }
}

$result = primeList();
echo largestPrime($result, 600851475143);
