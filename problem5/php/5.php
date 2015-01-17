<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/17
 * Time: 22:45
 */

function smallestMultiple($num)
{
    for ($i = 1; $i <= 20; $i++) {
        if ($num % $i == 0) {
            if ($i == 20) {
                return 1;
            } else {
                continue;
            }
        } else {
            break;
        }
    }
    return 0;
}

function main()
{
    for ($i = 1; $i < 1000000000; $i++) {
        if (smallestMultiple($i)) {
            return $i;
        }
    }
}

$start_time = microtime(true);
echo main();
$end_time = microtime(true);
$total = $end_time - $start_time;
echo "此php文件中代码执行了{$total}秒";
