package com.yly.enums.ifelseif;


/**
 * 问题引入：当需要做大量的if...else判断时，比如做天气预报，下面为if..else的代码
 *    if (weather.equals("rain")) {
 *             System.out.println("下雨了");
 *         } else if (weather.equals("sunny")) {
 *             System.out.println("晴天了");
 *         } else if () {
 *
 *         } else {
 *
 *         }
 * 代码看起来特别不优雅，当业务处理的逻辑复杂，会照成整个if...else特别长，影响代码的可读性，还会影响代码的重构
 * 下面使用枚举来避免大量的if...else的情况
 */
class WeatherEnumDemo {
    enum WeatherStation {
        RAIN("rain") {
            @Override
            public void handle(String name) {
                System.out.printf( name + ",下雨了回家收衣服");
            }
        }, SUNNY("sunny") {
            @Override
            public void handle(String name) {
                System.out.println(name + ",天晴了嗨皮去");
            }
        };

        /**
         * 枚举属性
         */
        private final String weather;

        WeatherStation(String weather) {
            this.weather = weather;
        }

        public String getWeather() {
            return weather;
        }

        public abstract void handle(String name);
    }

    private void broadcastWeather(String name, String weather) {
        for (WeatherStation value : WeatherStation.values()) {
            if (weather.equals(value.weather)) {
                value.handle(name);
            }
        }
    }

    public static void main(String[] args) {
        //小明订阅了天气预报
        String name = "小明";
        //当前是下雨天
        String weather = "rain";
        new WeatherEnumDemo().broadcastWeather(name, weather);
    }
}
