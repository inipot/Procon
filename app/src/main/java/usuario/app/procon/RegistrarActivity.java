package usuario.app.procon;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class RegistrarActivity extends AppCompatActivity {


    private EditText editsenha, editconfirmasenha;
    private Context context;
    private UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Button btregistrar = findViewById(R.id.btregistrar);
        editsenha = findViewById(R.id.editsenha);
        editconfirmasenha = findViewById(R.id.editconfirmasenha);
        EditText cpf = findViewById(R.id.editcpf);
        cpf.addTextChangedListener(Mascara.insert("###.###.###-##",cpf));
        btregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = RegistrarActivity.this;
                usuarioController = UsuarioController.getInstance(context);
                EditText cpf =  findViewById(R.id.editcpf);
                EditText email = findViewById(R.id.editemail);
                EditText senha = findViewById(R.id.editsenha);
                EditText confirmaSenha = findViewById(R.id.editconfirmasenha);
                String cpfString = cpf.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String confirmaSenhaString = confirmaSenha.getText().toString();
                Usuario usuario = new Usuario(null,cpfString,emailString,senhaString,confirmaSenhaString);
                String resultado;

                ValidaCampos.validateNotNull(cpf,"Insira seu cpf");
                ValidaCampos.validateNotNull(email,"Insira seu email");
                ValidaCampos.validateNotNull(senha,"Insira sua senha");
                ValidaCampos.validateNotNull(confirmaSenha,"Confirme sua senha");

               /* if(!ValidaCampos.validateCPF(cpfString)){
                    cpf.setError("CPF inválido");
                    cpf.setFocusable(true);
                   cpf.requestFocus();
                } */
                if (usuarioController.verificaCpf(cpfString)) {
                        cpf.setError("Cpf já utilizado");
                        cpf.setFocusable(true);
                        cpf.requestFocus();
                    }

                    if (usuarioController.verificaEmail(emailString)) {
                        email.setError("Email já utilizado");
                        email.setFocusable(true);
                        email.requestFocus();
                    }

                if(!ValidaCampos.validateEmail(emailString)) {
                    email.setError("Email inválido");
                    email.setFocusable(true);
                    email.requestFocus();
                }

                if (ValidaCampos.validateNotNull(cpf,"Insira seu cpf") &&
                        ValidaCampos.validateNotNull(email,"Insira seu email") &&
                ValidaCampos.validateNotNull(senha,"Insira sua senha") &&
                ValidaCampos.validateNotNull(confirmaSenha,"Confirme sua senha")){

                    if(!ValidaCampos.validateSenha(senhaString,confirmaSenhaString)) {
                        Toast.makeText(RegistrarActivity.this, "Senhas não correspondem", Toast.LENGTH_SHORT).show();
                        editsenha.setText("");
                        editconfirmasenha.setText("");
                    }

                    else
                        try {
                            boolean isvalid = usuarioController.verificaCpf(cpfString);
                            if (!isvalid && !usuarioController.verificaEmail(emailString)) {
                                resultado = usuarioController.insert(usuario);
                                Toast.makeText(RegistrarActivity.this, resultado, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrarActivity.this, LoginActivity.class));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }
        });
    }

}
