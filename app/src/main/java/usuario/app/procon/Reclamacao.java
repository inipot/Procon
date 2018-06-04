package usuario.app.procon;

public class Reclamacao {
    private Integer id;
    private String cpf,assunto,descricao,notaFiscal,registro;

    public Reclamacao(Integer id, String cpf, String assunto, String descricao, String notaFiscal, String registro) {
        this.id = id;
        this.cpf = cpf;
        this.assunto = assunto;
        this.descricao = descricao;
        this.notaFiscal = notaFiscal;
        this.registro = registro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
