package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.ContaPage;

public class RemoverMovimentacaoContaTest extends BaseTest{
	ContaPage page = new ContaPage();
	
	@Test
	public void removerContaComMovimentacao() {
		page.clicarListarContas();
		page.removerConta("Conta com movimentacao");
		Assert.assertEquals("Conta em uso na movimentações", page.obterMensagemErro());
	}

}
