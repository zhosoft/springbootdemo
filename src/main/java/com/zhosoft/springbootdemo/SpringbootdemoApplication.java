package com.zhosoft.springbootdemo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

/**
 * 根目录：com.springboot
 *
 * 1.工程启动类(ApplicationServer.java)置于com.springboot.build包下
 * 2.实体类(domain)置于com.springboot.domain
 * 3.数据访问层(Dao)置于com.springboot.repository（*）
 * 4.数据服务层(Service)置于com,springboot.service,数据服务的实现接口(serviceImpl)至于com.springboot.service.impl（*）
 * 5.前端控制器(Controller)置于com.springboot.controller（*）
 * 6.工具类(utils)置于com.springboot.utils（*）
 * 7.常量接口类(constant)置于com.springboot.constant
 * 8.配置信息类(config)置于com.springboot.config（*）
 * 9.数据传输类(vo)置于com.springboot.vo
 *
 */
@MapperScan(value = "com.zhosoft.springbootdemo.*")
@SpringBootApplication
public class SpringbootdemoApplication {

    @Bean
    public HttpMessageConverters fastJsonConfigure(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}

