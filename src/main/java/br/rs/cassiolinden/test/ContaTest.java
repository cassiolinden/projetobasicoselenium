package br.rs.cassiolinden.test;

import org.junit.Assert;
import org.junit.Test;

import br.rs.cassiolinden.core.BaseTest;
import br.rs.cassiolinden.pages.ContaPage;

public class ContaTest extends BaseTest{
	private ContaPage page = new ContaPage();
	
	@Test
	public void criarConta() {
		page.clicarAdicionarConta();
		page.setNome("Conta adicionada de forma automática");
		page.salvar();
		Assert.assertEquals("Conta adicionada com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void alterarConta() {
		page.clicarListarContas();
		page.clicarAlterarConta("Conta adicionada de forma automática");
		page.setNome("Segunda conta editada de forma automática");
		page.salvar();
		Assert.assertEquals("Conta alterada com sucesso!", page.obterMensagemSucesso());
	}
	
	@Test
	public void criarContaMesmoNome() {
		page.clicarAdicionarConta();
		page.setNome("Conta adicionada de forma automática");
		page.salvar();
		Assert.assertEquals("Já existe uma conta com esse nome!", page.obterMensagemErro());
	}
	
	@Test
	public void removerContaComMovimentacao() {
		page.clicarListarContas();
		page.removerConta("Conta editada de forma automática");
		Assert.assertEquals("Conta em uso na movimentações", page.obterMensagemErro());
	}
}
