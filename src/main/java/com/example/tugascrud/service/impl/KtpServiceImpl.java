package com.example.tugascrud.service.impl;

import com.example.tugascrud.entity.Ktp;
import com.example.tugascrud.repository.KtpRepository;
import com.example.tugascrud.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository repository;

    @Override
    public Ktp create(Ktp ktp) {
        if (repository.existsByNomorKtp(ktp.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return repository.save(ktp);
    }

    @Override
    public List<Ktp> getAll() {
        return repository.findAll();
    }

    @Override
    public Ktp getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan"));
    }

    @Override
    public Ktp update(Integer id, Ktp ktpDetails) {
        Ktp ktp = getById(id);
        if (repository.existsByNomorKtpAndIdNot(ktpDetails.getNomorKtp(), id)) {
            throw new RuntimeException("Nomor KTP sudah dipakai orang lain!");
        }
        ktp.setNomorKtp(ktpDetails.getNomorKtp());
        ktp.setNamaLengkap(ktpDetails.getNamaLengkap());
        ktp.setAlamat(ktpDetails.getAlamat());
        ktp.setTanggalLahir(ktpDetails.getTanggalLahir());
        ktp.setJenisKelamin(ktpDetails.getJenisKelamin());
        return repository.save(ktp);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(getById(id));
    }
}