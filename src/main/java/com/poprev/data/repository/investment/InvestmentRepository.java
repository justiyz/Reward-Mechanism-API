package com.poprev.data.repository.investment;

import com.poprev.data.model.investment.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {

    List<Investment> findAllByUser_IdAndToken_Id(Long userId, Long tokenId);
    Optional<Investment> findByUser_IdAndToken_Id(Long userId, Long tokenId);
    Optional<Investment> findByIdAndUser_Id(Long investmentId, Long userId);
}
