package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.ContaPage;

public class ContaTest extends BaseTest{
	private ContaPage page = new ContaPage();
	
	@Test
	public void criarConta() {
		page.adicionarConta();
		page.setNome("Conta adicionada de forma automática");
		page.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", page.obterTexto(By.xpath("//div[@class='alert alert-success']")));
	}
	
	@Test
	public void alterarConta() {
		page.listarContas();
		page.editarConta("Conta adicionada de forma automática", "Conta editada de forma automática");
		page.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", page.obterTexto(By.xpath("//div[@class='alert alert-success']")));
	}
	
	@Test
	public void criarContaMesmoNome() {
		page.adicionarConta();
		page.setNome("Conta adicionada de forma automática");
		page.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", page.obterTexto(By.xpath("//div[@class='alert alert-danger']")));
	}	
}
