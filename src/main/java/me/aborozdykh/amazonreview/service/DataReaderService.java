package me.aborozdykh.amazonreview.service;

import org.springframework.web.multipart.MultipartFile;

public interface DataReaderService {
    void save(MultipartFile file);

    boolean hasCorrectFormat(MultipartFile file);
}
