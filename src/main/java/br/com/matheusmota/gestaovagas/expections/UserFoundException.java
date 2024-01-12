package br.com.matheusmota.gestaovagas.expections;

public class UserFoundException extends RuntimeException{
    public UserFoundException() {
        super("Usuário já existe");
    }
}
