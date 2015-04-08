/*
compile: GCC 4.8.2
author: firebroo
email: bianliqiang12@gmail.com
*/

#include<stdio.h>

int getCount(long num) {
	long length = 1;
	while (num != 1) {
		if(num % 2 == 0) {
			num = num / 2;
		}else {
			num = num * 3 + 1;
		}
		length += 1;
	}
	return length;
}

int main(void) {
	long key = 0;
	long value = 0;
	long length = 0;
	for(long i=1;i<1000000;i++) {
		length = getCount(i);
		if(length > value) {
			key = i;
			value = length;
		}
	}
	printf("%ld\t%ld\n", key, length);
	return 0;
}
