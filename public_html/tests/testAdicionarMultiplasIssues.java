package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
//import static suporte.Generator.esperarElement;

//Utilização da anotação RunWith
//Utilização da biblioteca easytest - DataDrivenTestRunner
@RunWith(DataDrivenTestRunner.class)

//Utilização da anotação DataLoader
//filePath - arquivo onde será o repositório dos dados dos testes
//Utilização do arquivo csv para guardar os dados dos testes
@DataLoader(filePaths = "test4Data.csv") //Recomendado utilizar o nome da classe

public class testAdicionarMultiplasIssues {

    //
    //@FindBy(how = How.ID, using = "home")

    //Declaração de variaveis globais
    WebDriver navegador;
    //private WebElement home;

    //Método para Re-uso de esperas explicitas
    //public WebElement esperarElement(WebElement esperaDoElement) {
    //    WebDriverWait esperar = new WebDriverWait(navegador,240);
    //    WebElement element =  esperar.until(ExpectedConditions.elementToBeClickable(esperaDoElement));
    //    return element;
    //}

    //Utilização da anotação Before
    //Before - antes: comandos que serão executados antes dos testes
    @Before
    public void SetUp(){

        //Abrir o Navegador Google Chrome
        System.setProperty("webdriver.chrome.driver", "F:\\Projetos Selenium\\Drivers\\chromedriver.exe");
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
        //esperaDoElement("dialog_Avisos");
        //esperarElement((WebElement) By.id("dialog_Avisos"));
        //esperarElement(navegador.findElement(By.id("dialog_Avisos")));

        //Identificação do WebElement do modal "Avisos" com id="dialog_Avisos"
        //Fechar modal avisos com o botão Fechar com xpath="//button[@class='btn btn-primary']"
        WebElement avisoFechar = navegador.findElement(By.id("dialog_Avisos"));
        avisoFechar.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //Login

        //-----------ENTRADA----------//

        //Identificação do formulário de login com id="loginForm"
        WebElement formularioLogin = navegador.findElement(By.id("loginForm"));

        //Preenchimento das informações de login utilizando WebElement do formulário
        formularioLogin.findElement(By.id("Email")).sendKeys("email");
        formularioLogin.findElement(By.id("Senha")).sendKeys("senha");

        //-----------ENTRADA----------//

        //Segunda aplicação de espera explicita
        WebDriverWait wait2 = new WebDriverWait(navegador, 60);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
        //esperaDoElement("dialog_Avisos");
        //esperarElement(navegador.findElement(By.xpath("//button[contains(text(),'Login')]")));

        formularioLogin.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

        //Confirmação do Cliente à Acessar

        //Terceira aplicação de espera explicita
        WebDriverWait wait3 = new WebDriverWait(navegador, 60);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("idEscolhaCliente")));
        //esperarElement(navegador.findElement(By.id("idEscolhaCliente")));

        //-----------ENTRADA----------//

        //Escolha do cliente no combobox Clientes com id="idEscolhaCliente"
        WebElement escolherCliente = navegador.findElement(By.id("idEscolhaCliente"));
        //Cliente _Administradores
        new Select(escolherCliente).selectByVisibleText("_Administradores");

        //-----------ENTRADA----------//

        //Quarta aplicação de espera explicita
        WebDriverWait wait4 = new WebDriverWait(navegador, 60);
        wait4.until(ExpectedConditions.elementToBeClickable(By.id("btnAcessar")));
        //esperarElement(navegador.findElement(By.id("btnAcessar")));

        //Seleção do botão Acessar com id="btnAcessar"
        navegador.findElement(By.id("btnAcessar")).click();

        //Tela Inicial - Home

        //Quinta aplicação de espera explicita
        WebDriverWait wait5 = new WebDriverWait(navegador, 180);
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalTutorialVideo']")));
        //esperarElement(navegador.findElement(By.xpath("//div[@id='modalTutorialVideo']")));

        //Fechar modal de avisos
        navegador.findElement(By.xpath("//button[@class='close']")).click();
    }

    //Utilização da anotação Test
    //Cada anotação Test é responsável por rodar um caso de teste
    //Nomear de acordo com o teste que será executado
    @Test
    //Comentar o teste o impede de ser executado
    //Utilização da anotação Param para informar os dados das colunas do arquivo csv
    public void testadicionarIssue(@Param(name="selecionarProjeto")String selecionarProjeto,
                                   @Param(name="preencherTitulo")String preencherTitulo,
                                   @Param(name="selecionarDisciplina")String selecionarDisciplina,
                                   @Param(name="selecionarFase")String selecionarFase,
                                   @Param(name="selecionarAtribuicao")String selecionarAtribuicao,
                                   @Param(name="preencerDescricao")String preencerDescricao,
                                   @Param(name="preencherData")String preencherData,
                                   @Param(name="validarTitulo")String validartitulo,
                                   @Param(name="validarProjeto")String validarProjeto,
                                   @Param(name="validarPrioridade")String validarPrioridade,
                                   @Param(name="validarPefil")String validarPefil,
                                   @Param(name="validarFase")String validarFase,
                                   @Param(name="validarAtribuicao")String validarAtribuicao,
                                   @Param(name="validarDescricao")String validarDescricao,
                                   @Param(name="validarData")String validarData)
    {
        //Acesso ao menu

        //Seleção do menu "hamburguer" com xpath="//button[@class='close']"
        WebElement menu = navegador.findElement(By.id("mobile-collapse"));
        menu.click();

        //Seleção do módulo 4COLLAB
        menu.findElement(By.xpath("//span[contains(.,'4COLLAB')]")).click();

        //Sexta aplicação de espera explicita
        WebDriverWait wait6 = new WebDriverWait(navegador, 60);
        wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Ocorrências')]")));
        //esperarElement(navegador.findElement(By.xpath("//span[contains(text(),'Ocorrências')]")));

        //Seleção da opção Ocorrências do módulo 4COLLAB
        menu.findElement(By.xpath("//span[contains(text(),'Ocorrências')]")).click();

        //Módulo Ocorrências - 4Collab

        //Sétima aplicação de espera explicita
        WebDriverWait wait7 = new WebDriverWait(navegador, 60);
        wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdown-4']")));
        //esperarElement(navegador.findElement(By.xpath("//button[@id='dropdown-4']")));

        //Seleção do botão Criar com xpath="//button[@id='dropdown-4']"
        navegador.findElement(By.xpath("//button[@id='dropdown-4']")).click();

        //Seleção da opção Nova Ocorrência com link text
        navegador.findElement(By.linkText("Nova Ocorrência")).click();

        //Modal Criar Nova Ocorrência

        //Oitava aplicação de espera explícita
        WebDriverWait wait8 = new WebDriverWait(navegador, 60);
        wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalFormularioOcorrecia']")));
        //esperarElement(navegador.findElement(By.id("modalFormularioOcorrecia")));

        //Declaração do WebElement do Modal Nova Ocorrência
        //Indentificação do modal nova ocorrencia com o xpath="//div[@id='modalFormularioOcorrecia']"
        WebElement modalNovaIssue = navegador.findElement(By.xpath("//div[@id='modalFormularioOcorrecia']"));

        //-----------ENTRADA----------//

        //Seleção de um projeto do combobox Projeto* com o id="IdProjeto"
        //Utilização da classe Select para o combobox
        WebElement selecaoProjeto = modalNovaIssue.findElement(By.id("IdProjeto"));
        new Select(selecaoProjeto).selectByVisibleText(selecionarProjeto);

        //Preenchimento de texto do campo de texto Titulo* com o id="Titulo*"
        modalNovaIssue.findElement(By.id("Titulo")).sendKeys(preencherTitulo);

        //Seleção de um perfil de disc do combobox Perfil de Disciplina* com o id="IdPerfilDisciplina"
        //Utilização da classe Select para o combobox
        WebElement perfilDisciplina = modalNovaIssue.findElement(By.id("IdPerfilDisciplina"));
        new Select(perfilDisciplina).selectByVisibleText(selecionarDisciplina);

        //Seleção de uma fase do combobox Fase* com o id="IdFase"
        //Utilização da classe Select para o combobox
        WebElement fase = modalNovaIssue.findElement(By.id("IdFase"));
        new Select(fase).selectByVisibleText(selecionarFase);

        //Seleção de atribuição do combobox Atribuído para* com id="IdUsuarioAtribuido"
        //Utilização da classe Select para o combobox
        WebElement atribuidoPara = modalNovaIssue.findElement(By.id("IdUsuarioAtribuido"));
        new Select(atribuidoPara).selectByVisibleText(selecionarAtribuicao);

        //Preenchimento de texto do campo de texto Descrição* com id="Descricao"
        modalNovaIssue.findElement(By.id("Descricao")).sendKeys(preencerDescricao);

        //Criação de uma instacia de JavaScript
        JavascriptExecutor je = (JavascriptExecutor) navegador;

        //Identificação do WebElement que irá aparecer após realizar o scroll
        WebElement dataResponderAte = modalNovaIssue.findElement(By.id("DataResponder"));

        //Execução da query que realizará o scroll até o element aparecer na pagina
        je.executeScript("arguments[0].scrollIntoView(true);",dataResponderAte);

        //Preencher uma data no campo de data "Responder até" com id="DataResponder"
        modalNovaIssue.findElement(By.id("DataResponder")).sendKeys(preencherData);

        //Seleção do botão Salvar com xpath="//button[contains(text(),'Salvar')]"
        modalNovaIssue.findElement(By.xpath("//button[contains(text(),'Salvar')]")).click();

        //-----------ENTRADA----------//

        //Modal do Resumo da Ocorrência
        //Validação

        //Nona aplicação de espera explícita
        WebDriverWait wait9 = new WebDriverWait(navegador, 60);
        wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("AbaResumo")));
        //esperarElement(navegador.findElement(By.id("AbaResumo")));

        //Identificação do modal Resumo com o id="AbaResumo"
        WebElement modalResumo = navegador.findElement(By.id("AbaResumo"));

        //-----------SAIDA----------//

        //Validação do Titulo da ocorrência com xpath="//h5[contains(text(),'Teste Automatizado 01')]"
        //Novo xpath para localizar titulo //span[contains(text(),'Descrição:')]/following-sibling::p
        WebElement titulo = modalResumo.findElement(By.xpath("//span[contains(text(),'Descrição:')]/following-sibling::p"));
        String validarTitulo = titulo.getText();
        assertEquals(validarTitulo, validarTitulo);

        //Validação do Projeto da ocorrência com xpath="//p[contains(text(),'_RONDAO03')]"
        WebElement projeto = modalResumo.findElement(By.xpath("//span[contains(text(),'Projeto:')]/following-sibling::p"));
        String validacaoProjeto = projeto.getText();
        assertEquals(validarProjeto, validacaoProjeto);

        //Validação da Prioridade da ocorrência com xpath="//p[contains(text(),'Normal')]"
        WebElement prioridade = modalResumo.findElement(By.xpath("//span[contains(text(),'Prioridade:')]/following-sibling::p"));
        String validacaoPrioridade = prioridade.getText();
        assertEquals(validarPrioridade,validacaoPrioridade);

        //Validação do Perfil de Disciplina da ocorrência com xpath="//p[contains(text(),'DEVELOPER')]"
        WebElement perfilDisc = modalResumo.findElement(By.xpath("//span[contains(text(),'Perfil de Disciplina:')]/following-sibling::p"));
        String validacaoPefil = perfilDisc.getText();
        assertEquals(validarPefil, validacaoPefil);

        //Validação da Fase da ocorrência com xpath="//p[contains(text(),'01.Teste Migração')]"
        WebElement fase2 = modalResumo.findElement(By.xpath("//span[contains(text(),'Fase:')]/following-sibling::p"));
        String validacaoFase = fase2.getText();
        assertEquals(validarFase, validacaoFase);

        //Validação do Atribuído para da ocorrência com xpath="//p[contains(text(),'Administrador')]"
        WebElement atribuicao = modalResumo.findElement(By.xpath("//span[contains(text(),'Atribuição:')]/following-sibling::p"));
        String validacaoAtribuicao = atribuicao.getText();
        assertEquals(validarAtribuicao, validacaoAtribuicao);

        //Validação da Descrição da ocorrência com xpath="//p[contains(text(),'Descrição teste auto 01')]"
        WebElement descricao = modalResumo.findElement(By.xpath("//span[contains(text(),'Descrição:')]/following-sibling::p"));
        String validacaoDescricao = descricao.getText();
        assertEquals(validarDescricao, validacaoDescricao);

        //Validação da data Responder até da ocorrência com xpath="//body/div[@id='modalResumoAcao']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[5]/div[1]/p[1]"
        WebElement responderAte = modalResumo.findElement(By.xpath("//span[contains(text(),'Responder até:')]/following-sibling::p"));
        String validacaoData = responderAte.getText();
        assertEquals(validarData, validacaoData);

        //-----------SAIDA----------//

        //
        //WebElement modalOcorrencia = navegador.findElement(By.id("modalResumoAcao"));

        //Captura do código da Ocorrência utilizando String
        //WebElement codigoOcorrencia = modalOcorrencia.findElement(By)

        //Fechar modal Resumo selecionando 'X' com xpath="//span[contains(text(),'×')]"
        //modalResumo.findElement(By.xpath("//span[contains(text(),'×')]")).click();

        //Listagem da Ocorrencia

        //Nona aplicação de espera explicita
        //WebDriverWait wait9 = new WebDriverWait(navegador,60);
        //wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdown-4']")));

        //Validação da listagem da nova ocorrência Teste Automatizado 01
        //WebElement listagemOcorrencias = navegador.findElement(By.xpath("id=\"_4collab-table-list_wrapper\""));

    }

}
