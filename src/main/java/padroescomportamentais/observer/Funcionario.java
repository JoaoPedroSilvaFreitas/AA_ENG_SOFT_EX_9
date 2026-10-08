package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void registrarFuncionario(PontoEletronico pontoEletronico) {
        pontoEletronico.addObserver(this);
    }

    public void update(Observable pontoEletronico, Object arg1) {
        this.ultimaNotificacao = this.nome + ", ponto registrado em " + pontoEletronico.toString();
    }
}
