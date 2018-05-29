package usuario.app.procon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PostosAtendimentoFragment extends Fragment {

    public PostosAtendimentoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setToolbarTitle("Postos de atendimento");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_postos_atendimento);
        return inflater.inflate(R.layout.fragment_postos_atendimento, container, false);
    }

}
