package suporte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Web {

    public static final String USERNAME = "moniqueelzarosen1";
    public static final String AUTOMATE_KEY = "Uw7WQQ6RCDBZCa3HLS69";
    public static final String URLBrowserStack = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    //Cria o Chorme que está na minha maquina
    public static WebDriver createChrome() {

        //Abrir o Navegador Google Chrome
        System.setProperty("webdriver.chrome.driver","\"/path/to/chromedriver");
        WebDriver navegador = new ChromeDriver();

        //Maximizar a janela do navegador
        navegador.manage().window().maximize();

        //Acesso a página do Projetos
        navegador.get("https://homolog.autodoc.com.br/projetos3-v3/Login/");

        //Clicar no botão que possui o id="details-button" - Chrome apenas
        navegador.findElement(By.id("details-button")).click();

        //Clicar no botão que possui o id="proceed-link" - Chrome apenas
        navegador.findElement(By.id("proceed-link")).click();

        return navegador;

    }

    //Cria o Firefox que está na minha maquina
    //public static WebDriver createFirefox() {

        //Abrir o Navegador Mozila Firefox
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\moniq\\Desktop\\diretorio\\chromedriver.exe");
        //WebDriver navegador = new FirefoxDriver();

        //Maximizar a janela do navegador
        //navegador.manage().window().maximize();

        //Acesso a página do Projetos
        //navegador.get("https://homolog.autodoc.com.br/projetos3-v3/Login/");

        //return navegador;

   // }

    //Cria o navegador diretamente no BrowserStack
    public static WebDriver createBrowserStack() {

        DesiredCapabilities caps = new DesiredCapabilities();

        //Capabilitys podem ser modificadas de acordo com a configuração do BrowserStack
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "81");
        caps.setCapability("resolution", "1366x768");
        caps.setCapability("browserstack.debug", "true");
        //caps.setCapability("name", "lucassantos28's First Test");

        WebDriver navegador = null;

        try {

            navegador = new RemoteWebDriver(new URL(URLBrowserStack), caps);

            //Acesso a página do Projetos
            navegador.get("https://homolog.autodoc.com.br/projetos3-v3/Login/");

            //Clicar no botão que possui o id="details-button" - Chrome apenas
            navegador.findElement(By.id("details-button")).click();

            //Clicar no botão que possui o id="proceed-link" - Chrome apenas
            navegador.findElement(By.id("proceed-link")).click();

        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas com a URL: " + e.getMessage());
        }

        return navegador;

    }
}
