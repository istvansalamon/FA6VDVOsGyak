// C Program for Message Queue (Reader Process)
#include <stdio.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <unistd.h>
#include <stdlib.h>
#include <math.h>



// structure for message queue
struct mesg_buffer {
	long mesg_type;
	char mesg_text[100];
    int a, b, c;
    double x1,x2;
} message, *ms;

double main()
{
	key_t key;
	int msgid;

	// ftok to generate unique key
	key = ftok("progfile", 65);

	// msgget creates a message queue
	// and returns identifier
	msgid = msgget(key, 0666 | IPC_CREAT);

	// msgrcv to receive message
	msgrcv(msgid, &message, sizeof(message), 1, 0);
    
    sscanf(message.mesg_text,"%d:%d:%d",&message.a,&message.b, &message.c);
    //message.a=atoi(message.mesg_text);
printf("Data Received is : %s \n",
					message.mesg_text);    

//printf("Data Received is : %d \n",*ms);
    double d;
    d = message.b * message.b - 4.0 * message.a * message.c;
    //printf("number d: %lf \n",d);    
    message.x1 = (-message.b + sqrt(d)) / (2.0 * message.a);
    message.x2 = (-message.b - sqrt(d)) / (2.0 * message.a);    
        printf("number x1: %lf \n",message.x1);
        printf("number x2: %lf \n",message.x2);
   

FILE* fp;
    fp = fopen("kimenet.txt", "w");  /* file-open, w = write */
    if (fp != NULL) {
        fprintf(fp,"equals: %lf %lf \n",message.x1,message.x2);

        fclose(fp);                 /* file-close */
    }
    else {
        perror("Nem sikerült megnyitni a fájlt");
    }
    


	// to dstroy the message queue
	msgctl(msgid, IPC_RMID, NULL);

	return 0;
}

