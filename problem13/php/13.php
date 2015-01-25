<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/25
 * Time: 20:23
 */
$content = file("./13.php.txt");
$result = 0;
foreach ($content as $value) {
    $result  = bcadd($result,$value);
}
echo substr($result,0,10);

