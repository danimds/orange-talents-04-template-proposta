package br.com.zupacademy.dani.proposta.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {
    public ApiError(HttpStatus badRequest, String localizedMessage, List<String> errors) {
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
