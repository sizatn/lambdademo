package com.sizatn.lambda.constructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.sizatn.lambda.entity.Menu;

public class MapObject {
	
	static Map<String, Function<String, Menu>> map = new HashMap<String, Function<String, Menu>>();
	
	static {
		map.put("aa", Menu::new);
		map.put("bb", Menu::new);
		map.put("cc", Menu::new);
	}
	
	public static Menu createMenu(String menu, String menuName) {
		return map.get(menu.toLowerCase()).apply(menuName);
	}

}
