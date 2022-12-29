package exam.test.core.common.code;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonCodeEnumMapper {
	
	@Bean
	public CommonCodeMapperFactory createCommonCodeMapperFactory() {
		CommonCodeMapperFactory commonCodeMapperFactory = new CommonCodeMapperFactory(new LinkedHashMap<>());
		commonCodeMapperFactory.put("CommonCodeLists", CommonCodeLists.class);
		return commonCodeMapperFactory;
	}

}