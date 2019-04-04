/**
 * 
 */
package demo.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author GrassPrince
 * @Da2019年4月3日 2019年4月3日 - 下午8:00:17
 * @Description druid数据库监测配置类    ->    项目启动后的访问地址  http://localhost:8086/dataSource/druid/index.html
 */
@Configuration
public class DruidConfig {
	
	/**
	 *	注入DruidDataSource在yml配置文件中的配置
	 *  	prefix： 获取以spring.datasource为前缀的配置内容， 减少一个个@Value获取
	 */
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource getDataSource() {
		return new DruidDataSource();
	}
	
	/**
	 *	配置Druid的监控 ： 一个管理后台的Servlet
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet() {
		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
		
        Map<String,String> initParams = new HashMap<String,String>();
        initParams.put("loginUsername","admin");	//用户名
        initParams.put("loginPassword","123456");	//密码
        initParams.put("allow","");					//IP白名单(没有配置或者为空，则允许所有访问)
        initParams.put("deny","");					//IP黑名单 (存在共同时，deny优先于allow)
        bean.setInitParameters(initParams);
        
        return bean;
	}
	
	/**
	 * 	配置一个web监控的filter
	 */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");				////忽略资源

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return  bean;
    }
}
