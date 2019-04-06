package demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.vo.TestLombok;
import lombok.extern.slf4j.Slf4j;

/**
 * @author GrassPrince
 * @Da2019年4月5日 2019年4月5日 - 上午10:01:46
 * @Description 测试lombok的@Slf4j：自动创建Slf4j日志对象log
 * 			@RestController : @Controller 和 @ResponseBody结合注解 ,既是controller也返回到页面json数据
 * 			@ResponseBody 解析返回值的Content-Type：   String -> text/html   对象/Map集合  ->  application/json
 */
@RestController
@Slf4j
public class LombokController {
	
	@GetMapping("/testLombok")
	public TestLombok testLombok() {
		// 这边能够创建对象即说明@Data注解可以创建无参构造
		TestLombok lombok = new TestLombok();
		// 可以set即说明@Data注解可以创建setter方法
		lombok.setBriefs("平底");
		lombok.setCup("C");
		// @Slf4j创建Slf4j日志对象log
		log.info("@Data注解包含toString方法: {}", lombok.toString());
		log.info("@Data注解包含getter方法: 罩杯 - {},  内裤 - {}", lombok.getBriefs(), lombok.getCup());
		
		return lombok;
	}

}
