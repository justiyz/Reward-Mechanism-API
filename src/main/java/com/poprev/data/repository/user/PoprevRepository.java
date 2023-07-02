package com.poprev.data.repository.user;

import com.poprev.data.model.user.PoprevUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoprevRepository extends JpaRepository<PoprevUser, Long> {
}
