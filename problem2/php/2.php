<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/15
 * Time: 19:59
 */
$a = 1;
$b = 2;
$count = 0;
while ($a < 4000000) {
    if ($a % 2 == 0) {
        $count += $a;
    }
    $tmp = $a + $b;
    $a = $b;
    $b = $tmp;
}
echo $count;
