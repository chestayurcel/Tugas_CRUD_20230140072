package com.example.tugascrud.repository;

import com.example.tugascrud.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KtpRepository extends JpaRepository<Ktp, Integer> {
    boolean existsByNomorKtp(String nomorKtp);
    boolean existsByNomorKtpAndIdNot(String nomorKtp, Integer id);
}