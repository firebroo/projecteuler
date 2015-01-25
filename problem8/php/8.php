<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/25
 * Time: 18:19
 */
function handle_file($file)
{
    $a = file($file);
    $result = "";
    foreach ($a as $content) {
        $result .= trim($content, "\r\n");
    }
    return $result;
}

function digit_mul($string)
{
    $mul = 1;
    for ($j = 0; $j < strlen($string); $j++) {
        $mul *= intval($string{$j});
    }
    return $mul;
}

$result = handle_file("./1.txt");
$max = 0;
for ($i = 0; $i < strlen($result) - 13; $i++) {
    $sub_string = substr($result, $i, 13);
    $mul = digit_mul($sub_string);
    $max = $mul > $max ? $mul : $max;
}
echo $max;

