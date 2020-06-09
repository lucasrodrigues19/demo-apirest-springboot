package com.lrvendas.springbootex.enums;

public enum OrderStatus {

	WAITTING_PAYAMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Codigo invalido para o status do pedido");
	}
}
