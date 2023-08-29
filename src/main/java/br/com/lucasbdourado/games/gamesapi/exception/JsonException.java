package br.com.lucasbdourado.games.gamesapi.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class JsonException {
    private String message;

    public JsonException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "JsonException{" +
                "message='" + message + '\'' +
                '}';
    }
}
