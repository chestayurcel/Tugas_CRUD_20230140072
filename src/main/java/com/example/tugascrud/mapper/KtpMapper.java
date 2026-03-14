package com.example.tugascrud.mapper;

import com.example.tugascrud.dto.KtpDto;
import com.example.tugascrud.entity.Ktp;

public class KtpMapper {
    public static Ktp toEntity(KtpDto dto) {
        Ktp ktp = new Ktp();
        ktp.setId(dto.getId());
        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());
        return ktp;
    }
}