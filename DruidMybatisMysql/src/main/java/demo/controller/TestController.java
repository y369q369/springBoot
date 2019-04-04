package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.domain.Test;
import demo.service.TestService;

/**
 * @author GrassPrince
 * @Da2019年4月3日 2019年4月3日 - 下午7:42:54
 * @Description 测试  controller ： 增删改查
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	// 跳转到测试页面
	@GetMapping("/testHtml")
	public ModelAndView testHtml() {
		return new ModelAndView("test");
	}
	
	// 根据testId查询test
	@PostMapping("/queryById")
	@ResponseBody
	public List<Test> queryById(@RequestParam ("testId") String testId) {
		return testService.queryById(testId);
	}
	
	// 根据testId删除test
	@DeleteMapping("/deleteById")
	@ResponseBody
	public String deleteById(@RequestParam("testId") String testId) {
		Integer deleteNum = testService.deleteById(testId);
		if(deleteNum == 0) {
			return "删除失败";
		}
		return "删除成功";
	}
	
	//批量删除
	@DeleteMapping("/deleteIds")
	@ResponseBody
	public String deleteIds(@RequestParam("testIds") String testIds) {
		Integer deleteNum = testService.deleteIds(testIds);
		if(deleteNum == 0) {
			return "删除失败";
		}
		return "删除成功";
	}
	
	// 修改test
	@PutMapping("/updateTest")
	@ResponseBody
	public String updateTest(Test test) {
		Integer updateNum = testService.updateTest(test);
		if(updateNum == 0) {
			return "更新失败";
		}
		return "更新成功";
	}
	
	// 新建一个test 
	@PostMapping("/add")
	@ResponseBody
	public String add(Test test) {
		Integer addNum = testService.add(test);
		if(addNum == 0) {
			return "新增失败";
		}
		return "新增成功";
	}
}
