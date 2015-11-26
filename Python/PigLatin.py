# -*- encoding: utf-8 -*-
__author__ = 'kevin'
 
# Vocals a tindre en compte
VOCALS = 'aeiouyAEIOUY'
#Simbols a tindre en compte
SIMBOLOS = [',', ';', '.', '?', '!', ':']
 
#En cas que  la paraula duga associat un simbol
#nos devuelve su indice. Si no, False
def find_symbol(word):
    index = 0
    for char in word:
        if char in SIMBOLOS:
            index = word.find(char)
            return index
 
    trobat = False
    return trobat
 
#Retorna l'index de la primera vocal
def primera_vocal(word):
    index = 0
    for char in word:
            if char not in VOCALS:
                index += 1
            else:
                return index
 
def piglatin(word):
    #Obtenim una llista on cada posició es un paraula
    wordList = word.split()
    letras = []
    index = 0
 
    for word in wordList:
        #Si la primera es vocal
        if word[0] in VOCALS:
            #Busquem l'index del simbol
            smb = find_symbol(word)
            if not smb:
                new = word + 'ay'
                letras.append(new)
                res = ' '.join(letras)
                return res
            else:
                new = word[:smb] + 'ay' + word[-1]
                letras.append(new)
                res = ' '.join(letras)
                return res
 
        #Si la primera es consonant
        if word[0] not in VOCALS:
 
            #Busquem l'index del simbol
            smb = find_symbol(word)
            #Busquem l'index de la primera vocal
            index = primera_vocal(word)
 
            if not smb:
                new = word[index:] + word[:index] + 'yay'
                if word.isupper():
                    new = new.upper()
                letras.append(new)
                res = ' '.join(letras)
                return res
 
 
            else:
                new = word[index:smb] + word[:index]+'yay' + word[-1]
                if word.isupper():
                    new = new.upper()
 
                if word[0].isupper():
                    new = new.capitalize()
 
                letras.append(new)
                res = ' '.join(letras)
                return res
#print letras
 
 
if __name__=='__main__':
 
    # Traducimos
    inp = raw_input('Introduce una frase:\n')
    while inp:
 
        # Separamos las palabras
        for word in inp.split(' '):
            print piglatin(word),
        print ''
 
        # Preguntem  més paraules
        inp = raw_input('')