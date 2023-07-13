package com.yly.lifecyclelistener;

public class Test {
    public static void main(String[] args) {
        RainWeatherStation rainWeatherStation = new RainWeatherStation();
        //增加监听器
        rainWeatherStation.addLifecycleListener(new RainListener());
        //下雨了
        rainWeatherStation.start();
        System.out.println("---雨在哗啦啦下---");
        //停雨了
        rainWeatherStation.stop();
    }
}
