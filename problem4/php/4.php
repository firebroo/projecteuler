<?php

function isPalindromicNumber($num)
{
    $result = (string)$num;
    if (strrev($result) == $result) {
        return 1;
    }
    return 0;
}

function palindromicNumberList()
{
    for ($i = 999 * 999; $i > 0; $i--) {
        if (isPalindromicNumber($i)) {
            $arr[] = $i;
        }
    }
    return $arr;
}

function largestPalindromicNumber()
{
    $lis = palindromicNumberList();
    for ($i = 1; $i < 999; $i++) {
        for ($j = 1; $j < 999; $j++) {
            $arr[] = $i * $j;
        }
    }
    foreach ($lis as $value) {
        if (in_array($value,$arr)) {
            return $value;
        }
    }
}

echo largestPalindromicNumber();
