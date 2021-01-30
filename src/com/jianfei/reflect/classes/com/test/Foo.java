package com.jianfei.reflect.classes.com.test;

public class Foo {
	private int id;
	private String name;

	public int computeFreightFee(int weight) {
		int result = 0;
		if (weight > 1)
		{
			int addWeight = weight - 1;
			int AddWightFee = addWeight * 8;
			result = 9 + addWeight;
		} else {
			result = 9;
		}
		return result;
	}
}
