package br.rs.cassiolinden.pages;

import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BasePage;

public class HomePage extends BasePage {

	public void clicarHome() {
		clicarBotao(By.xpath("//a[.='Home']"));
	}
	
	public String obterSaldoConta(String nome) {
		return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
	}
}
