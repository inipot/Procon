package usuario.app.procon;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class AcompanheSuasReclamacoesFragment extends Fragment {

    private Context context;
    private CursorAdapter dataSource;
    private static final String campos []   = {"assunto","descricao","nota_fiscal","registro","_id"};
    public AcompanheSuasReclamacoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_acompanhe_suas_reclamacoes,container,false);
        ((MenuActivity) getActivity()).setToolbarTitle("Acompanhe suas reclamações");
        ((MenuActivity) getActivity()).setCheckedNavView(R.id.nav_acompanha_reclamacao);
        BancoController bancoController = new BancoController(context);
        Cursor cursor = bancoController.selectAll(((MenuActivity) getActivity()).getCpf());
        ListView listView;
        listView = view.findViewById(R.id.listReclamacao);
        if(cursor.getCount() > 0){
            dataSource = new SimpleCursorAdapter(context,R.layout.model_faca_sua_reclamacao,cursor,campos,
                    new int[]{R.id.edModelAssunto,R.id.edModelDescricao,R.id.edModelNotaFiscal,R.id.edModelAcontecido});
             listView.setAdapter(dataSource);
        }
        else {
            Toast.makeText(context, "Nenhuma reclamação encontrada", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.testelayout3,new FacaSuaReclamacaoFragment()).addToBackStack(null).commit();
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }
}
