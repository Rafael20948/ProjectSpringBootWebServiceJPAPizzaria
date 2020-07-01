package com.project_java.demo.enums;

public enum BebidaStatus {

	CERVEJA(1),
	REFRIGERANTE(2),
	SUCO(3),
	CAIPIRINHA(4);
	
	private int code;
	
	private BebidaStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static BebidaStatus valueOf(int code) {
		for (BebidaStatus value : BebidaStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Ivalid OrderStatus code");
	}
}

	

