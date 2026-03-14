package com.example.tugascrud.service;

import com.example.tugascrud.entity.Ktp;
import java.util.List;

public interface KtpService {
    Ktp create(Ktp ktp);
    List<Ktp> getAll();
    Ktp getById(Integer id);
    Ktp update(Integer id, Ktp ktp);
    void delete(Integer id);
}