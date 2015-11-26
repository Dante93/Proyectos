#include <stdio.h> 
#include <stdlib.h> 
 
int main(void){ 
 
    int n = 0; 
    int i; 
    int resPar =0; 
    int resImp = 0; 
 
 
    printf("N = "); 
    scanf("%d",&n); 
    printf("\n"); 
     
     
     
    while(n <0){ 
        printf("El numero ingresado ha de ser positivo\n"); 
        printf("Ingrese otro valor :"); 
        scanf("%d",&n); 
    } 
     
    printf("Numeros impares: "); 
    for(i=0; i<=n;i++){ 
        if(i%2==0)resPar++; 
        else { 
            resImp++;printf("%d ",i); 
            } 
    } 
    printf("\n"); 
    printf("Total numeros pares = %d \n",resPar); 
    printf("Total numeros impares = %d",resImp); 
     
  
    return 0; 
} 