package usuario.app.procon;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracoesFragment extends Fragment {
    UsuarioController usuarioController;
    Context context;
    public ConfiguracoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_configuracoes, container, false);
         Button btAtualizarCadastro = view.findViewById(R.id.btAtualizarCadastro);
        ((MenuActivity) getActivity()).setToolbarTitle("Configurações");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_configuracoes);
        final EditText email = view.findViewById(R.id.edEmailConfiguracoes);
        final EditText senha = view.findViewById(R.id.edNovaSenhaConfiguracoes);
        final EditText confirmaSenha = view.findViewById(R.id.edConfirmaNovaSenhaConfiguracoes);
        final EditText emailUsuario = view.findViewById(R.id.textmenu2);
        btAtualizarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuarioController = UsuarioController.getInstance(context);
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String confirmaSenhaString = confirmaSenha.getText().toString();
                Usuario usuario = new Usuario(null, ((MenuActivity) getActivity()).getCpf(), emailString, senhaString, confirmaSenhaString);
                if (usuarioController.verificaEmail(emailString)) {
                    email.setError("Email já utilizado");
                    email.setFocusable(true);
                    email.requestFocus();
                }
                    else if (!ValidaCampos.validateSenha(senhaString, confirmaSenhaString)) {
                        senha.setText("");
                        confirmaSenha.setText("");
                        Toast.makeText(context, "Senhas não correspondem", Toast.LENGTH_SHORT).show();
                    }
                    else
                    try {
                        if (!usuarioController.verificaEmail(emailString)) {
                            String resultado = usuarioController.update(usuario);
                            Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();
                            String emailUsuarioString = emailUsuario.toString();
                            emailUsuario.setText(emailUsuarioString);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }
}
