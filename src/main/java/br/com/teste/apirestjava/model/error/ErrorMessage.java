package br.com.teste.apirestjava.model.error;

public class ErrorMessage {
    
    private String titulo;

    private Integer statusCode;
    

    
    public ErrorMessage(String titulo, Integer statusCode, String mensagem) {
        this.titulo = titulo;
        this.statusCode = statusCode;
        this.mensagem = mensagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;
}
