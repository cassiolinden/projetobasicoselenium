package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.ContaPage;

public class ContaTest extends BaseTest{
	private ContaPage page = new ContaPage();
	
	@Test
	public void test1_criarConta() {
		page.clicarAdicionarConta();
		page.setNome("Conta adicionada de forma autom�tica");
		page.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void test2_alterarConta() {
		page.clicarListarContas();
		page.clicarAlterarConta("Conta para alterar");
		page.setNome("Conta alterada");
		page.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void test3_criarContaMesmoNome() {
		page.clicarAdicionarConta();
		page.setNome("Conta mesmo nome");
		page.salvar();
		Assert.assertEquals("J� existe uma conta com esse nome!", page.obterMensagemErro());
	}
}
