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
		page.removerConta("Conta editada de forma autom�tica");
		Assert.assertEquals("Conta em uso na movimenta��es", page.obterMensagemErro());
	}

}
