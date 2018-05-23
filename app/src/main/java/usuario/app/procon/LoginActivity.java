package usuario.app.procon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private Button btentrar,btregistrar;
    private EditText editcpf,editsenha;
    private Context context;
    UsuarioController usuarioController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btregistrar = findViewById(R.id.btregistralogin);
        btentrar = findViewById(R.id.btentrar);
        EditText cpf = findViewById(R.id.editcpflogin);
        cpf.addTextChangedListener(Mascara.insert("###.###.###-##",cpf));
        editsenha = findViewById(R.id.editsenhalogin);
        editcpf = findViewById(R.id.editcpflogin);


        btentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = LoginActivity.this;
                usuarioController = UsuarioController.getInstance(context);
                String senhaString = editsenha.getText().toString();
                String cpfString = editcpf.getText().toString();
                ValidaCampos.validateNotNull(editcpf,"Insira seu cpf");
                ValidaCampos.validateNotNull(editsenha,"Insira sua senha");
                try {
                    boolean isvalid = usuarioController.validaLogin(cpfString, senhaString);
                    if (isvalid) {
                            BancoController bancoController = new BancoController(context);
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            intent.putExtra("usuariocpf",cpfString);
                            intent.putExtra("usuarioemail",bancoController.retornarEmailPorCpf(cpfString));
                            startActivity(intent);
                            finish();

                    }
                    else
                        Toast.makeText(LoginActivity.this,"Usuario ou senha inválidos",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this,"Erro",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrarActivity.class));
            }
        });

    }
}
