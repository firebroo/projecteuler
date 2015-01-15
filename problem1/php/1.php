<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/9
 * Time: 12:39
 */
$count = 0;
for ($i = 0; $i < 1000; $i++) {
    if ($i % 3 == 0 || $i % 5 == 0) {
        $count += $i;
    }
}
echo $count;
