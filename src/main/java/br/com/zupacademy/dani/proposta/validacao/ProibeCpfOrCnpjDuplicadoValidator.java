//package br.com.zupacademy.dani.proposta.validacao;
//
//import br.com.zupacademy.dani.proposta.controller.request.NovaPropostaRequest;
//import br.com.zupacademy.dani.proposta.modelo.NovaProposta;
//import br.com.zupacademy.dani.proposta.repository.NovaPropostaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.Optional;
//
//@Component
//public class ProibeCpfOrCnpjDuplicadoValidator implements Validator {
//
//    @Autowired
//    private NovaPropostaRepository novaPropostaRepository;
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return NovaPropostaRequest.class.isAssignableFrom(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        if(errors.hasErrors()) {
//            return;
//        }
//        NovaPropostaRequest request = (NovaPropostaRequest) o;
//        Optional<NovaProposta> possivelNovaProposta = novaPropostaRepository.findByDocumento(request.getDocumento());
//        if (possivelNovaProposta.isPresent()) {
//            errors.rejectValue("documento", null, "Já existe proposta para esse solicitante"
//                    + request.getDocumento());
//        }
//    }
//
//}
