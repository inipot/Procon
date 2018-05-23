package usuario.app.procon;

public class Usuario {
    private Integer id;
    private String cpf,senha,email,confirmaSenha;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario(Integer id, String cpf, String email,String senha,String confirmaSenha) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
