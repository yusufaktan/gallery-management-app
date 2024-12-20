package com.aktanyusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoGalleristCarIU {

	@NotNull
	private Long galleristId;

	@NotNull
	private Long carId;

}
