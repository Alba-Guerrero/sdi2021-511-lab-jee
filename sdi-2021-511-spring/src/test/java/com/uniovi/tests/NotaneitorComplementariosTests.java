package com.uniovi.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;
import com.uniovi.tests.pageobjects.PO_RegisterView;

import org.junit.runners.MethodSorters;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTests {

	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\Alba\\Desktop\\SDI\\geckodriver024win64.exe";
	// En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas):
	// static String PathFirefox65 =
	// "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
	// static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	} /* Resto del código de la clase */

//Antes de cada prueba se navega al URL home de la aplicación
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

//Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

//Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

//Al finalizar la última prueba
	@AfterClass
	static public void end() {
//Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	// PR01. Acceder a la página principal /
	@Test
	public void PR01() {
		PO_PrivateView.refactorizado(driver, "99999988F", "123456", "99999988F");
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'profesor-menu')]/a");
		elementos.get(0).click();
	// Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "profesor/add", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_RegisterView.fillFormProfesor(driver, "99879950B", "Josefa", "Perez", "suplente");
		// Comprobamos que entramos en la secció}n privada
		PO_View.checkElement(driver, "text", "Josefa");
	}
	
	// PR01. Acceder a la página principal /
		@Test
		public void PR02() {
			PO_PrivateView.refactorizado(driver, "99999988F", "123456", "99999988F");
			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'profesor-menu')]/a");
			elementos.get(0).click();
		// Vamos al formulario de registro
			PO_HomeView.clickOption(driver, "profesor/add", "class", "btn btn-primary");
			// Rellenamos el formulario.
			PO_RegisterView.fillFormProfesor(driver, "99957950B", "Josefa", "Pe", "suplente");
	
		PO_RegisterView.checkKey(driver, "Error.signup.lastName.length", PO_Properties.getSPANISH());
		
		
		
		// Rellenamos el formulario.
				PO_RegisterView.fillFormProfesor(driver, "99999740B", "Josefa", "Perez", "s");
				// COmprobamos el error de apellido corto.
				PO_RegisterView.checkKey(driver, "Error.signup.categoria.length", PO_Properties.getSPANISH());
				
				
				
		}
		
		@Test
		public void PR03() {
			
			PO_PrivateView.refactorizado(driver, "99999990A", "123456", "99999990A");
			List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'profesor-menu')]/a");
			elementos.get(0).click();
		
			// Rellenamos el formulario.
			SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "add.profesor.message",PO_View.getTimeout() );
			
			/*
			PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
			
			PO_PrivateView.refactorizado(driver, "99999993D", "123456", "99999990A");
			 elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'profesor-menu')]/a");
			elementos.get(0).click();
		
			// Rellenamos el formulario.
		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "add.profesor.message",PO_View.getTimeout() );
		
		*/
		}
		
		
		
	

}
	