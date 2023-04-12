package steps;

import elementos.Elementos;
import utils.MassaDados;
import utils.DicionarioDeMensagens;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import runner.Executa;
import metodos.Metodos;

public class LoginTest {

	Metodos metodos = new Metodos();
	Elementos el = new Elementos();
	MassaDados massa = new MassaDados();
	DicionarioDeMensagens msg = new DicionarioDeMensagens();

	@Given("que eu esteja na tela de login")
	public void queEuEstejaNaTelaDeLogin() {
		Executa.abrirNavegador();
	}

	@After
	public void finalizarTeste() {
		Executa.fecharNavegador();	

	}

	@Given("preencher o usuario")
	public void preencherOUsuario() {
		metodos.escrever(el.name, massa.standard_user);

	}

	@Given("preencher a senha")
	public void preencherASenha() {
		metodos.escrever(el.password, massa.secret_sauce);
	}

	@When("realizar o login")
	public void realizarOLogin() {
		metodos.clicar(el.btnLogin);
	}

	@Then("login realizado com sucesso")
	public void loginRealizadoComSucesso() throws Exception {
		metodos.currentURL("https://www.saucedemo.com/inventory.html");
		metodos.pause(5000);
		Executa.evidencia("loginSucesso");
		

	}

	@Given("preencher com usuario bloqueado")
	public void preencherComUsuarioBloqueado() {
		metodos.escrever(el.name, massa.locked_out_user);

	}

	@Then("sistema deve exibir mensagem de usuario bloqueado")
	public void sistemaDeveExibirMensagemDeUsuarioBloqueado() throws Exception {
		metodos.validarTexto(el.msgBlock, msg.msgBlock);		

	}

	@Given("preencher com usuario invalido")
	public void preencherComUsuarioInvalido() {
		metodos.escrever(el.name, massa.problem_user);

	}

	@Given("preencher a senha invalida")
	public void preencherASenhaInvalida() {
		metodos.escrever(el.password, "invalida");

	}

	@Then("sistema deve exibir mensagem de usuario e senha invalidos")
	public void sistemaDeveExibirMensagemDeUsuarioESenhaInvalidos() throws Exception {
		metodos.validarTexto(el.msgBlock, msg.msgProblem_user);		

	}

	@Given("nao preencher nenhum dado")
	public void naoPreencherNenhumDado() {
		metodos.clicar(el.btnLogin);

	}

	@Then("sistema deve exibir mensagem de dados em branco")
	public void sistemaDeveExibirMensagemDeDadosEmBranco() throws Exception {
		metodos.validarTexto(el.msgBlock, msg.msgFieldsRequired);	

	}

}
