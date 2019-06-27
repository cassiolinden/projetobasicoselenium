package br.rs.cassiolinden.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.rs.cassiolinden.core.BasePage;
import br.rs.cassiolinden.core.DriverFactory;

public class MovimentacaoPage extends BasePage{
	
	public void clicarCriarMovimentacao() {
		clicarBotao(By.xpath("//a[.='Criar Movimentação']"));
	}
	
	public void setTipoMovReceita() {
		clicarBotao(By.xpath("//select[@id='tipo']/option[@value='REC']"));
	}
	
	public void setTipoMovDespesa() {
		clicarBotao(By.xpath("//select[@id='tipo']/option[@value='DESP']"));
	}
	
	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}

	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
	
	public void setSituacaoPago() {
		clicarBotao("status_pago");
	}
	
	public void setSituacaoPendente() {
		clicarBotao("status_pendente");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	/*adequação ao padrão page objects explicado pelo professor*/
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	/*adequação ao padrão page objects explicado pelo professor*/
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}
	
	/*inserido após correção do professor*/
	public List<String> obterErros(){
		List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']"));
		List<String> retorno = new ArrayList<String>();
		for(WebElement erro : erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}

}
