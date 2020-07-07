package me.aborozdykh.amazonreview;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.service.DataReaderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
public class DataReaderServiceImplTest {
    @Autowired
    private DataReaderService dataReaderService;

    @Test
    public void hasCorrectFormatIsTrue() {
        String content = "Id,ProductId,UserId\n1,B001E4KFG0,A3SGXH7AUHU8GW";
        MockMultipartFile file
                = new MockMultipartFile("file",
                "test1.csv",
                "text/csv",
                content.getBytes());
        Assert.assertTrue(dataReaderService.hasCorrectFormat(file));
    }

    @Test
    public void hasCorrectFormatIsFalse() {
        String content = "Id,ProductId,UserId\n1,B001E4KFG0,A3SGXH7AUHU8GW";
        MockMultipartFile file
                = new MockMultipartFile("file",
                "test1.csv",
                "text/plain",
                content.getBytes());
        Assert.assertFalse(dataReaderService.hasCorrectFormat(file));
    }

    @Test
    public void getDataFromFileIsOk() {
        var inputStream = getClass().getClassLoader().getResourceAsStream("test1.csv");
        var actualReviewRequestDtoList = List.of(getReviewRequestDto());
        var expectedReviewRequestDtoList = dataReaderService.getDataFromFile(inputStream);

        Assert.assertEquals(actualReviewRequestDtoList, expectedReviewRequestDtoList);
    }

    private ReviewRequestDto getReviewRequestDto() {
        var reviewRequestDto = new ReviewRequestDto();

        reviewRequestDto.setId(Long.parseLong("1"));
        reviewRequestDto.setProductId("B001E4KFG0");
        reviewRequestDto.setUserId("A3SGXH7AUHU8GW");
        reviewRequestDto.setProfileName("delmartian");
        reviewRequestDto.setHelpfulnessNumerator(1);
        reviewRequestDto.setHelpfulnessDenominator(1);
        reviewRequestDto.setScore(Short.parseShort("5"));
        reviewRequestDto.setDateTime(LocalDateTime.ofInstant(
                Instant.ofEpochSecond(Long.parseLong("1303862400")),
                TimeZone.getDefault().toZoneId()));
        reviewRequestDto.setSummary("Good Quality Dog Food");
        reviewRequestDto.setText("I have bought several.");

        return reviewRequestDto;
    }
}
