package br.com.desafio.find.Desafio.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class People {

    @Id
    @SequenceGenerator( name = "usuario_sequence", sequenceName = "usuario_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private Long id;
    @Column(name="email")
    private String email;
    @Column(name="numero")
    private int numero;
    @Column(name = "resultado")
    private String resultado;
    @Column(name = "data")
    private LocalDate data;

    public People() {
    }

    public People(Long id, String email, int numero) {
        this.id = id;
        this.email = email;
        this.numero = numero;
    }

    public People(String email, int numero) {
        this.email = email;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getResultado() {
        this.resultado = "";
        if(this.numero % 3 == 0){
            this.resultado += "Fizz";
        }
        if(this.numero % 5 == 0){
            this.resultado += "Buzz";
        }
        if(this.resultado == "")
            this.resultado = String.valueOf(this.numero);
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getData() {
        return LocalDate.now();
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", numero=" + numero +
                ", resultado='" + resultado + '\'' +
                ", data=" + data +
                '}';
    }
}
