package ACMEFinancas;

public class Veiculo extends Cobravel {

    private Classe classe;

    public Veiculo(){

    }

    public Veiculo(int identificador, String nome, double valorBase, Classe classe) {
        super(identificador, nome, valorBase);
        this.classe = classe;
    }

    public enum Classe{
        Popular, Basico, Esportivo
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public double calculaImposto(){
        if(getClasse().equals(Classe.Popular)){
            double valorImposto;
            valorImposto = getValorBase()*0.05;
            return valorImposto;
        }
        if(getClasse().equals(Classe.Basico)){
            double valorImposto;
            valorImposto = getValorBase()*0.2;
            return valorImposto;
        }
        if(getClasse().equals(Classe.Esportivo)){
            double valorImposto;
            valorImposto = getValorBase()*0.5;
            return valorImposto;
        }
        return -1;
    }

    public String toCsv(){
        String v = "Veiculo;" + identificador + ";" + nome + ";" + valorBase + ";" + classe;
        return v;
    }

    @Override
    public String toString() {
        return "\nVeiculo{" +
                "Identificador = " + identificador +
                ", nome = '" + nome + '\'' +
                ", valor base = " + valorBase +
                ", classe = " + classe +
                ", valor do imposto = " + calculaImposto() +
                '}';
    }
}