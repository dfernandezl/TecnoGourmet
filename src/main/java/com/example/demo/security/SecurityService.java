package com.example.demo.security;

import com.example.demo.Domini.Usuari;

public interface SecurityService {

    void login(String username, String password);

    void insertUser(Usuari user);
}
