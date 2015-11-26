import java.util.Scanner; 
import java.util.StringTokenizer; 
 
 
public class Palindromo { 
     
     
    public static void main(String[] args) { 
         
        Scanner sc = new Scanner(System.in); 
        String cadSinBlancos =""; 
        String cadInv =""; 
         
         
         
        System.out.print("Ingrese la frase: "); 
        String cad = sc.nextLine(); 
        sc.close(); 
         
        String cadAux = eliminaAcentos(cad.toLowerCase()); 
         
        // Eliminamos los espacios en blanco 
        StringTokenizer st = new StringTokenizer(cadAux); 
        while (st.hasMoreElements()) 
          cadSinBlancos += st.nextElement(); 
         
         
         
        //Invertimos la cadSinBlancos 
        for(int i=cadSinBlancos.length()-1;i>=0;i--) 
        cadInv = cadInv + cadSinBlancos.charAt(i); 
         
         
         
        //Comparamos si son iguales 
        if(cadSinBlancos.equals(cadInv)) System.out.println("La cadena introducica es un palindromo"); 
        else System.out.println("La cadena introducida no es un palindromo"); 
 
    } 
     
    public static String eliminaAcentos(String conAcentos) { 
         
     
        // Cadena de caracteres original. 
        String cadOr = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑ,."; 
        // Cadena  que reemplazarán los originales. 
        String cadRe = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUN  "; 
        String sinAcentos = conAcentos; 
         
        for(int i = 0; i<cadOr.length();i++) 
            sinAcentos = sinAcentos.replace(cadOr.charAt(i),cadRe.charAt(i)); 
         
        return sinAcentos; 
         
    } 
     
} 