package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
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
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by GrassPrince on 2019/10/11 12:16
 * 副数据源配置类
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.mapper.secondDataSource", sqlSessionTemplateRef = "db2SqlSessionTemplate")
@Slf4j
public class SecondDataSource {

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis2/*.xml"));
        bean.setTypeAliasesPackage("com.example.demo.domain");

        SqlSessionFactory sqlSessionFactory=null;
        try{
            sqlSessionFactory = bean.getObject();
        }catch (Exception e) {
            log.error("初始化对象失败", e);
        }

        // org.apache.ibatis.session.Configuration  configuration = sqlSessionFactory.getConfiguration();
        // configuration.setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }

    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
