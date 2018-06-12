package usuario.app.procon;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FacaSuaReclamacaoFragment extends Fragment {

    private ReclamacaoController reclamacaoController;
    private Context context;

    public FacaSuaReclamacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setToolbarTitle("Faça sua reclamação");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_faca_reclamacao);
        View view =  inflater.inflate(R.layout.fragment_faca_sua_reclamacao, container, false);
        Button btRegistraReclamacao = (Button) view.findViewById(R.id.btRegistraReclamacao);
        final Spinner spAssunto = (Spinner) view.findViewById(R.id.spAssunto);
        final Spinner spDescricao = (Spinner) view.findViewById(R.id.spDescricao);
        final EditText edNotaFiscal = (EditText) view.findViewById(R.id.edNotaFiscal);
        final EditText edAcontecido = (EditText) view.findViewById(R.id.edAcontecido);

        btRegistraReclamacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cpf = ((MenuActivity) getActivity()).getCpf();
                Reclamacao reclamacao = new Reclamacao(null,cpf,spAssunto.getSelectedItem().toString(),
                        spDescricao.getSelectedItem().toString(),edNotaFiscal.getText().toString(),edAcontecido.getText().toString());
                reclamacaoController = ReclamacaoController.getInstance(context);
                Boolean validaEdNotaFiscal =  ValidaCampos.validateNotNull(edNotaFiscal,"Insira a nota fiscal");
                Boolean validaEdAcontecido = ValidaCampos.validateNotNull(edAcontecido,"Insira o registro da reclamação");
                if(validaEdAcontecido && validaEdNotaFiscal) {
                    try {
                        reclamacaoController.insert(reclamacao);
                        Toast.makeText(getActivity(), "Reclamação registrada com sucesso", Toast.LENGTH_SHORT).show();
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,new AcompanheSuasReclamacoesFragment()).addToBackStack(null).commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
