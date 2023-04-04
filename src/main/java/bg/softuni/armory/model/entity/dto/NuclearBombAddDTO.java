package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NuclearBombAddDTO {
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
    private String description;

    public NuclearBombAddDTO() {
    }

    public String getName() {
        return name;
    }

    public NuclearBombAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public NuclearBombAddDTO setUsedBy(String usedBy) {
        this.usedBy = usedBy;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public NuclearBombAddDTO setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public NuclearBombAddDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBlastYield() {
        return blastYield;
    }

    public NuclearBombAddDTO setBlastYield(Double blastYield) {
        this.blastYield = blastYield;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public NuclearBombAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NuclearBombAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
