package br.com.zupacademy.dani.proposta.analisecartao;

public class AnaliseRestricaoResponse {

    private String documento;
    private String nome;
    private RetornoRestricao resultadoSolicitacao;
    private Long idProposta;

    public AnaliseRestricaoResponse(String documento, String nome, RetornoRestricao resultadoSolicitacao, Long idProposta) {
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
        this.idProposta = idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public RetornoRestricao getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

    public Long getIdProposta() {
        return idProposta;
    }
}