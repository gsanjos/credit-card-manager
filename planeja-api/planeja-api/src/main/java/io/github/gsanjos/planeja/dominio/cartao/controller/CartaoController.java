package io.github.gsanjos.planeja.dominio.cartao.controller;

import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoDetalhes;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoForm;
import io.github.gsanjos.planeja.dominio.cartao.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CartaoDetalhes> criar(@RequestBody @Valid CartaoForm form) {
        CartaoDetalhes cartaoDetalhes = cartaoService.criar(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDetalhes);
    }
}
