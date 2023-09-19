package main.service;

import dto.UserDto;

public interface LoginoutService {
	UserDto login(String userEmail, String userPassword);
}
