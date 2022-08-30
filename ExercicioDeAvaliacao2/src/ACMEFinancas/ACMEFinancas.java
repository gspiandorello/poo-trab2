package ACMEFinancas;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEFinancas {
	Scanner in = new Scanner(System.in);
	private Cadastro cadastro;
	Cadastro c = new Cadastro();

	public void inicializa() {
		Veiculo JettaTSI = new Veiculo(1, "Volkswagen Jetta TSI", 120000.00, Veiculo.Classe.Esportivo);
		c.adiciona(JettaTSI);
		Veiculo GolfGTI2019 = new Veiculo(2, "Volkswagen Golf GTI", 144000, Veiculo.Classe.Esportivo);
		c.adiciona(GolfGTI2019);
		Veiculo GolfGTI2022 = new Veiculo(3, "Volkswagen Golf GTI", 168000, Veiculo.Classe.Esportivo);
		c.adiciona(GolfGTI2022);
		Veiculo HB20 = new Veiculo(4, "Hyundai HB20", 74000, Veiculo.Classe.Popular);
		c.adiciona(HB20);
		Veiculo Kwid = new Veiculo(5, "Renault Kwid", 59000, Veiculo.Classe.Basico);
		c.adiciona(Kwid);
		Servico Lavagem = new Servico(6, "Lavagem", 100, Servico.Tipo.Pessoal);
		c.adiciona(Lavagem);
		Servico LavagemCompleta = new Servico(7, "Lavagem", 200, Servico.Tipo.Pessoal);
		c.adiciona(LavagemCompleta);
		Servico TrocaOleo = new Servico(8, "Troca de Oleo", 60, Servico.Tipo.Pessoal);
		c.adiciona(TrocaOleo);
		Servico TrocaPneu = new Servico(9, "Troca de Pneu", 80, Servico.Tipo.Pessoal);
		c.adiciona(TrocaPneu);
		Servico HospedagemServidor = new Servico(10, "Hospedagem de Servidor", 300, Servico.Tipo.Empresarial);
		c.adiciona(HospedagemServidor);
		Servico CriacaoSite = new Servico(11, "Criacao de um Site", 1500, Servico.Tipo.Empresarial);
		c.adiciona(CriacaoSite);
	}

	public void executa() {
		String opcao;
		do {
			apresentaMenu();
			opcao = in.nextLine();
			switch(opcao) {
				case "0":
					break;
				case "1":
					int op=1;
					boolean verificaInt;
					do{
						do{
							verificaInt=true;
							System.out.println("Selecione o tipo de item cobrável que você deseja cadastrar");
							System.out.println("1 - Veículo");
							System.out.println("2 - Serviço");
							System.out.println("Opção desejada: ");
							try{
								op = in.nextInt();
							} catch (InputMismatchException e) {
								in.nextLine();
								verificaInt = false;
								System.out.println("Digite um número.");
							}
						}while(!verificaInt);
						if(op!=1 && op!=2){
							System.out.println("Escolha uma das opções disponíveis.");
						}
					}while(op!=1 && op!=2);
					if(op==1){
						int id=0, classe=0;
						double valorBase=0;
						String nome;
						do{
							do{
								verificaInt=true;
								System.out.println("Digite um número de 12 a 2000 para usar como identificador");
								try{
									id = in.nextInt();
								} catch (InputMismatchException e) {
									in.nextLine();
									verificaInt = false;
									System.out.println("Digite um número.");
								}
							}while(!verificaInt);
							if(c.verificaIdentificador(id)){
							break;
							}
							else if(id<1 || id>2000){
								System.out.println("Identificador inválido");
							}
							else{
								System.out.println("Item repetido.");
							}
						}while(!c.verificaIdentificador(id));
						System.out.println("Digite o nome do Veículo: ");
						in.nextLine();
						nome = in.nextLine();
						do{
							do{
								verificaInt=true;
								System.out.println("Digite o valor base do Veículo");
								try{
									valorBase = in.nextDouble();
								} catch (InputMismatchException e) {
									in.nextLine();
									verificaInt = false;
									System.out.println("Digite um número.");
								}
							}while(!verificaInt);
							if(valorBase<0){
								System.out.println("Digite um valor maior que 0.");
							}
						}while(valorBase<0);
						do{
							do{
								verificaInt=true;
								System.out.println("Escolhe a classe do Veículo: ");
								System.out.println("1 - Popular");
								System.out.println("2 - Basico");
								System.out.println("3 - Esportivo");
								System.out.println("Opção desejada: ");
								try{
									classe = in.nextInt();
								} catch (InputMismatchException e) {
									in.nextLine();
									verificaInt = false;
									System.out.println("Digite um número.");
								}
							}while(!verificaInt);
							if(classe!=1 && classe!=2 && classe!=3){
								System.out.println("Escolha uma das opções disponíveis.");
							}
						}while(classe!=1 && classe!=2 && classe!=3);
						if(classe==1){
							Veiculo v = new Veiculo(id, nome, valorBase, Veiculo.Classe.Popular);
							c.adiciona(v);
						}
						if(classe==2){
							Veiculo v = new Veiculo(id, nome, valorBase, Veiculo.Classe.Basico);
							c.adiciona(v);
						}
						if(classe==3){
							Veiculo v = new Veiculo(id, nome, valorBase, Veiculo.Classe.Esportivo);
							c.adiciona(v);
						}
					}
					else {
						int id=0, tipo=0;
						double valorBase=0;
						String nome;
						do{
							do{
								verificaInt=true;
								System.out.println("Digite um número de 12 a 2000 para usar como identificador");
								try{
									id = in.nextInt();
								} catch (InputMismatchException e) {
									in.nextLine();
									verificaInt = false;
									System.out.println("Digite um número.");
								}
							}while(!verificaInt);
							if(c.verificaIdentificador(id)){
								break;
							}
							else if(id<1 || id>2000){
								System.out.println("Identificador inválido");
							}
							else{
								System.out.println("Item repetido.");
							}
						}while(!c.verificaIdentificador(id));
						System.out.println("Digite o nome do Serviço: ");
						in.nextLine();
						nome = in.nextLine();
						do{
							do{
								verificaInt=true;
								System.out.println("Digite o valor base do Serviço");
								try{
									valorBase = in.nextDouble();
								} catch (InputMismatchException e) {
									in.nextLine();
									verificaInt = false;
									System.out.println("Digite um número.");
								}
							}while(!verificaInt);
							if(valorBase<0){
								System.out.println("Digite um valor maior que 0.");
							}
						}while(valorBase<0);
						do{
							do{
								verificaInt=true;
								System.out.println("Escolhe o tipo do Serviço: ");
								System.out.println("1 - Pessoal");
								System.out.println("2 - Empresarial");
								System.out.println("Opção desejada: ");
								try{
									tipo = in.nextInt();
								} catch (InputMismatchException e) {
									in.nextLine();
									verificaInt = false;
									System.out.println("Digite um número.");
								}
							}while(!verificaInt);
							if(tipo!=1 && tipo!=2){
								System.out.println("Escolha uma das opções disponíveis.");
							}
						}while(tipo!=1 && tipo!=2);
						if(tipo==1){
							Servico s = new Servico(id, nome, valorBase, Servico.Tipo.Pessoal);
							c.adiciona(s);
						}
						if(tipo==2){
							Servico s = new Servico(id, nome, valorBase, Servico.Tipo.Empresarial);
							c.adiciona(s);
						}
					}
					in.nextLine();
					break;
				case "2":
					if(c.pesquisa()==null){
						System.out.println("Nenhum item cadastrado.");
					}
					System.out.println(c.pesquisa());
					break;
				case "3":
					String nome;
					System.out.println("Digite o nome do item: ");
					nome = in.nextLine().toLowerCase();
					if(c.pesquisa(nome)==null){
						System.out.println("Nenhum item foi localizado com este nome.");
					}
					else{
						System.out.println(c.pesquisa(nome));
					}
					break;
				case "4":
					int id=0;
					do{
						verificaInt=true;
						System.out.println("Digite o identificador do item que você deseja calcular o imposto: ");
						try{
							id = in.nextInt();
						} catch (InputMismatchException e) {
							in.nextLine();
							verificaInt = false;
							System.out.println("Digite um número.");
						}
					}while(!verificaInt);
					if(c.calculaImpostoItem(id)==-1){
						System.out.println("Nenhum item foi localizado com este identificador.");
					}
					else{
						System.out.println(c.calculaImpostoItem(id));
					}
					in.nextLine();
					break;
				case "5":
					String nomeDoArquivo;
					System.out.println("Digite o nome do arquivo (sem extensão) para salvar os dados: ");
					nomeDoArquivo = in.nextLine();
					try{
						c.salvaArquivoTexto(nomeDoArquivo);
					} catch (Exception e){
						System.out.println("Ocorreu um erro.");
					}
					break;
				case "6":
					String nomeDoArquivoParaLer;
					System.out.println("Digite o nome do arquivo com extensão \".txt\" ou \".csv\" para ler os dados e cadastrar no sistema");
					System.out.println("Observação: seleciona a opção 2 do menu: Mostrar todas as informações do cadastro\n" +
									   "para verificar quais identificadores já foram usados, se o identificador do item\n" +
									   "já foi usado ele não será adicionado no sistema.");
					nomeDoArquivoParaLer = in.nextLine();
					try{
						c.leArquivoTexto(nomeDoArquivoParaLer);
					} catch (IOException e){
						System.out.println("Nenhum arquivo foi localizado com este nome.");
					}
					break;
				default:
					System.out.println();
					System.out.println("Opcao inválida! Redigite.");
			}
		} while(!opcao.equals("0"));
	}

	public void apresentaMenu() {
		System.out.println("===============MENU===============");
		System.out.println("Opcões: ");
		System.out.println("[0] Sair");
		System.out.println("[1] Cadastrar item cobrável");
		System.out.println("[2] Mostrar todas as informações do cadastro");
		System.out.println("[3] Pesquisar item por nome");
		System.out.println("[4] Calcular imposto de item");
		System.out.println("[5] Salvar arquivos de dados");
		System.out.println("[6] Carregar arquivo de dados");
		System.out.print("Opção desejada: ");
	}

}