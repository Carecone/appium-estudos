package com.alura.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {
    public final AppiumDriver driver;
    private static AppiumDriverConfig _instace;
    //valida se existe um sessão aberta, caso tenha, é retorna a sessão. Se não tiver sessão aberta, é instaciado uma nova e retornado.
    public static AppiumDriverConfig Instace(){
        if(AppiumDriverConfig._instace == null){
            AppiumDriverConfig._instace = new AppiumDriverConfig();
        }
        return AppiumDriverConfig._instace;
    }
    private AppiumDriverConfig()  {
        //Configuração do driver
        File apk = new File("src/main/resources/alura_esporte.apk");

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConexao = null;
        try {
            urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AppiumDriver(urlConexao, configuracoes);
    }
}
