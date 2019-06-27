package br.rs.cassiolinden.pages;

import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BasePage;

public class ContaPage extends BasePage{
	
	private void clicarMenuConta() {
		clicarBotao(By.xpath("//a[@class='dropdown-toggle']"));
	}
	
	public void clicarAdicionarConta() {
		clicarMenuConta();
		clicarBotao(By.xpath("//a[.='Adicionar']"));
	}
	
	public void clicarListarContas() {
		clicarMenuConta();
		clicarBotao(By.xpath("//a[.='Listar']"));
	}
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[@type='submit']"));
	}
	
	public void novaConta() {
		clicarBotao(By.xpath("//a[.='Novo usu�rio?']"));
	}
	
	public void clicarAlterarConta(String nomeAtual) {
		obterCelula("Conta", nomeAtual, "A��es", "tabelaContas").findElement(By.xpath(".//a//span[@class='glyphicon glyphicon-edit']")).click();
//		verificar mensagem ap�s edi��o
	}
	
	public void removerConta(String conta) {
		obterCelula("Conta", conta, "A��es", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
//		verificar mensagem ap�s exclus�o
	}
	
	/*adequa��o ao padr�o page objects explicado pelo professor*/
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	
	/*adequa��o ao padr�o page objects explicado pelo professor*/
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

}
