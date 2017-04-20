package apresentacao;



import javax.swing.JOptionPane;

import cliente.Cliente;
import execoes.ClienteInvalidoException;
import execoes.ClienteJaCadastradoException;
import execoes.ContaInvalidaException;
import execoes.ContaJaCadastradaException;
import execoes.SaldoInsuficenteException;


public class Banco {
	
	public static void main(String[] args){
		// MVC PRADÃo 
		FachadadoBanco fachada = new FachadadoBanco();
		
		int opcao = 0;
		
		while(opcao != 14){
			try{
				
				opcao = Integer.parseInt(JOptionPane.showInputDialog("1 -Cadastar Cliente.\n"
						+ "2 -Lista Cliente.\n"
						+ "3 - Atualizar Dados de Cliente.\n"
						+ "4 - Abrir Conta Corrente.\n"
						+ "5 - Abrir Conta Poupança.\n"
						+ "6 - Abrir Conta Bonificada. \n"
						+ "7 - Consultar Saldo.\n"
						+ "8 - Realizar Saque.\n"
						+ "9 - Realizar Deposito.\n"
						+ "10 - Realizar Transferencia.\n"
						+ "11 - Render Juros. \n"
						+ "12 - Render Bônus. \n"
						+ "13 - Encerrar Conta. \n"
						+ "14 - Finalizar Sistema. "));
				
				switch(opcao){
				
				case 1:
					JOptionPane.showConfirmDialog(null,"Para Cadastrar um clinte informe:"
							+ " CPF , NOME e DATA DE NASCIMENTO");
					String cpf = JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					String nome = JOptionPane.showInputDialog("Digite o Nome do CLiente.");
					String dataNasc = JOptionPane.showInputDialog("Digite a data de nascimento do Cliente");
					
					try {
						fachada.cadastrarCliente(cpf, nome, dataNasc);
						JOptionPane.showConfirmDialog(null, "Cliente Cadastrado. ");
						
					}catch(ClienteJaCadastradoException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					
					
					break;
					
				case 2:
					
					fachada.listarCliente();
					
					break;
				case 3:
				
					JOptionPane.showConfirmDialog(null, "Alterar Cliente.");
					String cpf3 = JOptionPane.showInputDialog("Digite o cpf do Cliente Que deseja Alterar.");
					String nome3 = JOptionPane.showInputDialog("Digite o Novo Nome.");
					String dataNasc3 = JOptionPane.showInputDialog("Digite a nova data de nascimento do ");
						
					try {
						fachada.alterarCliente(cpf3, nome3, dataNasc3);
						JOptionPane.showConfirmDialog(null, "Cliente Alterado com Sucesso!!. ");
						
					}catch(ClienteInvalidoException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					
					break;
				case 4:
					String cpf4= JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					double valor =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor."));
					
					Cliente titular  = fachada.consultaCliente(cpf4);
					
					fachada.inserirConta(titular, valor);
					break;
				case 5:
					
					String cpf5= JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					double valor5 =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de abertura da conta."));
					
					Cliente titular5  = fachada.consultaCliente(cpf5);
					fachada.inserirContaPoupanca(titular5, valor5);
					break;
				case 6:

					String cpf6= JOptionPane.showInputDialog("Digite o cpf do Cliente.");
					double valor6 =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de abertura da conta."));
					
					Cliente titular6  = fachada.consultaCliente(cpf6);
					
					fachada.inserirContaBonificada(titular6, valor6);
					break;
					
				case 7:
				
					int numConta7 =Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta ."));
					
					try {
						fachada.consultaSaldoConta(numConta7);		
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					break;
				case 8:
					
					int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta ."));
					double valor8  =Double.parseDouble(JOptionPane.showInputDialog("Digite valor ."));
					
					try {
						fachada.realizarSaque(numConta,valor8);
						
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}catch(SaldoInsuficenteException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
					}
					break;
				case 9:
					int numConta9 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta ."));
					double valor9  =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de deposito ."));
					
					try {
						fachada.realizarDeposito(numConta9,valor9);
						
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					break;
				case 10:
					int numConta10 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta 1 ."));
					int numConta20 = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta 2."));
					double valor10  =Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da transferencia ."));
					try {
						fachada.realizarTransferencia(numConta10,numConta20,valor10);
						
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}catch(SaldoInsuficenteException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
					}
					break;
				case 13:
					
					int numConta13 =Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta ."));
					
					try {
						fachada.removerConta(numConta13);		
					}catch(ContaInvalidaException e){
						JOptionPane.showConfirmDialog(null, e.getMessage());
						
					}
					break;
					
				default:
					break;
				
				}
				
				
			} catch (Exception e){
			
				e.printStackTrace();
				System.out.println("");
			}
		}
		
	}

}
