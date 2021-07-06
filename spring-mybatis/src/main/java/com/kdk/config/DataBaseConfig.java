package com.kdk.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(value = "com.kdk.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataBaseConfig {

  @Primary
  @Bean(name = "dataSource")
  @ConfigurationProperties(prefix = "spring.main.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary
  @Bean(name = "sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactoryBean(
      @Autowired @Qualifier("dataSource") DataSource dataSource,
      ApplicationContext applicationContext) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource);
    factoryBean
        .setConfigLocation(applicationContext.getResource("classpath:mybatis/mybatis-config.xml"));
    factoryBean
        .setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/*.xml"));

    return factoryBean.getObject();
  }

  @Primary
  @Bean(name = "sqlSession")
  public SqlSessionTemplate sqlSession(
      @Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Primary
  @Bean(name = "transactionManager")
  public DataSourceTransactionManager transactionManager(
      @Autowired @Qualifier("dataSource") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}
