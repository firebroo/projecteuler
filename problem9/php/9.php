<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/25
 * Time: 19:07
 */
for ($i = 1; $i < 2000; $i++) {
    for ($j = 1; $j < 2000; $j++) {
        $tmp = sqrt($i * $i + $j * $j);
        if ($tmp + $i + $j == 1000) {
            echo $i * $j * $tmp;
            exit;
        }
    }
}
