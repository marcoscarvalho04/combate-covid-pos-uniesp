package br.com.covid.presenter.repository;

import br.com.covid.presenter.domain.LocalizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<LocalizacaoEntity, Long> {
}
