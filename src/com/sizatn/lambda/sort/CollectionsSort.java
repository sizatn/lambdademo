package com.sizatn.lambda.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sizatn.lambda.entity.Menu;

/**
 * 
 * @desc 
 * @author sizatn
 * @date Dec 17, 2017
 */
public class CollectionsSort {
	
	public static void main(String[] args) {
		
		List<Menu> list = new ArrayList<Menu>();
		
		Menu menu1 = new Menu();
		menu1.setMenuName("aaa");
		menu1.setMenuSort("0");
		
		Menu menu2 = new Menu();
		menu2.setMenuName("bbb");
		menu2.setMenuSort("3");
		
		Menu menu3 = new Menu();
		menu3.setMenuName("eee");
		menu3.setMenuSort("9");
		
		Menu menu4 = new Menu();
		menu4.setMenuName("hhh");
		menu4.setMenuSort("6");

		list.add(menu1);
		list.add(menu2);
		list.add(menu3);
		list.add(menu4);
		
		// asc(升序)
		list.sort((Menu o1, Menu o2) -> o1.getMenuSort().compareTo(o2.getMenuSort()));
		list.forEach((Menu o1) -> System.out.println(o1.toString()));
		
		System.out.println("");
		
		// desc(降序)
		list.sort((Menu o1, Menu o2) -> o2.getMenuSort().compareTo(o1.getMenuSort()));
		list.forEach(System.out::println);
		
		System.out.println("=========================");
		
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("count", 2);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("count", 4);
		
		mapList.add(map1);
		mapList.add(map2);
		
		mapList.sort((Map<String, Object> o1, Map<String, Object> o2) -> Integer
				.valueOf(o1.get("count").toString()) > Integer.valueOf(o2.get("count").toString()) ? -1 : 1);
		mapList.forEach((Map<String, Object> o) -> System.out.println(o.toString()));

		System.out.println("=========================");
		
//		Collections.sort(list, new Comparator<Menu>() {
//			@Override
//			public int compare(Menu o1, Menu o2) {
//				return o1.getMenuSort().compareTo(o2.getMenuSort());
//			}
//		});
		
	}

}
