package com.alura.appium;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FeatureCadastro
    extends TestCase
{
    public void testApp_nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        WebElement botaoCadastro = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        botaoCadastro.click();
        WebElement campoNome = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome"));
        WebElement campoSenha = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha"));
        WebElement campoConfirmarSenha = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha"));
        campoNome.sendKeys("Diego");
        campoSenha.sendKeys("123");
        campoConfirmarSenha.sendKeys("321");

        WebElement botaoConfirmarCadastro = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar"));
        botaoConfirmarCadastro.click();

        WebElement erroCadastro = driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro"));
        Assert.assertEquals("Senhas não conferem", erroCadastro.getText());
    }
}
