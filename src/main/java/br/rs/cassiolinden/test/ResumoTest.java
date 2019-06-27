package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.core.DriverFactory;
import br.rs.cassiolinden.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	ResumoPage page = new ResumoPage();
	
	/*teste movido do MovimentacaoTest para c� ap�s corre��o do professor*/
	@Test
	public void removeMovimentacao() {
		page.abrirResumoMensal();
		page.removerMovimentacao();
		Assert.assertEquals("Movimenta��o removida com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void testResumoMensal() {
		page.abrirResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	}

}
