package conexioJavaPHP;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class Downloader {

	private static final int TAM_CARACTERS = 36;
	private static final int TAM_09 = 45;
	private static final int TAM_A = 292;
	private static final int TAM_B = 185;
	private static final int TAM_C = 298;
	private static final int TAM_D = 208;
	private static final int TAM_E = 544;
	private static final int TAM_F = 144;
	private static final int TAM_G = 102;
	private static final int TAM_H = 136;
	private static final int TAM_I = 88;
	private static final int TAM_J = 70;
	private static final int TAM_K = 56;
	private static final int TAM_L = 660;
	private static final int TAM_M = 273;
	private static final int TAM_N = 103;
	private static final int TAM_O = 72;
	private static final int TAM_P = 199;
	private static final int TAM_Q = 16;
	private static final int TAM_R = 126;
	private static final int TAM_S = 298;
	private static final int TAM_T = 434;
	private static final int TAM_U = 144;
	private static final int TAM_V = 78;
	private static final int TAM_W = 61;
	private static final int TAM_X = 4;
	private static final int TAM_Y = 28;
	private static final int TAM_Z = 21;
	
	private static String dirCar = "http://www.filmaffinity.com/es/allfilms_*_";
	private static String dir09 = "http://www.filmaffinity.com/es/allfilms_0-9_";
	
	private static String dirA = "http://www.filmaffinity.com/es/allfilms_A_";
	private static String dirB = "http://www.filmaffinity.com/es/allfilms_B_";
	private static String dirC = "http://www.filmaffinity.com/es/allfilms_C_";
	private static String dirD = "http://www.filmaffinity.com/es/allfilms_D_";
	private static String dirE = "http://www.filmaffinity.com/es/allfilms_E_";
	private static String dirF = "http://www.filmaffinity.com/es/allfilms_F_";
	private static String dirG = "http://www.filmaffinity.com/es/allfilms_G_";
	private static String dirH = "http://www.filmaffinity.com/es/allfilms_H_";
	private static String dirI = "http://www.filmaffinity.com/es/allfilms_I_";
	private static String dirJ = "http://www.filmaffinity.com/es/allfilms_J_";
	private static String dirK = "http://www.filmaffinity.com/es/allfilms_K_";
	private static String dirL = "http://www.filmaffinity.com/es/allfilms_L_";
	private static String dirM = "http://www.filmaffinity.com/es/allfilms_M_";
	private static String dirN = "http://www.filmaffinity.com/es/allfilms_N_";
	private static String dirO = "http://www.filmaffinity.com/es/allfilms_O_";
	private static String dirP = "http://www.filmaffinity.com/es/allfilms_P_";
	private static String dirQ = "http://www.filmaffinity.com/es/allfilms_Q_";
	private static String dirR = "http://www.filmaffinity.com/es/allfilms_R_";
	private static String dirS = "http://www.filmaffinity.com/es/allfilms_S_";
	private static String dirT = "http://www.filmaffinity.com/es/allfilms_T_";
	private static String dirU = "http://www.filmaffinity.com/es/allfilms_U_";
	private static String dirV = "http://www.filmaffinity.com/es/allfilms_V_";
	private static String dirW = "http://www.filmaffinity.com/es/allfilms_W_";
	private static String dirX = "http://www.filmaffinity.com/es/allfilms_X_";
	private static String dirY = "http://www.filmaffinity.com/es/allfilms_Y_";
	private static String dirZ = "http://www.filmaffinity.com/es/allfilms_Z_";
	
	
	private static String fin = ".html";
	
	
	private static String [] caracters = {"*","0-9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	public static String[] getLlistat()throws Exception{
		
		String res = "";
		
		for(int it=0;it<caracters.length;it++)
			switch(caracters[it]){
			
			case "*":
				res+= getURLS(TAM_CARACTERS,dirCar,fin);
				break;
				
			case "0-9":
				res+= getURLS(TAM_09,dir09,fin);
				break;	
				
			case "A":
				res+= getURLS(TAM_A,dirA,fin);
				break;
			
			case "B":
				res+= getURLS(TAM_B,dirB,fin);
				break;
				
			case "C":
				res+= getURLS(TAM_C,dirC,fin);
				break;
				
			case "D":
				res+= getURLS(TAM_D,dirD,fin);
				break;
				
			case "E":
				res+= getURLS(TAM_E,dirE,fin);
				break;
				
			case "F":
				res+= getURLS(TAM_F,dirF,fin);
				break;
				
			case "G":
				res+= getURLS(TAM_G,dirG,fin);
				break;
				
			case "H":
				res+= getURLS(TAM_H,dirH,fin);
				break;
				
			case "I":
				res+= getURLS(TAM_I,dirI,fin);
				break;
				
			case "J":
				res+= getURLS(TAM_J,dirJ,fin);
				break;
				
			case "K":
				res+= getURLS(TAM_K,dirK,fin);
				break;
				
			case "L":
				res+= getURLS(TAM_L,dirL,fin);
				break;
				
			case "M":
				res+= getURLS(TAM_M,dirM,fin);
				break;
				
			case "N":
				res+= getURLS(TAM_N,dirN,fin);
				break;
				
			case "O":
				res+= getURLS(TAM_O,dirO,fin);
				break;
				
			case "P":
				res+= getURLS(TAM_P,dirP,fin);
				break;
				
			case "Q":
				res+= getURLS(TAM_Q,dirQ,fin);
				break;
				
			case "R":
				res+= getURLS(TAM_R,dirR,fin);
				break;
				
			case "S":
				res+= getURLS(TAM_S,dirS,fin);
				break;
				
			case "T":
				res+= getURLS(TAM_T,dirT,fin);
				break;
				
			case "U":
				res+= getURLS(TAM_U,dirU,fin);
				break;
				
			case "V":
				res+= getURLS(TAM_V,dirV,fin);
				break;
				
			case "W":
				res+= getURLS(TAM_W,dirW,fin);
				break;
				
			case "X":
				res+= getURLS(TAM_X,dirX,fin);
				break;
				
			case "Y":
				res+= getURLS(TAM_Y,dirY,fin);
				break;
				
			case "Z":
				res+= getURLS(TAM_Z,dirZ,fin);
				break;
				
			}
		
		String [] informacio = res.split("\n");
		return informacio;
	}
	
	/**Metode que obte les URL de totes les pelicules */
	public static String getURLS(int tam,String dir,String fin)throws Exception{
		
		int i = 1;
		String result = "";
		BufferedReader br = null;

		while(i!=tam){
				
				URL url = new URL(dir+i+fin);

				
				try{
					 br = new BufferedReader(new InputStreamReader(url.openStream()));
						
				}catch(Exception e){
					e.printStackTrace();
				}
				
				String linia ="";
				String res = "";
				
				while((linia = br.readLine())!=null)
					res += linia +"\n";
				
				Pattern pelicula = Pattern.compile("<div class=\"mc-title\"><a href=\"(.*?)\">(.*?)</a>");
				Matcher encaja = pelicula.matcher(res);
				
				while(encaja.find()){
					
					result+= encaja.group(1)+"\n";
				}
				
				i++;
			}	
			
	return result;

}
	

	
	/** Metode que torna un array amb informacio de la pelicula donada la seua URL */
	public static String [] buscarPorURL (String direccio)throws Exception {
		BufferedReader in = null;

		URL url = new URL("http://www.filmaffinity.com"+direccio);
		try{
			 // Volcamos lo recibido al buffer
			  in = new BufferedReader(new InputStreamReader(url.openStream()));
			  
		}catch(IOException e){
			e.printStackTrace();
			}
		
		String linia;
		String res="";
		
		while ((linia = in.readLine()) != null) {
			     res += linia+"\n";
			}

		Pattern nom = Pattern.compile("<h1 id=\"main-title\"><a href=\"(.*?)\"><span itemprop=\"name\">(.*?)</span></a></h1>");
		Pattern gen = Pattern.compile("var agm_kv = \"genero=(.*?);");   
		Pattern dur = Pattern.compile("<dd>(.*?)&nbsp;min.</dd>"); 
		Pattern dir = Pattern.compile("<dd><a href=\"http://www.filmaffinity.com/es/search.php.stype=director&stext=(.*?)\">(.*?)</a></dd>"); 
		
		
		Matcher encaja0 = gen.matcher(res);
		Matcher encaja1 = dur.matcher(res);
		Matcher encaja2 = dir.matcher(res);
		Matcher encaja3 = nom.matcher(res);
		
		String nombre ="";
		String genere = "";
		String duracion="";
		String director="";
		
		if(encaja0.find()) genere = encaja0.group(1);
		if(encaja1.find()) duracion =encaja1.group(1)+" minutos";
		if(encaja2.find()) director = encaja2.group(1).replace("+", " ");
		if(encaja3.find()) nombre = encaja3.group(2);
		
		if(!genere.equalsIgnoreCase(""))
			genere = genere.substring(0,1).toUpperCase() + genere.substring(1,genere.length());
		
		if(genere.equalsIgnoreCase("cienciaficcion")) genere = "Ciencia Ficción";
		else if(genere.equalsIgnoreCase("cinenegro")) genere = "Cine Negro";
		
		String [] movieInfo = {nombre,genere,duracion,director};
		
		
		return movieInfo;
			
		}
	
	public static ArrayList<Pelicula> createPelicula1(String[] URLS)throws Exception{
		
		ArrayList<Pelicula> movieList = new ArrayList<Pelicula>();
		
		Pelicula p;
		String nombre ="";
		String genere = "";
		String duracion="";
		String director="";
		
		String[]dades = new String[3];
		for (int i = 0; i < URLS.length; i++)
			for(int j=0;j<dades.length;j+=4){
				
			dades = buscarPorURL(URLS[i]);
			
			nombre = dades[j];
			genere = dades[j+1];
			duracion = dades[j+2];
			director = dades[j+3];
			
			p = new Pelicula(nombre,genere,duracion,director);
			movieList.add(p);
		}
	
		return movieList;

	}

	
	
	public static ArrayList<Pelicula> txtToMovie(String path){
		
		ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
		
		FileReader fr = null;
		BufferedReader br = null;
		String res = "";
		Pelicula p;
		
		try{
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String linia = "";
			
			while((linia = br.readLine())!=null){
				
				res +=linia+"\n";	
			}
		}catch(IOException ex){
			ex.printStackTrace();
			}
		
		String[] infoPeli = res.split("\n");
		for(int i = 0;i<infoPeli.length;i+=4){
			
			String nombre= infoPeli[i];
			String genere = infoPeli[i+1];
			String duracio = infoPeli[i+2];
			String director = infoPeli[i+3];
			
			p = new Pelicula(nombre,genere,duracio,director);
			lista.add(p);
			
			
		}
		
		return lista;
	}


	/** Metode per a obtindre la declaracio de les strings
	 * que contenen les URL
	 * @return
	 */
	public static String lazzyString(){
		String res = "";
	
		for(int i=65;i <91; i++)
		
			res+="private static String dir"+(char)i+" = \"http://www.filmaffinity.com/es/allfilms_"+(char)i+"_\";"+"\n";
	
		return res;
		
	
	}

	/** Metode per a obtindre les strings del
	 * codi que pertany al CASE del SWITCH
	 * @return
	 */
	public static String lazzySwitch(){
	
		String res = "";
	
		for(int i=65;i <91; i++)
		
			res+= "case \""+(char)i+"\":\n"+(char)(i+32)+" = getURLS(TAM_"+(char)i+",dir"+(char)i+",fin)\n break;\n";
	
	
		return res;
	
	}



public static void main(String[] args)throws Exception{
		
		//String[] listaURLS = Downloader.getLlistat();
		
		ArrayList<Pelicula> listaP = txtToMovie("C:\\Users\\kevin\\Documents\\MoviesInfo2.txt");
		
		Gson gson = new Gson();
		String jsonListaP = gson.toJson(listaP);

		
		URL url;
	    HttpURLConnection connection = null;  
        String jsonOutput = URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(jsonListaP, "UTF-8");

	    try {
	      //Create connection
	      url = new URL("http://kevinfva.esy.es/deco.php");
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", 
	           "application/x-www-form-urlencoded");
				
	      connection.setRequestProperty("Content-Length", "" + 
	               Integer.toString(jsonOutput.getBytes().length));
	      connection.setRequestProperty("Content-Language", "en-US");  
				
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
	      wr.writeBytes (jsonOutput);
	      wr.flush ();
	      wr.close ();

	      //Get Response	
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      System.out.println(response.toString());

	    } catch (Exception e) {

	      e.printStackTrace();

	    } finally {

	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }

}

}
