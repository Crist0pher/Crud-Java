package com.crud.generic.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.generic.GenericController;

@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<Long, User, UserRepository, UserService> {
}
