package demo.vo;

import lombok.Data;

/**
 * @author GrassPrince
 * @Da2019年4月5日 2019年4月5日 - 上午9:57:55
 * @Description 测试lombok的@data注解
 * 		@data : 包含Getter/Setter/无参构造/ToString
 * 		@Getter、@Setter等都是单个功能
 */
@Data
public class TestLombok {
	
	private String cup;
	
	private String briefs;

}
