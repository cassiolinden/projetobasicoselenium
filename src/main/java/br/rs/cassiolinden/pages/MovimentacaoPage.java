package br.rs.cassiolinden.pages;

import org.openqa.selenium.By;

import br.rs.cassiolinden.core.BasePage;

public class MovimentacaoPage extends BasePage{
	
	public void criarMovimentacao() {
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
	
	public void setContaAddManual() {
		clicarBotao(By.xpath("//select[@id='conta']/option[@value='21080']"));
	}
	
	public void setContaAddAuto() {
		clicarBotao(By.xpath("//select[@id='conta']/option[@value='21085']"));
	}
	
	public void setContaEditAuto() {
		clicarBotao(By.xpath("//select[@id='conta']/option[@value='21081']"));
	}
	
	public void setSituacaoPago() {
		clicarBotao("status_pago");
	}
	
	public void setSituacaoPendente() {
		clicarBotao("status_pendente");
	}
	
	public void salvar() {
		clicarBotao(By.xpath("//button[@type='submit']"));
	}

}
