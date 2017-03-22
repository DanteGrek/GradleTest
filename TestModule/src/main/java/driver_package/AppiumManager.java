package driver_package;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * Created by osolomin on 15.03.17.
 */
public class AppiumManager {

    AppiumDriverLocalService service;

    public AppiumManager() {

        this.service = AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumManager(String port) {
        this.service = new AppiumServiceBuilder().withArgument(() -> "--port", port).build();
    }

    public void startAppium(){
        if(service.isRunning()) {
            System.out.println("\n Appium server is already started. \n");
        }else{
            service.start();
        }
    }

    public void stopAppium(){
        service.stop();
    }

}
