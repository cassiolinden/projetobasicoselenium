package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.core.DriverFactory;
import br.rs.cassiolinden.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	ResumoPage page = new ResumoPage();
	
	/*teste movido do MovimentacaoTest para cá após correção do professor*/
	@Test
	public void test1_removeMovimentacao() {
		page.abrirResumoMensal();
		page.removerMovimentacao();
		Assert.assertEquals("Movimentação removida com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void test2_testResumoMensal() {
		page.abrirResumoMensal();
		Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
	}
	
	@Test
	public void test3_verificarResumoVazio(){
		page.abrirResumoMensal();
		try {
			page.removerMovimentacao();
		}catch(NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
