package io.github.gsanjos.planeja.dominio.cartao;

import io.github.gsanjos.planeja.common.validation.CampoInvalido;
import io.github.gsanjos.planeja.common.validation.ValidationResult;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoForm;
import io.github.gsanjos.planeja.dominio.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository cartaoRepository;

    public ValidationResult validar(CartaoForm form, UUID id) {
        var result = ValidationResult.novo();

        var isNonEmptyList = !cartaoRepository.findByNameAndNotId(form.nome(), id).isEmpty();
       if (isNonEmptyList) {
            result.add(new CampoInvalido("nome", "Já cadastrado!"));
       }

        return result;
    }
}
