package com.aktanyusuf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddress extends DtoBase{
	
	private String city;
	
	private String district;
	
	private String neighborhood;
	
	private String street;

}
