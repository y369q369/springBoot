package demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
  * @author GrassPrince
  * @time   2019年3月24日 -上午12:15:05
  * @description:Model的使用，Model必须在方法参数中定义
  */
@RequestMapping("/Model")
@Controller
public class ModelController {
	
	//测试重定向
	@GetMapping("/model4")
	public String model4(Model model) {
		return "redirect:https://www.baidu.com";
	}
	
	//测试addAttribute(Object attributeValue)方法
	@GetMapping("/model1")
	public String model1(Model model) {
		// 对象值， 对象名为对象值所属类型
		model.addAttribute("addAttribute(Object attributeValue)");
		return "model";
	}
	
	//测试addAttribute(String attributeName, @Nullable Object attributeValue)方法
	@GetMapping("/model2")
	public String model2(Model model) {
		//  对象名,对象值
		model.addAttribute("content", "addAttribute(String attributeName, @Nullable Object attributeValue)");
		return "model";
	}
	
	//测试addAllAttributes(Map<String, ?> attributes)方法
	@GetMapping("/model3")
	public String model3(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("map", "addAllAttributes(Map<String, ?> attributes)");
		model.addAllAttributes(map);
		return "model";
	}

}
