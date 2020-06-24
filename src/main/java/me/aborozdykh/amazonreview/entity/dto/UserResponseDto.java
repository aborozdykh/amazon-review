package me.aborozdykh.amazonreview.entity.dto;

/**
 * @author Andrii Borozdykh
 */
public class UserResponseDto {
    private String id;
    private String profileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
