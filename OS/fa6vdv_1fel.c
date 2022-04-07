#include	<sys/types.h>
#include	<sys/wait.h>
#include	<stdio.h>
#include	<stdlib.h>
#include  <unistd.h>

int main(void)
{
	int	status;

    status = system("echo $HOME");
    if (WIFEXITED(status))
		printf("normal, number = %d\n\n",
				WEXITSTATUS(status));
	else 
	if (WIFSIGNALED(status))
		printf("Abnormal, serial = %d\n",
				WTERMSIG(status));
    
    status = system("unknow");
    if (WIFEXITED(status))
		printf("Normal, number = %d\n\n",
				WEXITSTATUS(status));
	else 
	if (WIFSIGNALED(status))
		printf("Abnormal, serial = %d\n",
				WTERMSIG(status));

	exit(0);
}



