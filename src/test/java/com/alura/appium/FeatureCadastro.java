package com.alura.appium;

import com.alura.appium.PageObjects.CadastroPageObjects;
import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FeatureCadastro
    extends TestCase
{
    public void testApp_nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() {
        AppiumDriver driver = AppiumDriverConfig.Instace().driver;

        WebElement botaoCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        botaoCadastro.click();

        CadastroPageObjects telaCadastro = new CadastroPageObjects(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Diego", "123", "321");
        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());
        driver.navigate().back();
    }

    public void testApp_posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instace().driver;

        WebElement botaoCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        botaoCadastro.click();

        CadastroPageObjects telaCadastro = new CadastroPageObjects(driver);
        telaCadastro.BuscarElementos();
        telaCadastro.Cadastrar("Diego", "123", "123");

        WebElement botaoLogar = driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar"));

    }
}
