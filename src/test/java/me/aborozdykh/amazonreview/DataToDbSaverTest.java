package me.aborozdykh.amazonreview;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import me.aborozdykh.amazonreview.entity.dto.ReviewRequestDto;
import me.aborozdykh.amazonreview.repository.ProductRepository;
import me.aborozdykh.amazonreview.repository.ReviewRepository;
import me.aborozdykh.amazonreview.repository.UserRepository;
import me.aborozdykh.amazonreview.util.DataToDbSaver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrii Borozdykh
 */
@SpringBootTest
@Transactional
public class DataToDbSaverTest {
    @Autowired
    private DataToDbSaver dataToDbSaver;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void saveUsersToDbIsOk() {
        dataToDbSaver.saveUsersToDb(getReviewRequestDtoList());
        var reviewRequestDto = getReviewRequestDtoList().get(0);
        var user = userRepository.getOne(reviewRequestDto.getUserId());

        Assert.assertEquals(reviewRequestDto.getUserId(), user.getId());
        Assert.assertEquals(reviewRequestDto.getProfileName(), user.getProfileName());
    }

    @Test
    public void saveProductsToDbIsOk() {
        dataToDbSaver.saveProductsToDb(getReviewRequestDtoList());
        var reviewRequestDto = getReviewRequestDtoList().get(0);
        var product = productRepository.getOne(reviewRequestDto.getProductId());

        Assert.assertEquals(reviewRequestDto.getProductId(), product.getId());
    }

    @Test
    public void saveReviewsToDbIsOk() {
        dataToDbSaver.saveUsersToDb(getReviewRequestDtoList());
        dataToDbSaver.saveProductsToDb(getReviewRequestDtoList());
        dataToDbSaver.saveReviewsToDb(getReviewRequestDtoList());
        var reviewRequestDto = getReviewRequestDtoList().get(0);
        var review = reviewRepository.getOne(reviewRequestDto.getId());

        Assert.assertEquals(reviewRequestDto.getId(), review.getId());
        Assert.assertEquals(reviewRequestDto.getDateTime(), review.getDateTime());
        Assert.assertEquals(reviewRequestDto.getHelpfulnessDenominator(), review.getHelpfulnessDenominator());
        Assert.assertEquals(reviewRequestDto.getHelpfulnessNumerator(), review.getHelpfulnessNumerator());
        Assert.assertEquals(reviewRequestDto.getScore(), review.getScore());
        Assert.assertEquals(reviewRequestDto.getSummary(), review.getSummary());
        Assert.assertEquals(reviewRequestDto.getText(), review.getText());
    }

    @Test
    public void saveToDbIsOk(){
        dataToDbSaver.saveToDb(getReviewRequestDtoList());
        var reviewRequestDto = getReviewRequestDtoList().get(0);
        var user = userRepository.getOne(reviewRequestDto.getUserId());
        var product = productRepository.getOne(reviewRequestDto.getProductId());
        var review = reviewRepository.getOne(reviewRequestDto.getId());

        Assert.assertEquals(reviewRequestDto.getUserId(), user.getId());
        Assert.assertEquals(reviewRequestDto.getProfileName(), user.getProfileName());
        Assert.assertEquals(reviewRequestDto.getProductId(), product.getId());
        Assert.assertEquals(reviewRequestDto.getId(), review.getId());
        Assert.assertEquals(reviewRequestDto.getDateTime(), review.getDateTime());
        Assert.assertEquals(reviewRequestDto.getHelpfulnessDenominator(), review.getHelpfulnessDenominator());
        Assert.assertEquals(reviewRequestDto.getHelpfulnessNumerator(), review.getHelpfulnessNumerator());
        Assert.assertEquals(reviewRequestDto.getScore(), review.getScore());
        Assert.assertEquals(reviewRequestDto.getSummary(), review.getSummary());
        Assert.assertEquals(reviewRequestDto.getText(), review.getText());
    }

    private List<ReviewRequestDto> getReviewRequestDtoList() {
        String id = "1";
        String productId = "B001E4KFG0";
        String userId = "A3SGXH7AUHU8GW";
        String profileName = "delmartian";
        String helpfulnessNumerator = "1";
        String helpfulnessDenominator = "1";
        String score = "5";
        String dateTime = "1303862400";
        String summary = "Good Quality Dog Food";
        String text = "1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian,1,1,5,1303862400,Good Quality Dog "
                + "Food,I have bought several of the Vitality canned dog food products and have "
                + "found them all to be of good quality. The product looks more like a stew than"
                + " a processed meat and it smells better. My Labrador is finicky and she "
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
                Instant.ofEpochSecond(Long.parseLong(dateTime)),
                TimeZone.getDefault().toZoneId()));
        reviewRequestDto.setSummary(summary);
        reviewRequestDto.setText(text);

        var reviewRequestDtoArrayList = new ArrayList<ReviewRequestDto>();
        reviewRequestDtoArrayList.add(reviewRequestDto);
        return reviewRequestDtoArrayList;
    }
}
