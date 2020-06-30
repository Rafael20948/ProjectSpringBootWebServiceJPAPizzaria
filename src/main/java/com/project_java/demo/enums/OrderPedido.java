package com.project_java.demo.enums;

public enum OrderPedido {

	MAXIMA(1),
	MEDIA(2),
	MINIMA(3);
	
	private int code;
	
	private OrderPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderPedido valueOf(int code) {
		for (OrderPedido value : OrderPedido.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Ivalid OrderStatus code");
	}
}

	

