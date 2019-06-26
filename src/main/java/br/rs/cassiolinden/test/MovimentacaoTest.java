package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest{
	
	MovimentacaoPage page = new MovimentacaoPage();
	
	@Test
	public void inserirMovimentacao() {
		page.criarMovimentacao();
		page.setTipoMovReceita();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Segunda movimenta��o inclu�da de forma autom�tica");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setContaAddAuto();
		page.setSituacaoPago();
		page.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", page.obterTexto(By.xpath("//div[@class='alert alert-success']")));
	}
	
	@Test
	public void inserirMovimentacaoSemDataMov() {
		page.criarMovimentacao();
		page.salvar();
		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", page.obterTexto(By.xpath("//div[@class='alert alert-danger']//li[.='Data da Movimenta��o � obrigat�rio']")));
	}
	
	@Test
	public void inserirMovimentacaoSemDataPag() {
//		Data do pagamento � obrigat�rio

	}
	
	@Test
	public void inserirMovimentacaoSemDescr() {
//		Descri��o � obrigat�rio

	}
	
	@Test
	public void inserirMovimentacaoSemInteressado() {
//		Interessado � obrigat�rio

	}
	
	@Test
	public void inserirMovimentacaoSemValor() {
//		Valor � obrigat�rio

	}
	
	@Test
	public void inserirMovimentacaoValorIncorreto() {
//		Valor deve ser um n�mero

	}
	
	@Test
	public void inserirMovimentacaoFutura() {
		
	}
	
	@Test
	public void removerMovimentacao() {
		
	}

}
