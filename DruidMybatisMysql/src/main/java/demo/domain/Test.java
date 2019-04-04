package demo.domain;

/**
 * @author GrassPrince
 * @Da2019年4月3日 2019年4月3日 - 下午8:09:33
 * @Description Test
 */
public class Test {
	
	/**  唯一id */
	private String testId;
	
	/**  密码  */
	private String testPassword;
	
	/**  名称  */
	private String testName;


	public Test(String testId, String testPassword, String testName) {
		this.testId = testId;
		this.testPassword = testPassword;
		this.testName = testName;
	}
	
	public Test() {
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestPassword() {
		return testPassword;
	}

	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testPassword=" + testPassword + ", testName=" + testName + "]";
	}
	
	
}
