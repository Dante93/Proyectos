#include <stdio.h> 
#include <stdlib.h> 
 
int main(void){ 
 
    // a<= x <= b 
    int a,b,i; 
     
     
    printf("Introduce el valor de a: "); 
    scanf("%d",&a); 
     
    printf("Introduce el valor de b: "); 
    scanf("%d",&b); 
     
    // Nos aseguramos que a<=b 
     
    while(a>b){ 
        printf("Introduce un valor de a tal que a <= b: "); 
        scanf("%d",&a); 
    } 
     
    for(i = a; i<=b;i++){ 
        if(i%2!=0) printf("%d ",i*2); 
         
    } 
    return 0; 
     
} 