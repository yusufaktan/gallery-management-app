package com.aktanyusuf.controller;

import com.aktanyusuf.controller.impl.RootEntity;
import com.aktanyusuf.dto.AuthRequest;
import com.aktanyusuf.dto.AuthResponse;
import com.aktanyusuf.dto.DtoUser;
import com.aktanyusuf.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);
	
	public RootEntity<AuthResponse> authenticate(AuthRequest input);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
	
}
