package com.stylesstock.stylestock.repository;

import com.stylesstock.stylestock.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
