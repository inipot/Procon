package usuario.app.procon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfiguracoesFragment extends Fragment {


    public ConfiguracoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setToolbarTitle("Configurações");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_configuracoes);
        return inflater.inflate(R.layout.fragment_configuracoes, container, false);
    }

}
