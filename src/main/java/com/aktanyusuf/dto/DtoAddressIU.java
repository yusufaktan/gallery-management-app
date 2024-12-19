package com.aktanyusuf.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddressIU{

	@NotNull
	private String city;
	
	@NotNull
	private String district;
	
	@NotNull
	private String neighborhood;
	
	@NotNull
	private String street;
	
}
