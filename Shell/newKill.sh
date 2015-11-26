#!/bin/bash 
#Creat per Kev 
 
nom_proc=$1 
 
#guardem a inf.txt els programes de nom "nom_proc" 
ps -ef | grep $nom_proc > inf.txt 
 
#Obtenim el pid que esta a la segon columna y el posem a pid.txt 
awk '{print $2}' inf.txt > pid.txt 
 
for line in $(cat pid.txt) 
do  
    echo "EliminanT procés $line... "  
 
    kill -9 $line 
done 