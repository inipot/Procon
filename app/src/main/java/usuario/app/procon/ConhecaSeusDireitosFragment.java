package usuario.app.procon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ConhecaSeusDireitosFragment extends Fragment {

    public ConhecaSeusDireitosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MenuActivity) getActivity()).setToolbarTitle("Conheça seus direitos");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_conheca_seus_direitos);
        return inflater.inflate(R.layout.fragment_conheca_seus_direitos, container, false);
    }

}
