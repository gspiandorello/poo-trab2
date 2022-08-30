package ACMEFinancas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cadastro {
	private ArrayList<Cobravel> cobraveis = new ArrayList<Cobravel>();

	public boolean adiciona(Cobravel item) {
		cobraveis.add(item);
		return true;
	}

	public ArrayList pesquisa(String nome) {
		ArrayList<Cobravel> temporario = new ArrayList<Cobravel>();
		for(int i=0; i<cobraveis.size(); i++){
			Cobravel cobravel = cobraveis.get(i);
			if(cobravel.getNome().toLowerCase().equals(nome)){
				temporario.add(cobravel);
			}
		}
		if(temporario.isEmpty()){
			return null;
		}
		return temporario;
	}

	public ArrayList pesquisa() {
		if(cobraveis.isEmpty()){
			return null;
		}
		return cobraveis;
	}

	public double calculaImpostoItem(int identificador) {
		for(int i=0; i<cobraveis.size(); i++){
			Cobravel cobravel = cobraveis.get(i);
			if(cobravel.getIdentificador()==identificador){
				return cobravel.calculaImposto();
			}
		}
		return -1;
	}

	public void salvaArquivoTexto(String nomeArquivo) throws IOException{
		Path path = Paths.get(nomeArquivo+".csv");
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));
			for (Cobravel cobravel : cobraveis) {
				pw.println(cobravel.toCsv());
			}
		pw.close();
	}

    public void leArquivoTexto(String nomeArquivo) throws IOException{
        Path path = Paths.get(nomeArquivo);
		BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset());
        String line = null;
		while(!Objects.equals(line = reader.readLine(), null)){
			String[] temp = line.split(";");
			String item = temp[0];
			String id = temp[1];
			String nomeDoItem = temp[2];
			String valorBaseDoItem = temp[3];
			String classeOuTipo = temp[4];
			if(item.contains("Veiculo")){
				if(verificaIdentificador(Integer.parseInt(id))){
					if(classeOuTipo.contains("Popular")){
						Veiculo veiculo = new Veiculo(Integer.parseInt(id), nomeDoItem, Double.parseDouble(valorBaseDoItem), Veiculo.Classe.Popular);
						adiciona(veiculo);
					}
					else if(classeOuTipo.contains("Basico")){
						Veiculo veiculo = new Veiculo(Integer.parseInt(id), nomeDoItem, Double.parseDouble(valorBaseDoItem), Veiculo.Classe.Basico);
						adiciona(veiculo);
					}
					else if(classeOuTipo.contains("Esportivo")){
						Veiculo veiculo = new Veiculo(Integer.parseInt(id), nomeDoItem, Double.parseDouble(valorBaseDoItem), Veiculo.Classe.Esportivo);
						adiciona(veiculo);
					}
				}
			}
			else if(item.contains("Servico")){
				if(verificaIdentificador(Integer.parseInt(id))){
					if(classeOuTipo.contains("Pessoal")){
						Servico servico = new Servico(Integer.parseInt(id), nomeDoItem, Double.parseDouble(valorBaseDoItem), Servico.Tipo.Pessoal);
						adiciona(servico);
					}
					else if(classeOuTipo.contains("Empresarial")){
						Servico servico = new Servico(Integer.parseInt(id), nomeDoItem, Double.parseDouble(valorBaseDoItem), Servico.Tipo.Empresarial);
						adiciona(servico);
					}
				}
			}
		}
    }

	public boolean verificaIdentificador(int id){
		if(id<12 || id>2000){
			return false;
		}
		for(int i=0; i<cobraveis.size(); i++){
			Cobravel cobravel = cobraveis.get(i);
			if(cobravel.getIdentificador()==id){
				return false;
			}
		}
		return true;
	}
}