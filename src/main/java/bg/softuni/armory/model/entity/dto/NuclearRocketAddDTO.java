package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NuclearRocketAddDTO {
    @NotBlank(message = "Please, enter bomb name!")
    @Size(min = 2, message = "Name must contain at least 2 characters!")
    private String name;
    @NotBlank(message = "Please, enter a country that has used this weapon!")
    @Size(min = 2, message = "Name must contain at least 2 characters!")
    private String usedBy;
    private Integer mass;
    private Double length;
    private Double blastYield;
    @NotBlank(message = "Please enter image URL!")
    @Size(min = 5, message = "Image URL must contain at least 5 characters!")
    private String imageUrl;
    private String warhead;
    private Integer maxSpeed;
    private Integer operationalRange;
    private String launchPlatform;
    private String description;

    public NuclearRocketAddDTO() {
    }

    public String getName() {
        return name;
    }

    public NuclearRocketAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public NuclearRocketAddDTO setUsedBy(String usedBy) {
        this.usedBy = usedBy;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public NuclearRocketAddDTO setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public NuclearRocketAddDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBlastYield() {
        return blastYield;
    }

    public NuclearRocketAddDTO setBlastYield(Double blastYield) {
        this.blastYield = blastYield;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public NuclearRocketAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getWarhead() {
        return warhead;
    }

    public NuclearRocketAddDTO setWarhead(String warhead) {
        this.warhead = warhead;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public NuclearRocketAddDTO setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getOperationalRange() {
        return operationalRange;
    }

    public NuclearRocketAddDTO setOperationalRange(Integer operationalRange) {
        this.operationalRange = operationalRange;
        return this;
    }

    public String getLaunchPlatform() {
        return launchPlatform;
    }

    public NuclearRocketAddDTO setLaunchPlatform(String launchPlatform) {
        this.launchPlatform = launchPlatform;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NuclearRocketAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
