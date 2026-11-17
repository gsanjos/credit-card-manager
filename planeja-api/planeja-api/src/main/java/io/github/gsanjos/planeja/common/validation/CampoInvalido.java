package io.github.gsanjos.planeja.common.validation;

/*
Esse record vai representar um campo e qual é o problema, por que aquele campo está inválido,
 */
public record CampoInvalido(String campo, String erro) {
}
