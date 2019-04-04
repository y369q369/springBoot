package demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import demo.domain.Test;

/**
 * @author GrassPrince
 * @Da2019年4月3日 2019年4月3日 - 下午7:53:50
 * @Description 测试的mapper
 */
public interface TestMapper {

	/** 根据testId查询test */
	List<Test> queryById(@Param("testId") String testId);

	/** 根据testId删除test */
	Integer deleteById(@Param("testId") String testId);

	/** 批量删除 */
	Integer deleteIds(@Param("testIds") String[] deleteIds);

	/** 修改test */
	Integer updateTest(Test test);

	/** 新增test */
	Integer add(Test test);


}
