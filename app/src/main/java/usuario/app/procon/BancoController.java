package usuario.app.procon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;


public class BancoController {

    private static SQLiteDatabase db;
    private static CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public void insert(Usuario usuario) throws Exception {
        ContentValues values = new ContentValues();
        values.put("cpf", usuario.getCpf());
        values.put("email",usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("confirmaSenha",usuario.getConfirmaSenha());
        db = banco.getWritableDatabase();
        db.insert(banco.TABELA, null, values);
        db.close();
    }

    public void insert(Reclamacao reclamacao) throws Exception {
        ContentValues values = new ContentValues();
        values.put("cpfreclamacoes", reclamacao.getCpf());
        values.put("assunto",reclamacao.getAssunto());
        values.put("descricao", reclamacao.getDescricao());
        values.put("nota_fiscal",reclamacao.getNotaFiscal());
        values.put("registro",reclamacao.getRegistro());
        db = banco.getWritableDatabase();
        db.insert(banco.TABELA2, null, values);
        db.close();
    }

    public void update(Usuario usuario) throws Exception {
        ContentValues values = new ContentValues();
        values.put("cpf", usuario.getCpf());
        values.put("email",usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("confirmaSenha",usuario.getConfirmaSenha());
        db = banco.getWritableDatabase();
        String [] params = {usuario.getCpf()};
        db.update(banco.TABELA, values, "cpf = ?",params);
        db.close();
    }
    public List<Usuario> findAll() throws Exception {
        List<Usuario> retorno = new ArrayList<>();
        String sql = "SELECT * FROM " + banco.TABELA;
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            retorno.add(montaUsuario(cursor));
            cursor.moveToNext();
        }
        db.close();
        return retorno;
    }

    public List<Reclamacao> findAllReclamacao() {
        List<Reclamacao> retorno = new ArrayList<>();
        Cursor cursor;
        String sql = "SELECT * FROM " + banco.TABELA2;
        db = banco.getReadableDatabase();
        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            retorno.add(montaReclamacao(cursor));
            cursor.moveToNext();
        }
        db.close();
        return retorno;
    }

    public Cursor selectAll(String cpf){
       String campos []   = {"cpfreclamacoes","assunto","descricao","nota_fiscal","registro","_id"};
       String [] selectionArgs = new String[] {"" + cpf};
       db = banco.getReadableDatabase();
       Cursor cursor =  db.query("reclamacoes",campos,"cpfreclamacoes =?",selectionArgs,null,null,null,null);

        return cursor;
    }


    public Usuario montaUsuario(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }
        Integer id = cursor.getInt(cursor.getColumnIndex("id"));
        String cpf = cursor.getString(cursor.getColumnIndex("cpf"));
        String email = cursor.getString(cursor.getColumnIndex("email"));
        String senha = cursor.getString(cursor.getColumnIndex("senha"));
        String confirmaSenha = cursor.getString(cursor.getColumnIndex("confirmaSenha"));
        return new Usuario(id, cpf, email, senha, confirmaSenha);
    }

    public Reclamacao montaReclamacao(Cursor cursor) {
        if (cursor.getCount() == 0) {
            return null;
        }
        Integer id = cursor.getInt(cursor.getColumnIndex("id"));
        String cpf = cursor.getString(cursor.getColumnIndex("cpfreclamacoes"));
        String assunto = cursor.getString(cursor.getColumnIndex("assunto"));
        String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
        String notaFiscal = cursor.getString(cursor.getColumnIndex("nota_fiscal"));
        String registro = cursor.getString(cursor.getColumnIndex("registro"));


        return new Reclamacao( id, cpf, cpf, descricao, notaFiscal, registro);
    }

    public Usuario findByLogin(String cpf, String senha) throws Exception {
        String sql = "SELECT * FROM " + banco.TABELA + " WHERE cpf = ?AND senha = ?";
        String[] selectionArgs = new String[] {cpf,senha};
        db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();
        db.close();
        return montaUsuario(cursor);
    }

    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM " + banco.TABELA + " WHERE email = ?";
        String[] selectionArgs = new String[] { email };
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();
        db.close();
        return montaUsuario(cursor);
    }

    public Usuario findByCpf(String cpf) {
        String sql = "SELECT * FROM " + banco.TABELA + " WHERE cpf = ?";
        String[] selectionArgs = new String[] { cpf };
        db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();
        db.close();
        return montaUsuario(cursor);
    }

    public String retornarEmailPorCpf(String cpf) {
        String sql = "SELECT email FROM " + banco.TABELA + " WHERE cpf = ?";
        String[] selectionArgs = new String[] { cpf };
        db = banco.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        StringBuilder stringBuilder = new StringBuilder();
        cursor.moveToFirst();
        String email = cursor.getString(cursor.getColumnIndex("email"));
        stringBuilder.append(email);
        cursor.close();
        db.close();
        return stringBuilder.toString();
    }

}