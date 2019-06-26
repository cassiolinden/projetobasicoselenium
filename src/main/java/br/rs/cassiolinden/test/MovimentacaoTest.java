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
		page.setDescricao("Segunda movimentação incluída de forma automática");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setContaAddAuto();
		page.setSituacaoPago();
		page.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterTexto(By.xpath("//div[@class='alert alert-success']")));
	}
	
	@Test
	public void inserirMovimentacaoSemDataMov() {
		page.criarMovimentacao();
		page.salvar();
		Assert.assertEquals("Data da Movimentação é obrigatório", page.obterTexto(By.xpath("//div[@class='alert alert-danger']//li[.='Data da Movimentação é obrigatório']")));
	}
	
	@Test
	public void inserirMovimentacaoSemDataPag() {
//		Data do pagamento é obrigatório

	}
	
	@Test
	public void inserirMovimentacaoSemDescr() {
//		Descrição é obrigatório

	}
	
	@Test
	public void inserirMovimentacaoSemInteressado() {
//		Interessado é obrigatório

	}
	
	@Test
	public void inserirMovimentacaoSemValor() {
//		Valor é obrigatório

	}
	
	@Test
	public void inserirMovimentacaoValorIncorreto() {
//		Valor deve ser um número

	}
	
	@Test
	public void inserirMovimentacaoFutura() {
		
	}
	
	@Test
	public void removerMovimentacao() {
		
	}

}
