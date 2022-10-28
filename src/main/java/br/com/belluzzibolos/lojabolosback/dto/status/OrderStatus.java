package br.com.belluzzibolos.lojabolosback.dto.status;

public enum OrderStatus {
    CANCELADO("CANCELADO"),
    PENDENTE("PENDENTE"),
    APROVADO("APROVADO"),
    FINALIZAZDO("FINALIZADO");

    private String descricao;

    OrderStatus(String descricao){
        this.descricao = descricao;
    }

}
