package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import java.time.LocalDate; 

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {
    
    @Test
    void deveNotificarUmfuncionario() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario = new Funcionario("funcionario 1");
        funcionario.registrarFuncionario(pontoEletronico);
        pontoEletronico.lancarHorario();
        assertEquals("funcionario 1, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario.getUltimaNotificacao());
    }


    @Test
    void deveNotificarfuncionarios() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario1 = new Funcionario("funcionario 1");
        Funcionario funcionario2 = new Funcionario("funcionario 2");
        funcionario1.registrarFuncionario(pontoEletronico);
        funcionario2.registrarFuncionario(pontoEletronico);
        pontoEletronico.lancarHorario();
        assertEquals("funcionario 1, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario1.getUltimaNotificacao());
        assertEquals("funcionario 2, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarfuncionario() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario = new Funcionario("funcionario 1");
        pontoEletronico.lancarHorario();
        assertEquals(null, funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarfuncionariopontoEletronicoA() {
        PontoEletronico pontoEletronicoA = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        PontoEletronico pontoEletronicoB = new PontoEletronico("Juiz de Fora - MG, Rua das Dores");
        Funcionario funcionario1 = new Funcionario("funcionario 1");
        Funcionario funcionario2 = new Funcionario("funcionario 2");
        funcionario1.registrarFuncionario(pontoEletronicoA);
        funcionario2.registrarFuncionario(pontoEletronicoB);
        pontoEletronicoA.lancarHorario();
        assertEquals("funcionario 1, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario1.getUltimaNotificacao());
        assertEquals(null, funcionario2.getUltimaNotificacao());
    }
}