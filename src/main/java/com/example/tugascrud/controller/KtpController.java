package com.example.tugascrud.controller;

import com.example.tugascrud.dto.KtpDto;
import com.example.tugascrud.entity.Ktp;
import com.example.tugascrud.mapper.KtpMapper;
import com.example.tugascrud.service.KtpService;
import com.example.tugascrud.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody KtpDto dto) {
        try {
            Ktp created = service.create(KtpMapper.toEntity(dto));
            return ResponseUtil.build("success", "Data berhasil ditambahkan", created, 201);
        } catch (Exception e) {
            return ResponseUtil.build("error", e.getMessage(), null, 400);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseUtil.build("success", "Data ditemukan", service.getAll(), 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseUtil.build("success", "Data ditemukan", service.getById(id), 200);
        } catch (Exception e) {
            return ResponseUtil.build("error", e.getMessage(), null, 404);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody KtpDto dto) {
        try {
            Ktp updated = service.update(id, KtpMapper.toEntity(dto));
            return ResponseUtil.build("success", "Data berhasil diubah", updated, 200);
        } catch (Exception e) {
            return ResponseUtil.build("error", e.getMessage(), null, 400);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseUtil.build("success", "Data berhasil dihapus", null, 200);
        } catch (Exception e) {
            return ResponseUtil.build("error", e.getMessage(), null, 404);
        }
    }
}