package demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.vo.TestLombok;
import lombok.extern.slf4j.Slf4j;

/**
 * @author GrassPrince
 * @Da2019年4月6日 2019年4月6日 - 下午2:27:41
 * @Description controller常用注解的使用
 * 				@RestController  等价于  类上的@Controller 和  方法上的@ResponseBody 结合，  即这个controller 所有方法返回的都是json数据
 * 				@RequestMapping("test")： 页面请求的地址，放在controller上即每个方法前面都要加上  /test 
 * 						@RequestMapping("test") 也可写作  @RequestMapping("/test"),  有无  /  皆可
 * 				@Slf4j lombok的日志操作工具，注入log对象
 * 				@GetMapping 一般用于查询
 * 				@PostMapping 一般用于新增 ，  @PutMapping 一般用于 修改  ，实际上  @PostMapping 用途包括  @PutMapping
 * 				@DeleteMapping 一般用于删除
 */
@RestController
@RequestMapping("test")
@Slf4j
public class AnnotationController {
	
	// @GetMapping("testGet") 等价于  @RequestMapping(value = "testGet", method = RequestMethod.GET)
	// @RequestParam("param") String param ：   请求的参数格式为  .../test/testGet?param=值
	@GetMapping("testGet")
	public String testGet(@RequestParam("param") String param) {
		log.info("页面传来的参数为： {}", param);
		return "页面传来的参数为：  " + param;
	}
	
	// @PostMapping("testPost")  等价于   @RequestMapping(value = "testPost", method = RequestMethod.POST)
	// 多个@RequestParam接取参数的  格式为   .../test/testPost?param=值1&param2=值2
	@PostMapping("testPost")
	public String testPost(@RequestParam("param") String param, @RequestParam("param2") String param2) {
		log.info("页面传来的参数为： {},  {}", param, param2);
		return "页面传来的参数为：  " + param + "和"  + param2; 
	}
	
	// @PutMapping("testPut/{param}")  等价于   @RequestMapping(value = "testPut/{param}", method = RequestMethod.PUT)
	// @PathVariable("param") String param :  请求的参数格式  与  @PutMapping("testPut/{param}")统一， 即  .../test/testPut/值
	//     @PutMapping("testPut/{param}") 中参数位置可随意放， 如 	@PutMapping("{param}/testPut")
	@PutMapping("testPut/{param}")
	public String testPut(@PathVariable("param") String param) {
		log.info("页面传来的参数为： {}", param);
		return "页面传来的参数为：  " + param; 
	}
	
	// @DeleteMapping("testDelete") 等价于  @RequestMapping(value = "testDelete", method = RequestMethod.DELETE)
	// @RequestBody 接收请求的头部 content-type = application/json 或 application/xml， 接取的参数可以使对象， 数据类型， 集合
	@DeleteMapping("testDelete")
	public String testDelete(@RequestBody TestLombok tetstLombok) {
		log.info("页面传来的参数为： {}", tetstLombok);
		return "页面传来的参数为：  " + tetstLombok; 
	}

}
