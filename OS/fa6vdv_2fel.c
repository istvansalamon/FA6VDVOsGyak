#include	<sys/types.h>
#include	<stdio.h>
#include	<stdlib.h>
#define N 100
#define ESC 27
#include <string.h>
#include <ctype.h>

void read(char*word);

int
main(void)
{
	int status;
        char word[N];
        int i;
	char word2[N];
       
      do {
       printf("Please type your command:");
       
       read(word);      
       system(word);
       
	}
	while(word!=word2);
	
	

}

void read(char*word){

int i=0;
char ch;
printf("  and press Enter\n");
while((ch=getchar())!='\n'){
word[i]=ch;
i++;
}

return;

}




