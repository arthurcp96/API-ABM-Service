package com.ar.sportclubcafe.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        // Subimos el archivo a Cloudinary
        // ObjectUtils.emptyMap() significa que no le pasamos opciones adicionales por ahora
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        
        // Obtenemos la URL segura (HTTPS) generada por Cloudinary
        return uploadResult.get("secure_url").toString();
    }
}