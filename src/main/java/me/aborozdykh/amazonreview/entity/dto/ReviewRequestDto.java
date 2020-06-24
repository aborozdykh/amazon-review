package me.aborozdykh.amazonreview.entity.dto;

import java.time.LocalDateTime;

/**
 * @author Andrii Borozdykh
 */
public class ReviewRequestDto {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private short score;
    private LocalDateTime dateTime;
    private String summary;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getHelpfulnessNumerator() {
        return helpfulnessNumerator;
    }

    public void setHelpfulnessNumerator(int helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
    }

    public int getHelpfulnessDenominator() {
        return helpfulnessDenominator;
    }

    public void setHelpfulnessDenominator(int helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
