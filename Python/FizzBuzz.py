
@author: Kev 
''' 
 
 
 
def fizzBuzz(): 
     
    for i in range(1,101): 
          
        if i == 35 or i == 53: 
            print "FizzBuzz" 
             
        elif i%3 == 0 and i%5 == 0: 
            print "FizzBuzz" 
             
        elif i%3 == 0: 
            print "Fizz" 
             
        elif i%5 == 0: 
            print "Buzz" 
             
        else: print i 
         
        
    return 
 
fizzBuzz() 
print("Ejecucion Terminada") 