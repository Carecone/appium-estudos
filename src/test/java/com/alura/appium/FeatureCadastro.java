package com.alura.appium;

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
        WebElement campoNome = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));
        WebElement campoSenha = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));
        WebElement campoConfirmarSenha = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));
        campoNome.sendKeys("Diego");
        campoSenha.sendKeys("123");
        campoConfirmarSenha.sendKeys("321");

        WebElement botaoConfirmarCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
        botaoConfirmarCadastro.click();
        WebElement erroCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro"));

        Assert.assertEquals("Senhas não conferem", erroCadastro.getText());
        driver.navigate().back();
    }

    public void testApp_posso_cadastrar_usuario_com_senhas_que_conferem() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.Instace().driver;

        WebElement botaoCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        botaoCadastro.click();

        WebElement campoNome = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));
        WebElement campoSenha = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));
        WebElement campoConfirmarSenha = driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));
        campoNome.sendKeys("Diego");
        campoSenha.sendKeys("123");
        campoConfirmarSenha.sendKeys("123");

        WebElement botaoConfirmarCadastro = driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
        botaoConfirmarCadastro.click();

        WebElement botaoLogar = driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar"));

    }
}
