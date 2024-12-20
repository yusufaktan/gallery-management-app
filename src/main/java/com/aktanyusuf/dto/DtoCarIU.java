package com.aktanyusuf.dto;

import java.math.BigDecimal;

import com.aktanyusuf.enums.CarStatusType;
import com.aktanyusuf.enums.CurrencyType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoCarIU {

	@NotNull
	private String plaka;

	@NotNull
	private String brand;

	@NotNull
	private String model;

	@NotNull
	private Integer productionYear;

	@NotNull
	private BigDecimal price;

	@NotNull
	private CurrencyType currencyType;

	@NotNull
	private BigDecimal damagePrice;

	@NotNull
	private CarStatusType carStatusType;

}
