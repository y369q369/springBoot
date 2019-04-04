package demo.service;

import java.util.List;

import demo.domain.Test;

/**
 * @author GrassPrince
 * @Da2019年4月3日 2019年4月3日 - 下午7:50:50
 * @Description 测试的service接口
 */
public interface TestService {

	/** 根据testId查询test */
	List<Test> queryById(String testId);

	/** 根据testId删除test */
	Integer deleteById(String testId);

	/** 批量删除 */
	Integer deleteIds(String testIds);

	/** 修改test */
	Integer updateTest(Test test);

	/** 新增test */
	Integer add(Test test);


}
