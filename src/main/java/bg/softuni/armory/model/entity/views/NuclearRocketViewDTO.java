package bg.softuni.armory.model.entity.views;

public class NuclearRocketViewDTO {
    private Long id;
    private String name;
    private String usedBy;
    private Integer mass;
    private Double length;
    private Double blastYield;
    private String warhead;
    private Integer maxSpeed;
    private Integer operationalRange;
    private String imageURL;
    private String description;

    public NuclearRocketViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public NuclearRocketViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public NuclearRocketViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public NuclearRocketViewDTO setUsedBy(String usedBy) {
        this.usedBy = usedBy;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public NuclearRocketViewDTO setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public NuclearRocketViewDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBlastYield() {
        return blastYield;
    }

    public NuclearRocketViewDTO setBlastYield(Double blastYield) {
        this.blastYield = blastYield;
        return this;
    }

    public String getWarhead() {
        return warhead;
    }

    public NuclearRocketViewDTO setWarhead(String warhead) {
        this.warhead = warhead;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public NuclearRocketViewDTO setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getOperationalRange() {
        return operationalRange;
    }

    public NuclearRocketViewDTO setOperationalRange(Integer operationalRange) {
        this.operationalRange = operationalRange;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public NuclearRocketViewDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NuclearRocketViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
