package me.aborozdykh.amazonreview.service;

import java.util.List;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;

public interface DataReader {
    List<ReviewRequestDto> getDataFromFile();
}
