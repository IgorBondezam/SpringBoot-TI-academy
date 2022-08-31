package br.com.tiacademy.vendas.core.crud;

public interface CrudConverter<T, D> {

    D entidadeParaDTO(T entidade);

    T dtoParaEntidade(D dto);

}
