package usuario.app.procon;

import java.util.List;
import android.content.Context;

public class UsuarioController {
    private static BancoController bancoController;
    private static UsuarioController instance;
    UsuarioController teste;
    public static UsuarioController getInstance(Context context) {
        if (instance == null) {
            instance = new UsuarioController();
            bancoController = new BancoController(context);
        }
        return instance;
    }
    public String insert(Usuario usuario) throws Exception  {
        bancoController.insert(usuario);
        return "Conta criada com sucesso";
    }
    public void update(Usuario usuario) throws Exception {
    //    bancoController.update(usuario);
    }
    public List<Usuario> findAll() throws Exception {
        return bancoController.findAll();
    }
    public boolean validaLogin(String cpf, String senha) throws Exception {
        Usuario user = bancoController.findByLogin(cpf, senha);
        if (user == null || user.getCpf() == null || user.getSenha() == null) {
            return false;
        }
        String informado = cpf + senha;
        String esperado = user.getCpf() + user.getSenha();
        if (informado.equals(esperado)) {
            return true;
        }
        return false;
    }

    public boolean verificaCpf(String cpf)  {
        Usuario user = bancoController.findByCpf(cpf);
        if ( user == null || user.getCpf() == null) {
            return false;
        }
        return true;
    }

    public boolean verificaEmail(String email) {
        Usuario user = bancoController.findByEmail(email);
        if (user == null || user.getEmail() == null) {
            return false;
        }
        return true;
    }
}
