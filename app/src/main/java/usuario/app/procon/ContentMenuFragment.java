package usuario.app.procon;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentMenuFragment extends Fragment  {

    public ContentMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_inicio);
        ((MenuActivity) getActivity()).setToolbarTitle("Procon");
        View view = inflater.inflate(R.layout.fragment_content_menu,container,false);
        Button btconhecaseusdireitos = (Button) view.findViewById(R.id.btconhecaseusdireitos);
        Button btpostosatendimento = (Button) view.findViewById(R.id.btpostosatendimento);
        Button btfacareclamacao = (Button) view.findViewById(R.id.btfacasuareclamacao);
        Button btacompanhareclamacao = (Button) view.findViewById(R.id.btacompanhereclamacao);
        btconhecaseusdireitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,new ConhecaSeusDireitosFragment()).addToBackStack(null).commit();
            }
        });

        btpostosatendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,new PostosAtendimentoFragment()).addToBackStack(null).commit();

            }
        });

        btfacareclamacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,new FacaSuaReclamacaoFragment()).addToBackStack(null).commit();
            }
        });

        btacompanhareclamacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MenuActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,new AcompanheSuasReclamacoesFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }
}


