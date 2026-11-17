package io.github.gsanjos.planeja.dominio.cartao.dto;

import io.github.gsanjos.planeja.dominio.cartao.model.BandeiraCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CartaoForm(
        @NotBlank(message = "Campo obrigatório!")
        String nome,

        @NotNull(message = "Campo obrigatório!")
        BandeiraCartao bandeiraCartao) {
}

/*
data access object é um objeto para acessar dados.
dto é apenas para transferência de dados para carregar informações que você vai usar
para mapear para alguma entidade ou algo ou fazer alguma coisa do tipo
(representa o json)
*/