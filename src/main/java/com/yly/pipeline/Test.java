package com.yly.pipeline;


import com.yly.pipeline.pipeline.impl.InstallCarPipeline;
import com.yly.pipeline.valve.impl.InstallEngineValve;
import com.yly.pipeline.valve.impl.InstallWindowsValve;
import com.yly.pipeline.valve.impl.QualityInspectionValve;
import com.yly.pipeline.valve.impl.SprayPaintValve;

/**
 * 最近开发个项目，刚好需要用到责任链设计模式，就重温了tomcat的pipeline-value源码，刚好在这里记下笔记。
 * 先来考考大家，怎么用代码完成以下需求？（代码在下文） 工厂安装一台汽车，需要经过一套完整操作流水线，安装引擎 -> 安装窗子 -> 喷漆 ->质量检查, 当所有的流程依次走完这台汽车才安装成功。
 * 大家应该很快想到使用责任链设计模式，下面我来说说tomcat中pipeline-valve责任链
 * 其中pipeline是一条管道，valve是一个一个的阀门，baisc是最后一个阀门，水流从第一个阀门进入，依次流过每个阀门，然后再依次返回。
 * 下面直接上代码
 */
public class Test {
    public static void main(String[] args) {
        //创建pipeline管道
        InstallCarPipeline installCarPipeline = new InstallCarPipeline();
        //创建多个valve阀门
        InstallEngineValve installEngineValve = new InstallEngineValve();
        InstallWindowsValve installWindowsValve = new InstallWindowsValve();
        SprayPaintValve sprayPaintValve = new SprayPaintValve();
        QualityInspectionValve qualityInspectionValve = new QualityInspectionValve();
        //阀门装入管道中
        installCarPipeline.addValve(installEngineValve);
        installCarPipeline.addValve(installWindowsValve);
        installCarPipeline.addValve(sprayPaintValve);
        installCarPipeline.setBasic(qualityInspectionValve);
        //管道程序执行
        installCarPipeline.invoke(true);
    }
}
