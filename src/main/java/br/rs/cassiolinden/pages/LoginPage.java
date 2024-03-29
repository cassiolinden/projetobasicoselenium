package br.rs.cassiolinden.pages;

import br.rs.cassiolinden.core.BasePage;
import br.rs.cassiolinden.core.DriverFactory;

public class LoginPage extends BasePage{

//	https://seubarriga.wcaquino.me/login
	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	public void resetar() {
		clicarLink("reset");
	}
}
