#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {

    char *path ="ls";  
    char *arg1 ="/home";
    int  status,pid,ppid,gpid;


    ppid =getpid(); /*szulo pidjet elkaptuk*/
    pid =fork();
    if (pid == 0)
    { /*innen gyerek process*/

        printf("\n gyerek pid = %d\n", getpid());
        status = execl("/home/istvan/c/child2",path,arg1,NULL);
        if (status == -1)
        {
                perror ("szulo execl bukott");
                exit(-1);
        }

}
        /*innen szulo*/
        printf("\n %d.sz.szulo var a %d.sz.gyerekre.\n",ppid,pid );
        if( pid!= wait(&status)) perror("szulo-varakozasi hiba");
 
}









