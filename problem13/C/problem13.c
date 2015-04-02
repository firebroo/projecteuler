/*
compile: GCC 4.8.2
author: firebroo
email: bianliqiang12@gmail.com
*/

#include<stdio.h>
#include<gmp.h>

int main() {
    FILE *fp;
    char buf[128];
    mpz_t rez, cnm;
    mpz_init(rez);
    mpz_init(cnm);
    mpz_set_ui(rez, 0);
    fp = fopen("./data.txt", "r");
    if(fp == NULL) {
        return 0;
    }
    while (fgets(buf, sizeof(buf), fp) != NULL) {
        mpz_set_str(cnm, buf, 0);
        mpz_add(rez, rez, cnm);
    }
    return gmp_printf("%Zd\n", rez);
}
