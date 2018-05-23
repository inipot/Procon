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

    public Usuario findById(Integer id) {
        String sql = "SELECT * FROM " + banco.TABELA + " WHERE id = ?";
        String[] selectionArgs = new String[] { "" + id };
        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        cursor.moveToFirst();
        db.close();
        return montaUsuario(cursor);
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