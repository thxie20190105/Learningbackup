package org.xigua.util;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * MybatisPlus 逆向生成工具类
 * @author xigua
 */
public class MybatisPlusCodeGenerator {
    /**
     * 定义数据库表
     */
    private final static String[] TABLE = {"xs_user"};


    /**
     * 定义数据库配置
     */
    private final static String PROJECT_PATH = System.getProperty("user.dir");
    private final static String OUTPUT_DIR = PROJECT_PATH + "/src/main/java/";
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/xigua_study?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private final static String DB_USER_NAME = "root";
    private final static String DB_USER_PASS_WORD = "!qaz@wsx";
    private final static String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";

    /**
     * 以下需要单独配置
     */
    private final static String AUTHOR = "xigua";
    private final static String PARENT = "org.xigua.study.mybatis";
    private final static String VM_PATH = "util/vm/";
    private final static String OUT_PUT_PACKAGE = OUTPUT_DIR + "org/xigua/study/mybatis";
    private final static String SUPER_ENTITY_CLASS = "";
    private final static String SUPER_CONTROLLER_CLASS = "";
    private final static String SUPER_SERVICE_CLASS = "";
    private final static String TABLE_PREFIX = "";
    private final static String MODULE_NAME = "";

    private final static String OUT_PUT_CONTROLLER = OUT_PUT_PACKAGE + "/Controller/";
    private final static String OutPutService = OUT_PUT_PACKAGE + "/service/";
    private final static String OUT_PUT_SERVICE_IMPL = OUT_PUT_PACKAGE + "/service/impl";
    private final static String OUT_PUT_MAPPER = OUT_PUT_PACKAGE + "/mapper/";
    private final static String OUT_PUT_MAPPER_XML = OUT_PUT_PACKAGE + "/mapper/";


    /**
     * 全局配置
     *
     * @return
     */
    private static GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(OUTPUT_DIR);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setFileOverride(false);
        //覆盖原有文件，true会覆盖自定义输出的一些东西
        return gc;
    }

    /**
     * 数据源配置
     *
     * @return
     */
    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        dsc.setDriverName(DB_DRIVER_NAME);
        dsc.setUsername(DB_USER_NAME);
        dsc.setPassword(DB_USER_PASS_WORD);
        return dsc;
    }

    /**
     * 包配置
     *
     * @return
     */
    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        //设置模块名
        pc.setParent(PARENT);
        //设置包名
        return pc;
    }

    /**
     * 策略配置
     *
     * @return
     */
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //生成RestController控制器
        strategy.setRestControllerStyle(true);
        //共实体类
        strategy.setEntityLombokModel(false);
        //使用lombox注解
        strategy.setSuperEntityClass(SUPER_ENTITY_CLASS);
        strategy.setEntityTableFieldAnnotationEnable(true);
        //生成字段注释
        // 公共父类
        strategy.setSuperControllerClass(SUPER_CONTROLLER_CLASS);
        strategy.setSuperServiceClass(SUPER_SERVICE_CLASS);
        strategy.setInclude(TABLE);
        strategy.setControllerMappingHyphenStyle(false);
        //mapping("驼峰命名")
        strategy.setTablePrefix(TABLE_PREFIX);
        return strategy;
    }

    /**
     * 自定义配置
     *
     * @return
     */
    private static InjectionConfig getInjectionConfig() {
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        // controller
        focList.add(new FileOutConfig(VM_PATH + "controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUT_PUT_CONTROLLER + "/" + tableInfo.getEntityName() + "Controller" + ".java";
            }
        });
        //service
        focList.add(new FileOutConfig(VM_PATH + "service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OutPutService + "/" + "I" + tableInfo.getEntityName() + "Service" + ".java";
            }
        });
        //serviceImpl
        focList.add(new FileOutConfig(VM_PATH + "serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUT_PUT_SERVICE_IMPL + "/" + tableInfo.getEntityName() + "ServiceImpl" + ".java";
            }
        });
        //mapper
        focList.add(new FileOutConfig(VM_PATH + "mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUT_PUT_MAPPER + "/" + tableInfo.getEntityName() + "Mapper" + ".java";
            }
        });
        //mapper.xml
        focList.add(new FileOutConfig(VM_PATH + "mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return OUT_PUT_MAPPER_XML + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //Velocity（默认）

        mpg.setTemplate(new TemplateConfig().setXml(null));
        // 配置模板
        mpg.setGlobalConfig(getGlobalConfig());
        // 全局配置
        mpg.setDataSource(getDataSourceConfig());
        // 数据源配置
        mpg.setPackageInfo(getPackageConfig());
        // 包配置
        mpg.setStrategy(getStrategyConfig());
        // 策略配置//数据库表配置
        mpg.setCfg(getInjectionConfig());
        //自定义模板
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

}

