package com.project_java.demo.enums;

public enum PedidoStatus {

	MAXIMA(1),
	MEDIA(2),
	MINIMA(3);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Ivalid OrderStatus code");
	}
}

	

