package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailAndPassword(@NotNull String email, @NotNull String password);

    User findByEmail(@NotNull String email);
}
