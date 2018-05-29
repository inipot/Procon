package usuario.app.procon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FacaSuaReclamacaoFragment extends Fragment {


    public FacaSuaReclamacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setToolbarTitle("Faça sua reclamação");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_faca_reclamacao);
        return inflater.inflate(R.layout.fragment_faca_sua_reclamacao, container, false);
    }

}
