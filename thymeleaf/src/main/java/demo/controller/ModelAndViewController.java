package demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
  * @author GrassPrince
  * @time   2019年3月23日 -下午9:01:57
  * @description:测试ModelAndView的模型
  */
@RequestMapping("/ModelAndView")
@Controller
public class ModelAndViewController {
	
	//测试new ModelAndView(String viewName)构造方法
	@GetMapping("/modelAndView1")
	public ModelAndView modelAndView1() {
		//new ModelAndView("/modelAndView")和new ModelAndView("modelAndView")都可以
//		return new ModelAndView("/modelAndView");
		return new ModelAndView("modelAndView");
		//重定向的地址注意，完全地址且前面需要加/
//		return new ModelAndView("redirect:/ModelAndView/modelAndView2");
	}
	
	//测试ModelAndView(String viewName, String modelName, Object modelObject)构造方法
	@GetMapping("/modelAndView2")
	public ModelAndView modelAndView2() {
		return new ModelAndView("/modelAndView", "model2", "modelObject  2");
	} 
	
	//测试ModelAndView(String viewName, @Nullable Map<String, ?> model)构造方法
	@GetMapping("/modelAndView3")
	public ModelAndView modelAndView3(Map<String, Object> map) {
		map.put("map1", "obj 1");
		map.put("map2", "obj 2");
		return new ModelAndView("modelAndView", map);
	}
	
	//测试addObject(String attributeName, @Nullable Object attributeValue)
	//	  addObject(Object attributeValue)方法
	@GetMapping("/modelAndView4")
	public ModelAndView modelAndView4() {
		ModelAndView mav = new ModelAndView();
		//设置返回的url
		mav.setViewName("modelAndView");
		//变量名, 变量值
		mav.addObject("obj1", "modelObject  4");
		// 变量值(变量名为变量值的所属类的类名)
		mav.addObject("modelObject  5");
		return mav;
	}
}
