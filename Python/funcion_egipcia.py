import math
def funcion_egipcia(x,y):
	res = []
	while x!=0:
		aux = math.ceil(y/float(x))
		result.append(aux)
		x,y = -y%x, y*aux
	return res

print funcion_egipcia(7,15)
