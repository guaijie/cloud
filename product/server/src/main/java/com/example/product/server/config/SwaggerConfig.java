/****************************************************
 * 创建人: @author zhangkuangwen    
 * 创建时间: 2019/6/24/10:45
 * 项目名称: product
 * 文件名称: SwaggerConfig.java
 * 文件描述: @Description: swagger配置
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.example.product.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 包名称：com.example.product.server.config
 * 类名称：SwaggerConfig
 * 类描述：swagger配置
 * 创建人：@author zhangkuangwen
 * 创建时间：2019/6/24/10:45
 */
@Configuration
public class SwaggerConfig {

    // 接口版本号
    private final String version = "1.0";
    // 接口大标题
    private final String title = "SpringBoot示例工程";
    // 具体的描述
    private final String description = "API文档自动生成示例";
    // 服务说明url
    private final String termsOfServiceUrl = "http://www.baidu.com";
    // licence
    private final String license = "MIT";
    // licnce url
    private final String licenseUrl = "https://mit-license.org/";
    // 接口作者联系方式
    private final Contact contact = new Contact("guaijie", "https://github.com/guaijie", "guaijie@gmail.com");

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf())
                .select().build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title(title).termsOfServiceUrl(termsOfServiceUrl).description(description)
                .version(version).license(license).licenseUrl(licenseUrl).contact(contact).build();

    }
}
