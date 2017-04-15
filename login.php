<?php
  include_once 'conexao.php';
  
  $email = $_POST['email'];
  $senha = $_POST['senha'];
  
  $sql = $dbcon->querry("SELECT * FROM usuarios WHERE email ='$email' AND senha='$senha'");
  
  if(mysql_num_rows($sql) > 0){
    echo "login_ok";
  }else{
    echo "login_erro";
  }
?>
