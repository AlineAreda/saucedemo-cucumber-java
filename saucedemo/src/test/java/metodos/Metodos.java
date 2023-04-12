package metodos;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;

import drivers.Drivers;

public class Metodos extends Drivers {

	public void escrever(By elemento, String texto) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.err.println("Erro ao tentar escrever no elemento " + elemento);
		}
	}

	public void clicar(By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("Erro ao tentar clicar no elemento " + elemento);
		}
	}

	public void currentURL(String urlDesejada) {
		try {
			assertEquals(urlDesejada, driver.getCurrentUrl());
		} catch (Exception e) {
			System.err.println("Erro ao tentar validar a url desejada " + urlDesejada);
		}

	}

	public void validarTexto(By elemento, String msgEsperada) {
		try {
			String msgCapturada = driver.findElement(elemento).getText();
			assertEquals(msgEsperada, msgCapturada);
		} catch (Exception e) {
			System.err.println("Erro ao tentar validar a mensagem " + msgEsperada);
		}

	}
	
	public void pause (int tempo) throws Exception {
		Thread.sleep(tempo);		
	}

}
