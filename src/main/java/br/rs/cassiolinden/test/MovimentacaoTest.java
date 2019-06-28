package br.rs.cassiolinden.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.core.Propriedades;
import br.rs.cassiolinden.pages.MovimentacaoPage;
import br.rs.cassiolinden.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest{
	
	MovimentacaoPage page = new MovimentacaoPage();
	
	@Test
	public void test1_inserirMovimentacao() {
		page.clicarCriarMovimentacao();
		page.setTipoMovReceita();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Segunda movimenta��o inclu�da de forma autom�tica");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta(Propriedades.NOME_CONTA_ALTERADA);
		page.setSituacaoPago();
		page.salvar();
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", page.obterMensagemSucesso());
	}
	
	/*inserido ap�s corre��o do professor*/
	@Test
	public void test2_testarTodosCamposObrigatorios() {
		page.clicarCriarMovimentacao();
		page.salvar();
		List<String> erros = page.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimenta��o � obrigat�rio",
				"Data do pagamento � obrigat�rio",
				"Descri��o � obrigat�rio",
				"Interessado � obrigat�rio",
				"Valor � obrigat�rio",
				"Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
	}
	/*
	@Test
	public void inserirMovimentacaoSemDataMov() {
		page.clicarCriarMovimentacao();
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Segunda movimenta��o inclu�da de forma autom�tica");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta("Conta editada de forma autom�tica");
		page.setSituacaoPago();
		page.salvar();
		Assert.assertEquals("Data da Movimenta��o � obrigat�rio", page.obterMensagemErro());
	}
	
	@Test
	public void inserirMovimentacaoSemDataPag() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDescricao("Movimenta��o sem data de pagamento");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta("Conta editada de forma autom�tica");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Data do pagamento � obrigat�rio", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoSemDescr() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta("Conta editada de forma autom�tica");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Descri��o � obrigat�rio", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoSemInteressado() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Movimenta��o sem interessado");
		page.setValor("1000");
		page.setConta("Conta editada de forma autom�tica");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Interessado � obrigat�rio", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoSemValor() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Movimenta��o sem valor");
		page.setInteressado("Eu mesmo");
		page.setConta("Conta editada de forma autom�tica");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Valor � obrigat�rio", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoValorIncorreto() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		page.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		page.setDescricao("Movimenta��o com valor incorreto");
		page.setInteressado("Eu mesmo");
		page.setValor("eita");
		page.setConta("Conta editada de forma autom�tica");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Valor deve ser um n�mero", page.obterMensagemErro());

	}
	
	*/
	@Test
	public void test3_inserirMovimentacaoFutura() {
		page.clicarCriarMovimentacao();
		
		/*m�todo e classe criados ap�s corre��o com o professor*/
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		page.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		page.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		page.setDescricao("Movimenta��o ");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta(Propriedades.NOME_CONTA_ALTERADA);
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Data da Movimenta��o deve ser menor ou igual � data atual", page.obterMensagemErro());
		
	}

}
