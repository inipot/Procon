package usuario.app.procon;

import android.content.Context;

public class ReclamacaoController {
    private static BancoController bancoController;
    private static ReclamacaoController instance;
    public static ReclamacaoController getInstance(Context context) {
        if (instance == null) {
            instance = new ReclamacaoController();
            bancoController = new BancoController(context);
        }
        return instance;
    }
    public String insert(Reclamacao reclamacao) throws Exception  {
        bancoController.insert(reclamacao);
        return "Reclamação registrada com sucesso";
    }



}
