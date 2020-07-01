package com.project_java.demo.enums;

public enum PizzaStatus {

	SIM(1),
	NÃO(2);
	
	private int code;
	
	private PizzaStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PizzaStatus valueOf(int code) {
		for (PizzaStatus value : PizzaStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Ivalid OrderStatus code");
	}
}

	

