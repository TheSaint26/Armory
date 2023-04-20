package bg.softuni.armory.model.entity.views;

public class WeaponPictureAndNameViewDTO {
    private Long id;
    private String imageUrl;
    private String name;

    public WeaponPictureAndNameViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public WeaponPictureAndNameViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public WeaponPictureAndNameViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public WeaponPictureAndNameViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "PistolPictureAndNameViewDTO{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
