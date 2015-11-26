@author: Kev 
''' 
 
 
def olimpiadasRusas(n): 
    a="" 
    seq = 206788 
    for i in range(seq+1): 
        x = str(i) 
        a = a + x 
     
    s = 'Elemento ' + str(n) + ' = ' + str(a[n])     
    print s 
    return 
        
      
n = raw_input('Ingresa n: ') 
n=int(n) 
olimpiadasRusas(n)  
print "Ejecucin Terminada" 