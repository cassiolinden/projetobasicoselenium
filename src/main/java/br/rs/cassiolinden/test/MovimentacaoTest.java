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
		page.setDescricao("Segunda movimentação incluída de forma automática");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta(Propriedades.NOME_CONTA_ALTERADA);
		page.setSituacaoPago();
		page.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", page.obterMensagemSucesso());
	}
	
	/*inserido após correção do professor*/
	@Test
	public void test2_testarTodosCamposObrigatorios() {
		page.clicarCriarMovimentacao();
		page.salvar();
		List<String> erros = page.obterErros();
		Assert.assertTrue(erros.containsAll(Arrays.asList(
				"Data da Movimentação é obrigatório",
				"Data do pagamento é obrigatório",
				"Descrição é obrigatório",
				"Interessado é obrigatório",
				"Valor é obrigatório",
				"Valor deve ser um número")));
		Assert.assertEquals(6, erros.size());
	}
	/*
	@Test
	public void inserirMovimentacaoSemDataMov() {
		page.clicarCriarMovimentacao();
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Segunda movimentação incluída de forma automática");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta("Conta editada de forma automática");
		page.setSituacaoPago();
		page.salvar();
		Assert.assertEquals("Data da Movimentação é obrigatório", page.obterMensagemErro());
	}
	
	@Test
	public void inserirMovimentacaoSemDataPag() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDescricao("Movimentação sem data de pagamento");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta("Conta editada de forma automática");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Data do pagamento é obrigatório", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoSemDescr() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta("Conta editada de forma automática");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Descrição é obrigatório", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoSemInteressado() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Movimentação sem interessado");
		page.setValor("1000");
		page.setConta("Conta editada de forma automática");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Interessado é obrigatório", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoSemValor() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao("26/06/2019");
		page.setDataPagamento("26/06/2019");
		page.setDescricao("Movimentação sem valor");
		page.setInteressado("Eu mesmo");
		page.setConta("Conta editada de forma automática");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Valor é obrigatório", page.obterMensagemErro());

	}
	
	@Test
	public void inserirMovimentacaoValorIncorreto() {
		page.clicarCriarMovimentacao();
		page.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		page.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		page.setDescricao("Movimentação com valor incorreto");
		page.setInteressado("Eu mesmo");
		page.setValor("eita");
		page.setConta("Conta editada de forma automática");
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Valor deve ser um número", page.obterMensagemErro());

	}
	
	*/
	@Test
	public void test3_inserirMovimentacaoFutura() {
		page.clicarCriarMovimentacao();
		
		/*método e classe criados após correção com o professor*/
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		
		page.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		page.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		page.setDescricao("Movimentação ");
		page.setInteressado("Eu mesmo");
		page.setValor("1000");
		page.setConta(Propriedades.NOME_CONTA_ALTERADA);
		page.setSituacaoPago(); 
		page.salvar();
		Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", page.obterMensagemErro());
		
	}

}
