package me.aborozdykh.amazonreview.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.entity.mappers.ProductMapper;
import me.aborozdykh.amazonreview.entity.mappers.ReviewMapper;
import me.aborozdykh.amazonreview.entity.mappers.UserMapper;
import me.aborozdykh.amazonreview.service.DataReaderService;
import me.aborozdykh.amazonreview.service.ProductService;
import me.aborozdykh.amazonreview.service.ReviewService;
import me.aborozdykh.amazonreview.service.UserService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Andrii Borozdykh
 */
@Service
public class DataReaderServiceImpl implements DataReaderService {
    private static final String TYPE = "text/csv";
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;
    private final UserService userService;
    private final ProductService productService;
    private final ReviewService reviewService;

    public DataReaderServiceImpl(UserMapper userMapper,
                                 ProductMapper productMapper,
                                 ReviewMapper reviewMapper,
                                 UserService userService,
                                 ProductService productService,
                                 ReviewService reviewService) {
        this.userMapper = userMapper;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
        this.userService = userService;
        this.productService = productService;
        this.reviewService = reviewService;
    }

    @Override
    public boolean hasCorrectFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    @Override
    public List<ReviewRequestDto> getDataFromFile(InputStream is) {
        try (
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());) {

            var reviewRequestDtoList = new ArrayList<ReviewRequestDto>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                var reviewRequestDto = new ReviewRequestDto();
                reviewRequestDto.setId(Long.parseLong(csvRecord.get("Id")));
                reviewRequestDto.setProductId(csvRecord.get("ProductId"));
                reviewRequestDto.setUserId(csvRecord.get("UserId"));
                reviewRequestDto.setProfileName(csvRecord.get("ProfileName"));
                reviewRequestDto.setHelpfulnessNumerator(
                        Integer.parseInt(csvRecord.get("HelpfulnessNumerator")));
                reviewRequestDto.setHelpfulnessDenominator(
                        Integer.parseInt(csvRecord.get("HelpfulnessDenominator")));
                reviewRequestDto.setScore(Short.parseShort(csvRecord.get("Score")));
                reviewRequestDto.setDateTime(LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(Long.parseLong(csvRecord.get("Time"))),
                        TimeZone.getDefault().toZoneId()));
                reviewRequestDto.setSummary(csvRecord.get("Summary"));
                reviewRequestDto.setText(csvRecord.get("Text"));
                reviewRequestDtoList.add(reviewRequestDto);
            }
            return reviewRequestDtoList;
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
        }
    }
}
