package com.ohgiraffers.techmya.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.techmya", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
