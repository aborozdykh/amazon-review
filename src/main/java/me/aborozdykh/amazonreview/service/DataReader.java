package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import org.springframework.web.multipart.MultipartFile;

public interface DataReader {
    void save(MultipartFile file);
}
