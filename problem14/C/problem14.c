/*
compile: GCC 4.8.2
author: firebroo
email: bianliqiang12@gmail.com
*/


#include<stdio.h>
#include<math.h>

int problem12(void) {
	int tmp = 1;
	for(int i=2;i<10000000;i++) {
		tmp += i;
		int count = 0;
		int tmp2 = ((int)sqrt((double)tmp)) + 1;
		for(int j=1; j<tmp2;j++) {
			if (tmp%j==0){
				count += 1;
			}
		}
		if (count >= 250) {
			return tmp;
		}
	}
	return tmp;
}

int main(void) {
	int result = problem12();
	printf("%d\n", result);
	return 0;
}

