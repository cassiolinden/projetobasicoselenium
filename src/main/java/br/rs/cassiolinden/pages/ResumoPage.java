package br.rs.cassiolinden.pages;

import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BasePage;

public class ResumoPage extends BasePage {

	public void abrirResumoMensal() {
		clicarBotao(By.xpath("//a[contains(text(),'Resumo Mensal')]"));
	}
	
	public void removerMovimentacao() {
//		obterCelula("Descri��o", movimentacao, "A��es", "tabelaExtrato").findElement(By.xpath(".//a//span[@class='glyphicon glyphicon-remove']")).click();
		clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove']"));
	}
	
	/*adequa��o ao padr�o page objects explicado pelo professor*/
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

}
