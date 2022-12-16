package com.alura.appium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class FeatureCadastro

{

    public void nao_consigo_cadastrar_usuario_com_senhas_que_nao_conferem() throws MalformedURLException {
        AppiumDriverConfig driver = new AppiumDriverConfig();

        WebElement botaoCadastro = (WebElement) driver.driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario"));
        botaoCadastro.click();
    }
}
