package bg.softuni.armory.model.entity.views;

public class NuclearBombViewDTO {
    private Long id;
    private String name;
    private String usedBy;
    private Integer mass;
    private Double length;
    private Double blastYield;
    private String imageUrl;
    private String description;

    public NuclearBombViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public NuclearBombViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public NuclearBombViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public NuclearBombViewDTO setUsedBy(String usedBy) {
        this.usedBy = usedBy;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public NuclearBombViewDTO setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public NuclearBombViewDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBlastYield() {
        return blastYield;
    }

    public NuclearBombViewDTO setBlastYield(Double blastYield) {
        this.blastYield = blastYield;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public NuclearBombViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NuclearBombViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
