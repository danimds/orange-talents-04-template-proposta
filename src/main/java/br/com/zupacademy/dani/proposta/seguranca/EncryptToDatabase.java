package br.com.zupacademy.dani.proposta.seguranca;

import org.springframework.security.crypto.encrypt.Encryptors;

import javax.persistence.AttributeConverter;

public class EncryptToDatabase implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String string) {
        try{
            return Encryptors.queryableText("${proposta.criptografia.secret}", "12345678").encrypt(string);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String string) {
        try{
            return Encryptors.queryableText("${proposta.criptografia.secret}", "12345678").decrypt(string);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
