package br.com.engnetconsultoria.tecpet;

import java.net.HttpUrlConnection;
import java.net.URL;

public class Conexao{
  public static String postDados(String urlUsuario, String parametrosUsuario){
    URL url;
    HttpURLConnection connection = null;
    
    try{
      url = new URL(urlUsuario);
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST"); 
    
      connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      
      connection.setRequestProperty("Content-Length", "" + Integer.toString(parametrosUsuario.getBytes().length));
      
      connection.setRequestProperty("Content-Lenguage", "pt-BR");
      
      connection.setUseCaches(false);
      connection.setDoInput(true);
      connection.setDoOutput(true);
      /*
      DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
      dataOutputStream.writeBytes(parametrosUsuario);
      dataOutputStream.flush();
      dataOutputStream.close();
      */
      
      OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
      outputStreamWriter.write(parametrosUsuario);
      outputStreamWriter.flush();
      
      InputStram inputStream = connection.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
      String linha;
      StringBuffer resposta = new StringBuffer();
      
      while((linha = bufferReader.readLine()) != null){
        resposta.append(linha);
        resposta.append('\r');
      }
      
      bufferedReader.close();
      
      return resposta.toString();
      
      
    }catch(Exception erro){
      return null;
    
    
    } finally{
      if(connection != null){
        connection.disconnect();
      }
    
    }
  
  }


}
