package com.shengkai.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.shengkai.demo.mapper.coursedb", sqlSessionTemplateRef  = "courseSqlSessionTemplate")
public class CourseDBConfig {

    @Bean(name = "courseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.coursedb")
    public DataSource courseDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "courseSqlSessionFactory")
    public SqlSessionFactory courseSqlSessionFactory(@Qualifier("courseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/coursedb/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "courseTransactionManager")
    public DataSourceTransactionManager courseTransactionManager(@Qualifier("courseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "courseSqlSessionTemplate")
    public SqlSessionTemplate courseSqlSessionTemplate(@Qualifier("courseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}