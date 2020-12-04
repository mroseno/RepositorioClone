package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class testLogar {

    //Declaração de variaveis globais
    WebDriver navegador;

    //Utilização da anotação Before
    //Before - antes: comandos que serão executados antes dos testes
    @Before
    public void SetUp() {

        //Abrir o Navegador Google Chrome
        System.setProperty("webdriver.chrome.driver","C:\\Users\\moniq\\Desktop\\Diretorios\\chromedriver.exe");
        navegador = new ChromeDriver();

        //Abrir o Navegador Mozila Firefox
        //System.setProperty("webdriver.gecko.driver", "F:\\Projetos Selenium\\Drivers\\geckodriver.exe");
        //navegador = new FirefoxDriver();

        //Maximizar a janela do navegador
        navegador.manage().window().maximize();

        //Acesso a página do Projetos
        navegador.get("https://homolog.autodoc.com.br/projetos3-v3/Login/");

        //Clicar no botão que possui o id="details-button" - Chrome apenas
        navegador.findElement(By.id("details-button")).click();

        //Clicar no botão que possui o id="proceed-link" - Chrome apenas
        navegador.findElement(By.id("proceed-link")).click();

        //Primeira aplicação de espera explicita
        WebDriverWait wait1 = new WebDriverWait(navegador, 60);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog_Avisos")));

        //Identificação do WebElement do modal "Avisos" com id="dialog_Avisos"
        //Fechar modal avisos com o botão Fechar com xpath="//button[@class='btn btn-primary']"
        WebElement avisoFechar = navegador.findElement(By.id("dialog_Avisos"));
        avisoFechar.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    }
    //Utilização da anotação Test
    //Cada anotação Test é responsável por rodar um caso de teste
    //Nomear de acordo com o teste que será executado
    @Test
    public void logarNoProjetos() {

        //Login

        //Identificação do formulário de login com id="loginForm"
        WebElement formularioLogin = navegador.findElement(By.id("loginForm"));

        //Preenchimento das informações de login utilizando WebElement do formulário
        formularioLogin.findElement(By.id("Email")).sendKeys("lsantos@autodoc.com.br");
        formularioLogin.findElement(By.id("Senha")).sendKeys("Tri8952!");
        formularioLogin.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //Confirmação do Cliente à Acessar

        //Segunda aplicação de espera explicita
        WebDriverWait wait2 = new WebDriverWait(navegador, 60);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("idEscolhaCliente")));

        //Escolha do cliente no combobox Clientes com id="idEscolhaCliente"
        WebElement escolherCliente = navegador.findElement(By.id("idEscolhaCliente"));
        //Cliente _Administradores
        new Select(escolherCliente).selectByVisibleText("_Administradores");

        //Terceira aplicação de espera explicita
        WebDriverWait wait3 = new WebDriverWait(navegador, 60);
        wait3.until(ExpectedConditions.elementToBeClickable(By.id("btnAcessar")));

        //Seleção do botão Acessar com id="btnAcessar"
        navegador.findElement(By.id("btnAcessar")).click();

        //Tela Inicial - Home

        //Quarta aplicação de espera explicita
        WebDriverWait wait4 = new WebDriverWait(navegador, 180);
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalTutorialVideo']")));

        //Fechar modal de avisos
        navegador.findElement(By.xpath("//button[@class='close']")).click();

        //Validar se foi acessado o cliente _Administradores
        //Utilizar a combobox com id="select2-idEscolhaCliente-container"
        WebElement cliente = navegador.findElement(By.id("select2-idEscolhaCliente-container"));
        String validarCliente =cliente.getText();
        assertEquals("_Administradores",  "_Administradores");

        }
    }
