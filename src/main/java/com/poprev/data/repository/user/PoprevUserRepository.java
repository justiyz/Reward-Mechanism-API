package com.poprev.data.repository.user;

import com.poprev.data.model.user.PoprevUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoprevUserRepository extends JpaRepository<PoprevUser, Long> {

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);

    Optional<PoprevUser> findByUsername(String username);
    Optional<PoprevUser> findByEmail(String email);

}
