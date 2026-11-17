package io.github.gsanjos.planeja.dominio.cartao.service;

import io.github.gsanjos.planeja.common.exceptions.ValidationException;
import io.github.gsanjos.planeja.dominio.cartao.CartaoValidator;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoDetalhes;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoForm;
import io.github.gsanjos.planeja.dominio.cartao.mapper.CartaoMapper;
import io.github.gsanjos.planeja.dominio.cartao.model.CartaoEntity;
import io.github.gsanjos.planeja.dominio.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator cartaoValidator;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoMapper cartaoMapper;

    public CartaoDetalhes criar(CartaoForm form) {
        var result = cartaoValidator.validar(form);

        if(result.isInvalido()) {
            throw new ValidationException(result.getCampoInvalidos());
        }

        CartaoEntity entity = cartaoMapper.toEntity(form);
        cartaoRepository.save(entity);

        return cartaoMapper.toDetalhes(entity);
    }
}
