package br.com.vitormelonunes.toll_records.adapters.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TollRecordRepository extends JpaRepository<TollRecordEntity, Long> {
}
