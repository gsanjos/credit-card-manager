package io.github.gsanjos.planeja.infra;

import io.github.gsanjos.planeja.dominio.cartao.model.BandeiraCartao;
import io.github.gsanjos.planeja.dominio.cartao.model.CartaoEntity;
import io.github.gsanjos.planeja.dominio.cartao.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
E aqui dentro esse Sandbox vai servir pra gente fazer nossa sala de experimento

Da gente executar coisas aqui que não vai fazer parte do projeto, mas eu quero executar
pra fazer testes, por exemplo
 */
@Component
public class SandBox implements CommandLineRunner {

    @Autowired
    private CartaoRepository cartaoRepository;

    public void salvarCartao() {

        CartaoEntity cartao = new CartaoEntity();
        cartao.setNome("Teste");
        cartao.setBandeiraCartao(BandeiraCartao.ELO);

        cartaoRepository.save(cartao);
    }

    @Override
    public void run(String... args) throws Exception {
  //      salvarCartao();
    }
}
