package com.example.webapp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author waves
 */
public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/db1", "root", "12345678")
                .globalConfig(builder -> {
                    builder.author("waves") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .outputDir("/Users/waves/Learn/WebApp/src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.webapp") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/waves/Learn/WebApp/src/main/java/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tb_book") // 设置需要生成的表名
                            .addTablePrefix("tb_"); // 设置过滤表前缀
                })
                .execute();
    }
}