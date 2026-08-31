package com.ryanteles.user_management_api.exception;

public class UsuarioNotFoundException extends RuntimeException{

    public UsuarioNotFoundException (String mensagem){
        super(mensagem);
    }
}
