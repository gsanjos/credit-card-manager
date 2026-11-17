package io.github.gsanjos.planeja.dominio.cartao.dto;

import io.github.gsanjos.planeja.dominio.cartao.model.BandeiraCartao;

import java.time.LocalDateTime;

public record CartaoDetalhes(String id, String nome, BandeiraCartao bandeiraCartao, LocalDateTime dataCadastro) {
}
