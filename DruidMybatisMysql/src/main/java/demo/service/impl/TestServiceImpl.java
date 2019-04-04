package demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Test;
import demo.mapper.TestMapper;
import demo.service.TestService;

/**
 * @author GrassPrince
 * @Da2019年4月3日 2019年4月3日 - 下午7:51:26
 * @Description 测试的 service实现类
 */
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestMapper testMapper;

	/** 根据testId查询test */
	@Override
	public List<Test> queryById(String testId) {
		return testMapper.queryById(testId);
	}

	/** 根据testId删除test */
	@Override
	public Integer deleteById(String testId) {
		return testMapper.deleteById(testId);
	}
	
	/** 批量删除 */
	@Override
	public Integer deleteIds(String testIds) {
		String[] deleteIds = testIds.split(",");
		return testMapper.deleteIds(deleteIds);
	}

	/** 修改test */
	@Override
	public Integer updateTest(Test test) {
		return testMapper.updateTest(test);
	}

	/** 新增test */
	@Override
	public Integer add(Test test) {
		// 用uuid设置随机的主键id
		test.setTestId(UUID.randomUUID().toString().replace("-", ""));
		return testMapper.add(test);
	}


	
}
