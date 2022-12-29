package exam.test.core.common.code;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonCodeMapperFactory {
	private Map<String, List<CommonCodeMapperValue>> factory;

	public void put(String key, Class<? extends CommonCodeMapperType> e) {
		factory.put(key, toEnumValues(e));
	}
	
	public List<CommonCodeMapperValue> get(String key) {
		return factory.get(key);
	}
	
	private List<CommonCodeMapperValue> toEnumValues(Class<? extends CommonCodeMapperType> e) {
		return Arrays.stream(e.getEnumConstants()).map(CommonCodeMapperValue::new).collect(Collectors.toList());
				
	}
}
