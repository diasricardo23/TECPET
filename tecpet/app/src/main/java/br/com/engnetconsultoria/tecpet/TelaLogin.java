package br.com.engnetconsultoria.tecpet;

import android.os.Bundle;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class TelaLogin extends AppCompatActivity {
   
  EditText editEmail1, editSenha1;
  Button btnLogar;
  TextView txtCadastro;
  
  String url = "";
  String parametrosUsuario = "";  
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tela_login);
    
    editEmail1 = (EditText)findViewById(R.id.editEmail1); 
    editSenha1 = (EditText)findViewById(R.id.editSenha1);
    btnLogar = (Button)findViewById(R.id.btnLogar);
    txtCadastro = (TextView)findViewById(R.id.txtCadastro);
    
    
    //botão logar
    btnLogar.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo(); 
        
        if(networkInfo != null && networkInfo.isConnected()){
         //codigo
          
          String email = editEmail1.getText().toString();
          String senha = editSenha1.getText().toString();
          
          if(email.isEmpty() || senha.isEmpty()){
            Toast.makeText(getApplicationContext(), "Nenhum campo pode estar vazio.", Toast.LENGTH_LONG).show();
          }else{
            url = "http://localhost/login/login.php";
            
            parametros = "email="+ email + "&senha=" + senha;
            
            new SolicitaDados().execute(url);
          }
        }else{
          //erro ao conectar
          Toast.makeText(getApplicationContext(), "Nenhuma aplicação foi detectada.", Toast.LENGTH_LONG).show();
        }
      
      
      
      }                         
    });
    
    }
  
  
    private class SolicitaDados extends AsyncTasc<String, Void, String> {
     @Override
      protected String doInBackground(String... urls){
           return Conexao.postDados(urls[0], parametros );
      }
      
     @Override
      protected void onPostExecute(String resultad0){
         if(resultado.contains("login_ok")){
          Intent abreInicio = new Intent(TelaLogin.this, TecPet.class);
          startActivity(abreInicio);
         }else{
           Toast.makeText(getApplicationContext(), "Usuário ou senha incorretos.", Toast.LENGTH_LONG).show();
         }
      }
    }
  
  @Override
  protected void onPause(){
    super.onPause();
    finish(); 
  }
}


