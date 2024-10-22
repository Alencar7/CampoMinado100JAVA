package cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
    //codigo encapsulado
    private final int linha;
    private final int coluna;

    private boolean aberto = false;
    private boolean minado = false;
    private boolean marcado = false;

    private List<Campo> vizinhos = new ArrayList<>();
    private List<CampoObservador> observadores
            = new ArrayList<>();
    //com INTERFACE FUNCIONAL fica:
    //private List<BiConsumer<Campo, CampoEvento>> observadores2 = new ArrayList<>();

    Campo(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public void registrarObservador(CampoObservador observador){
        observadores.add(observador);
    }

    private void notificarObservadores(CampoEvento evento){
        observadores.stream().forEach(o -> o.eventoOcorreu(this, evento));
    }

    boolean adcionarVizinho(Campo vizinho){

        boolean linhaDiferente = linha != vizinho.linha;
        boolean colunaDiferente = coluna != vizinho.coluna;
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(linha - vizinho.linha);
        int deltaColuna = Math.abs(coluna - vizinho.coluna);
        int deltaGeral = deltaColuna + deltaLinha;

        //adicionar vizinho
        if (deltaGeral == 1 && !diagonal){
            vizinhos.add(vizinho);
            return true;
        } else if(deltaGeral == 2 && diagonal) {
            vizinhos.add(vizinho);
            return true;
        } else {
            return false;
        }
    }

    public void alternarMarcacao(){
        if (!aberto){
            marcado = !marcado;

            if (marcado){
                notificarObservadores(CampoEvento.MARCAR);
            } else {
                notificarObservadores(CampoEvento.DESMARCAR);
            }
        }
    }

    public boolean abrir(){

        if (!aberto && !marcado){
            if (minado) {
                notificarObservadores(CampoEvento.EXPLODIR);
                return true; //acabou o jogo
            }
            setAberto(true);

            if (vizinhancaSegura()){
                vizinhos.forEach(v -> v.abrir());
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean vizinhancaSegura() {
        return vizinhos.stream().noneMatch(v -> v.minado); // true? = nenhunm viz esta minado
    }

    void minar(){
        minado = true;
    }

    public boolean isMinado(){
        return minado;
    }

    public boolean isMarcado() { //funciona como um get()
        return marcado;
    }

    //implementacao de explosao
     void setAberto(boolean aberto) {
        this.aberto = aberto;

        if (aberto) {
            notificarObservadores(CampoEvento.ABRIR);
        }
    }

    public boolean isAberto() {
        return aberto;
    }

    public boolean isFechado() {
        return !isAberto();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    boolean objetivoAlcancado() {
        boolean desvendado = !minado && aberto;
        boolean protegido = minado && marcado;
        return desvendado || protegido;
    }

    //quantidade de minas na vinzinhanca
    public int minasNaVizinhanca() {
        return (int) vizinhos.stream().filter(v -> v.minado).count();
    }

    //reiniciar o jogo - resetar tudo
    void reiniciar(){
        aberto = false;
        minado = false;
        marcado = false;
        notificarObservadores(CampoEvento.REINICIAR);
    }





}