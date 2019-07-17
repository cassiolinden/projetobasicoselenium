package br.rs.cassiolinden.test;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		
//		solução do professor
		
//		minha solução (mais lenta)
		
//		try {
//			page.removerMovimentacao();
//			Assert.fail();
//		}catch(NoSuchElementException ex) {
//			System.out.println(ex.getMessage());
//		}
		
		page.selecionarAno("2016");
		page.buscar();
		List<WebElement> elementosEncontrados = DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		Assert.assertEquals(0, elementosEncontrados.size());
		
	}

}
