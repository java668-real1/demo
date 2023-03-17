package com.java668.springboot.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * 此SQL注入器继承了DefaultSqlInjector(默认注入器)
 */

/**
 * @author chenjiawei
 * @desc mybatis-plus此SQL注入器继承了DefaultSqlInjector(默认注入器)
 * @date 2022/04/19 17:54
 **/
public class EasySqlInjector extends DefaultSqlInjector {


	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		// 注意：此SQL注入器继承了DefaultSqlInjector(默认注入器)，调用了DefaultSqlInjector的getMethodList方法，保留了mybatis-plus的自带方法
		List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
		methodList.add(new InsertBatchSomeColumn(i -> i.getFieldFill() != FieldFill.UPDATE));
		return methodList;
	}

}