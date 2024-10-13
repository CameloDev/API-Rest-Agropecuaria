package br.camelodev.teste.infra;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.HibernateError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.AbstractBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.zip.DataFormatException;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> Tratador404() {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> Tratador400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> Tratador500() {
        return ResponseEntity.badRequest().build();
    }
    @ExceptionHandler(HibernateError.class)
    public ResponseEntity<?> tratadorHibernate(HibernateError ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> tratadorSQL(SQLException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    public record DadosErros(String campo, String mensagem) {
        public DadosErros(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());

        }
    }

}
