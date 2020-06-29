package me.aborozdykh.amazonreview;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public void getDataFromFileIsOk() throws IOException {
        String id = "1";
        String productId = "B001E4KFG0";
        String userId = "A3SGXH7AUHU8GW";
        String profileName = "delmartian";
        String helpfulnessNumerator = "1";
        String helpfulnessDenominator = "1";
        String score = "5";
        String time = "1303862400";
        String summary = "Good Quality Dog Food";
        String text = "I have bought several of the Vitality canned dog food products and have "
                + "found them all to be of good quality. The product looks more like a stew than "
                + "a processed meat and it smells better. My Labrador is finicky and she "
                + "appreciates this product better than  most.";

        var reviewRequestDto = new ReviewRequestDto();
        reviewRequestDto.setId(Long.parseLong(id));
        reviewRequestDto.setProductId(productId);
        reviewRequestDto.setUserId(userId);
        reviewRequestDto.setProfileName(profileName);
        reviewRequestDto.setHelpfulnessNumerator(
                Integer.parseInt(helpfulnessNumerator));
        reviewRequestDto.setHelpfulnessDenominator(
                Integer.parseInt(helpfulnessDenominator));
        reviewRequestDto.setScore(Short.parseShort(score));
        reviewRequestDto.setDateTime(LocalDateTime.ofInstant(
                Instant.ofEpochSecond(Long.parseLong(time)),
                TimeZone.getDefault().toZoneId()));
        reviewRequestDto.setSummary(summary);
        reviewRequestDto.setText(text);

        var actualReviewRequestDtoList = new ArrayList<ReviewRequestDto>();
        actualReviewRequestDtoList.add(reviewRequestDto);

        String content = "Id,ProductId,UserId,ProfileName,HelpfulnessNumerator,"
                + "HelpfulnessDenominator,Score,Time,Summary,Text\n"
                + "1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian,1,1,5,1303862400,Good Quality Dog Food,"
                + "I have bought several of the Vitality canned dog food products and have found "
                + "them all to be of good quality. The product looks more like a stew than a "
                + "processed meat and it smells better. My Labrador is finicky and she appreciates"
                + " this product better than  most.";
        MockMultipartFile file
                = new MockMultipartFile("file",
                "test1.csv",
                "text/plain",
                content.getBytes());

        var expectedReviewRequestDtoList = dataReaderService.getDataFromFile(file.getInputStream());
        Assert.assertEquals(actualReviewRequestDtoList, expectedReviewRequestDtoList);
    }
}
