package com.sizatn.lambda.constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import com.sizatn.lambda.entity.Menu;

/**
 * 
 * @desc 
 * @author sizatn
 * @date Dec 17, 2017
 */
public class NewObject {
	
	public static void main(String[] args) {
		
		// no param
		Supplier<Menu> c1 = () -> new Menu();
		Menu m1 = c1.get();
		
		Supplier<Menu> c2 = Menu::new;
		Menu m2 = c2.get();
		
		// one param
		Function<String, Menu> c3 = (menuName) -> new Menu(menuName);
		Menu m3 = c3.apply("aa");
		
		Function<String, Menu> c4 = Menu::new;
		Menu m4 = c4.apply("aa");
		
		List<String> nameList = Arrays.asList("aa", "bb", "cc", "dd");
		List<Menu> menus = map(nameList, Menu::new);
		
		// two or more params
		BiFunction<String, String, Menu> c5 = (menuName, menuSort) -> new Menu(menuName, menuSort);
		Menu m5 = c5.apply("aa", "10");
		
		BiFunction<String, String, Menu> c6 = Menu::new;
		Menu m6 = c6.apply("aa", "10");
		
	}

	private static List<Menu> map(List<String> nameList, Function<String, Menu> f) {
		List<Menu> menuList = new ArrayList<Menu>();
		for (String name : nameList) {
			menuList.add(f.apply(name));
		}
		return menuList;
	}

}
