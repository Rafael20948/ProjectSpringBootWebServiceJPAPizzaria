package com.project_java.demo.enums;

public enum TamanhoStatus {

	PEQUENA(1),
	MEDIA(2),
	GRANDE(3),
	SUPER_GRANDE(4);
	
	
	private int code;
	
	private TamanhoStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TamanhoStatus valueOf(int code) {
		for (TamanhoStatus value : TamanhoStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Ivalid OrderStatus code");
	}
}

	

