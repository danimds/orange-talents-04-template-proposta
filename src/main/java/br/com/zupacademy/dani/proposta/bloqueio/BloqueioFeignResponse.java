package br.com.zupacademy.dani.proposta.bloqueio;

public class BloqueioFeignResponse {

    private ResultadoBloqueio resultadoBloqueio;


    @Deprecated
    public BloqueioFeignResponse() {
    }

    public ResultadoBloqueio getResultadoBloqueio() {
        return resultadoBloqueio;
    }

    public void setResultadoBloqueio(ResultadoBloqueio resultadoBloqueio) {
        this.resultadoBloqueio = resultadoBloqueio;
    }

    public boolean bloqueado() {
        if(this.resultadoBloqueio.equals(ResultadoBloqueio.BLOQUEADO))
            return true;
        return false;

    }
}
