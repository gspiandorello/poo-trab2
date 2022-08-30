package ACMEFinancas;

public class Servico extends Cobravel {

    private Tipo tipo;

    public Servico() {

    }

    public Servico(int identificador, String nome, double valorBase, Tipo tipo) {
        super(identificador, nome, valorBase);
        this.tipo = tipo;
    }

    public enum Tipo{
        Pessoal, Empresarial
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double calculaImposto(){
        if(getTipo().equals(Tipo.Pessoal)){
            double valorImposto;
            valorImposto = getValorBase()*0.15;
            return valorImposto;
        }
        if(getTipo().equals(Tipo.Empresarial)){
            double valorImposto;
            valorImposto = getValorBase()*0.3;
            return valorImposto;
        }
        return -1;
    }

    public String toCsv(){
        String s = "Servico;" + identificador + ";" + nome + ";" + valorBase + ";" + tipo;
        return s;
    }

    @Override
    public String toString() {
        return "\nServico{" +
                "Identificador = " + identificador +
                ", nome = '" + nome + '\'' +
                ", valor base = " + valorBase +
                ", tipo = " + tipo +
                ", valor do imposto = " + calculaImposto() +
                '}';
    }
}