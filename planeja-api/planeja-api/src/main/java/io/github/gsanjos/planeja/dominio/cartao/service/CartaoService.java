package io.github.gsanjos.planeja.dominio.cartao.service;

import io.github.gsanjos.planeja.common.exceptions.RecordNotFoundException;
import io.github.gsanjos.planeja.common.exceptions.ValidationException;
import io.github.gsanjos.planeja.dominio.cartao.CartaoValidator;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoDetalhes;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoForm;
import io.github.gsanjos.planeja.dominio.cartao.mapper.CartaoMapper;
import io.github.gsanjos.planeja.dominio.cartao.model.CartaoEntity;
import io.github.gsanjos.planeja.dominio.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    private CartaoValidator cartaoValidator;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private CartaoMapper cartaoMapper;

    public CartaoDetalhes criar(CartaoForm form) {
        var result = cartaoValidator.validar(form, null);

        if(result.isInvalido()) {
            throw new ValidationException(result.getCampoInvalidos());
        }

        CartaoEntity entity = cartaoMapper.toEntity(form);
        cartaoRepository.save(entity);

        return cartaoMapper.toDetalhes(entity);
    }

    public CartaoDetalhes obterDetalhes(UUID id) {
        return cartaoRepository
                .findById(id)
                .map(cartaoMapper::toDetalhes)
                .orElseThrow(RecordNotFoundException::new);
    }


    public List<CartaoDetalhes> list() {
        List<CartaoEntity> cartaoEntityList = cartaoRepository.findAll();

        return cartaoEntityList.stream().map(cartaoMapper::toDetalhes).toList();
    }

    @Transactional
    public void update(UUID id, CartaoForm form) {
        var cardExists = cartaoRepository
                .findById(id)
                .orElseThrow(RecordNotFoundException::new);

        var result = cartaoValidator.validar(form, id);

        if (result.isInvalido()) {
            throw new ValidationException(result.getCampoInvalidos());
        }

        cartaoMapper.update(cardExists, form);

        cartaoRepository.save(cardExists);
    }
}
