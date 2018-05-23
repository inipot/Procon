package usuario.app.procon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = " contas ";
    public static final String ID = "id";
    public static final String CPF = "cpf";
    public static final String EMAIL = "email";
    public static final String SENHA = "senha";
    public static final String CONFIRMASENHA = "confirmaSenha";
    public static final int VERSAO = 1 ;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + CPF + " text,"
                + EMAIL + " text,"
                + SENHA + " text,"
                + CONFIRMASENHA + " text"
                +")";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
