package com.gao.mybatis.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
// 指定扫描的mapper接口所在的包 由于在MapperScannerConfigurer中声明了 在此不用声明
// @MapperScan(basePackages="com.gao.mybatis.mapper")

// 启用下面这个注解，并且实现TransactionManagementConfigurer接口,使得mybatis支持事务 由于要使用hibernate事物 将mybatis事物取消
// @EnableTransactionManagement
public class MyBatisConfig /*implements TransactionManagementConfigurer*/ {

    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;

    /*    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }*/

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        // 添加插件
        bean.setPlugins(new Interceptor[] { pageHelper });
        // 指定domain类的基包，即指定其在*Mapper.xml文件中可以使用简名来代替全类名
        bean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources(env.getProperty("mybatis.mapperLocations")));
            // 读取mybatis配置文件
            // bean.setConfigLocation(resolver.getResource(env.getProperty("mybatis.configLocation")));
            org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
            config.setMapUnderscoreToCamelCase(true);
            config.setLazyLoadingEnabled(true);
            bean.setConfiguration(config);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}