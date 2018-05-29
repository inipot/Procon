package usuario.app.procon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcompanheSuasReclamacoesFragment extends Fragment {


    public AcompanheSuasReclamacoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setToolbarTitle("Acompanhe suas reclamações");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_acompanha_reclamacao);
        return inflater.inflate(R.layout.fragment_acompanhe_suas_reclamacoes, container, false);
    }

}
