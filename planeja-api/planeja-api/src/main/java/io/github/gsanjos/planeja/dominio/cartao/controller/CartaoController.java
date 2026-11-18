package io.github.gsanjos.planeja.dominio.cartao.controller;

import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoDetalhes;
import io.github.gsanjos.planeja.dominio.cartao.dto.CartaoForm;
import io.github.gsanjos.planeja.dominio.cartao.model.CartaoEntity;
import io.github.gsanjos.planeja.dominio.cartao.service.CartaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<CartaoDetalhes> criar(@RequestBody @Valid CartaoForm form) {
        CartaoDetalhes cartaoDetalhes = cartaoService.criar(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDetalhes);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartaoDetalhes> obterDetalhes(@PathVariable UUID id) {
        var result = cartaoService.obterDetalhes(id);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping
    public List<CartaoDetalhes> buscar() {
        return cartaoService.list();
        
   }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody CartaoForm form) {
        cartaoService.update(id, form);
        return ResponseEntity.noContent().build();
    }

}
