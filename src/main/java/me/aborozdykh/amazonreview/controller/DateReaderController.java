package me.aborozdykh.amazonreview.controller;

import java.util.List;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.service.DataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrii Borozdykh
 */
@Controller
@RequestMapping("/data")
public class DateReaderController {
    private final DataReader dataReader;

    @Autowired
    public DateReaderController(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    @GetMapping
    public List<ReviewRequestDto> getReviewsFromFile() {
        return dataReader.getDataFromFile();
    }
}
