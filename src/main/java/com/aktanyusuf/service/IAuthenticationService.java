package com.aktanyusuf.service;

import com.aktanyusuf.dto.AuthRequest;
import com.aktanyusuf.dto.AuthResponse;
import com.aktanyusuf.dto.DtoUser;
import com.aktanyusuf.dto.RefreshTokenRequest;

public interface IAuthenticationService {

	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
	
	public AuthResponse refreshToken(RefreshTokenRequest input);
	
}
