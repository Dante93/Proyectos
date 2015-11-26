# -*- coding: utf-8 -*-
from collections import Counter
import unicodedata
 
SIMBOLOS = [',', ';', '.', '?', '!', ':', '¿', ':', '¡', '\'', '[', ']']
 
def elimina_tildes(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))
 
def get_stopWords(path):
    listaStop = []
    f = open(path)
    linea = f.readline()
    while linea != '':
        listaStop += linea.lower().split()
        linea = f.readline()
    return listaStop
 
 
def cuentaPalabras(archivo,stop):
    #variables que necesitaremos
    numL = 0
    contador = 0
    contaSinStop = 0
    listaPalabras = []
    listaPalabrasSinStop=[]
    letras = []
    #obtenemos una lista con todos los stop words
    listaStopWords = get_stopWords(stop)
    listaStopWrds = list(set(listaStopWords))
    # Abrimos el archivo a leer
    f = open(archivo)
    # Lectura completa de 1 linea
    dato = f.readline()
    # mientras no llegue a una linea en blanco, voy leyendo
    while dato != '':
        # anadimos las palabras de la linea a una lista
        listaPalabras += dato.lower().split()
        numL += 1
        dato = f.readline()
  
    f.close()
    #Limpiamos las palabras de simbolos
    for word in listaPalabras:
        for char in word:
            if char in SIMBOLOS:
                word = word.replace(char, '')
                char = char.replace(char, '')
            letras.append(char)
            listaPalabras[contador] = listaPalabras[contador].replace(listaPalabras[contador], word)
        contador += 1
  
        if word not in listaStopWords:
            listaPalabrasSinStop.append(word)
  
    contador = 0
    for word in listaPalabrasSinStop:
        for char in word:
            if char in SIMBOLOS:
                word = word.replace(char, '')
                listaPalabrasSinStop[contador] = listaPalabrasSinStop[contador].replace(listaPalabrasSinStop[contador], word)
        contador += 1
 
    #eliminamos letras repetidas
    letrasD = list(set(letras))
    listaElementosDistintos = list(set(listaPalabras))
  
    print 'Numero de letras distintas:', len(letrasD)
    print '\n'
    print 'El archivo con stop_words tiene', numL, 'lineas'
    print '\n'
    print 'El archivo sin stop_words tiene', contaSinStop, 'lineas'
    print '\n'
    print 'Numero de palabras distintas(con stopwords):', len(listaElementosDistintos)
    print '\n'
    print 'Numero de palabras distintas(sin stopwords):', len(list(set(listaPalabrasSinStop)))
    print '\n'
  
    x = [[x, listaPalabras.count(x)] for x in set(listaPalabras)]
    x.sort()
    print 'Palabras que aparecen en el texto(ordenadas alfabéticamente) con sus ocurrencias:\n', x
  
    print '\n'
  
    y = [[y, letras.count(y)] for y in set(letras)]
    y.sort()
    print 'Letras que aparecen en el texto(ordenadas alfabéticamente) con sus ocurrencias:\n', y
  
    print '\n'
  
    revP = [[listaPalabras.count(revP), revP] for revP in set(listaPalabras)]
    revP.sort()
    print 'Palabras que aparecen en el texto(ordenadas por ocurrencia) con sus ocurrencias:\n', revP
  
    print '\n'
  
    revL = [[letras.count(revL), revL] for revL in set(letras)]
    revL.sort()
    print 'Letras que aparecen en el texto(ordenadas por ocurrencia):\n', revL
  
if __name__ == '__main__':
    # Traducimos
    inp = raw_input('Introduce una el nombre del fichero a analizar y el fichero de stop words:\n')
    inp = inp.split(' ')
    cuentaPalabras(inp[0],inp[1])