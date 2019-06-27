package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.ContaPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		page.clicarAlterarConta("Conta adicionada de forma autom�tica");
		page.setNome("Conta editada de forma autom�tica");
		page.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void test3_criarContaMesmoNome() {
		page.clicarAdicionarConta();
		page.setNome("Conta editada de forma autom�tica");
		page.salvar();
		Assert.assertEquals("J� existe uma conta com esse nome!", page.obterMensagemErro());
	}
}
