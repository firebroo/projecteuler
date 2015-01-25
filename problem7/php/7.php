<?php
/**
 * Created by PhpStorm.
 * User: Administrator
 * Date: 2015/1/25
 * Time: 18:00
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

$count = 0;
for ($i = 2; $i < 1000000; $i++) {
   if (isPrime($i)) {
      $count += 1;
   }
   if ($count == 10001) {
      echo $i;
      break;
   }
}
