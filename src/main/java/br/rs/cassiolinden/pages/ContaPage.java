package br.rs.cassiolinden.pages;

import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BasePage;

public class ContaPage extends BasePage{
	
	private void clicarMenuConta() {
		clicarBotao(By.xpath("//a[@class='dropdown-toggle']"));
	}
	
	public void adicionarConta() {
		clicarMenuConta();
		clicarBotao(By.xpath("//a[.='Adicionar']"));
	}
	
	public void listarContas() {
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
		clicarBotao(By.xpath("//a[.='Novo usuário?']"));
	}
	public void editarConta(String nomeAtual, String nomeNovo) {
		clicarBotaoEditTabela("Conta", nomeAtual, "Ações", "tabelaContas");
		escrever("nome", nomeNovo);
	}

}
