package com.test.class0701_scan.myscan;


import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haifuns
 * @date 2025-01-09 10:25
 */
public class MyScanner {

	public List<String> listName = new ArrayList<>();
	public Map<String, AbstractBeanDefinition> map = new HashMap<>();

	public void scan(String packageName) throws ClassNotFoundException {
		// 当前目录
		File f = new File(this.getClass().getResource("/").getPath());
		// 类的存放路径
		String rootpath = f.getPath();
		// 包名对应的路径
		String scanPath = packageName.replaceAll("\\.", "/");
		rootpath = rootpath + "/" + scanPath;
		File rootDir = new File(rootpath);
		String[] list = rootDir.list();
		for (String s : list) {
			s = s.replaceAll(".class", "");
			String beanName = s.toLowerCase();
			s = packageName + "." + s;
			// 反射加载类
			Class<?> clazz = Class.forName(s);
			// 有没有加@Component
			if (clazz.isAnnotationPresent(Component.class)) {
				GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
				beanDefinition.setBeanClass(clazz);
				if (clazz.isAnnotationPresent(Scope.class)) {
					beanDefinition.setScope(clazz.getAnnotation(Scope.class).value());
				}
				map.put(beanName, beanDefinition);
				listName.add(beanName);
			}
		}
	}

	public List<String> getListName() {
		return listName;
	}

	public Map<String, AbstractBeanDefinition> getMap() {
		return map;
	}
}