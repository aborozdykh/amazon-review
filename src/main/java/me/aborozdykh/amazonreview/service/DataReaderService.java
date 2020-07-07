package me.aborozdykh.amazonreview.service;

import java.io.InputStream;
import java.util.List;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import org.springframework.web.multipart.MultipartFile;

public interface DataReaderService {
    boolean hasCorrectFormat(MultipartFile file);

    List<ReviewRequestDto> getDataFromFile(InputStream inputStream);
}
