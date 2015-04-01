/*
compile: GCC 4.8.2
author: firebroo
email: bianliqiang12@gmail.com
*/

#include <math.h>
#include <stdio.h>

int isPrime(int num) {
	double tmp = (int)sqrt((double)num)+1;
	for(int i = 2; i < tmp; i++) {
		if(num % i == 0){
			return 0;
		}
	}
	return 1;
}

int main(void) {
	long result = 0;
	for(long i = 2; i < 2000000; i++) {
		if(isPrime(i)) {
			result += i;
		}
	}
	printf("%ld\n", result);
	return 0;
}

