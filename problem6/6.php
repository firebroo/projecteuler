<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/25
 * Time: 18:00
 */
$sum = 0;
$sum2 = 0;
for($i = 1; $i <= 100; $i++) {
    $sum += $i * $i;
    $sum2 += $i;
}
echo $sum2 * $sum2 - $sum;
