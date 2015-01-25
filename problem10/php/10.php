<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/25
 * Time: 19:17
 */
function isPrime($num) {
    $high  = (int)sqrt($num);
    for ($i = 2; $i <= $high; $i++) {
        if (fmod($num,$i) == 0) {
            return 0;
        }
    }
    return 1;
}

$primeSum = 0;
for ($i = 2; $i < 2000000; $i++) {
   if (isPrime($i)) {
       $primeSum += $i;
   }
}
echo $primeSum;
