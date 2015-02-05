<?php
/**
 * Created by PhpStorm.
 * User: beibei
 * Date: 2015/1/27
 * Time: 17:06
 */
function main()
{
    for ($i = 1; $i < 1000000000; $i++) {
        for ($j = 1; $j <= 20; $j++) {
            if ($i % $j == 0) {
                if ($j == 20) {
                    return $i;
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
    }
    //如果没有找到，则返回空值.
    return null;
}

$start_time = microtime(true);
echo main();
$end_time = microtime(true);
$total = $end_time - $start_time;
echo "此php文件中代码执行了{$total}秒";
