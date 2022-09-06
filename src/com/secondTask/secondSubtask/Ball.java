package com.secondTask.secondSubtask;

public class Ball {

    private String manufacturer_, colour_, material_;
    private Integer costRub_, radiusInch_ = null;
    private Double surfaceSquare_, volume_;

    private Double xCoord_ = 0.0, yCoord_ = 0.0;

    private final double PI = 3.14;
    private final double CM_PER_INCH = 2.54;

    public Ball() {}

    public void setManufacturer_(String manufacturer_) {
        this.manufacturer_ = manufacturer_;
    }

    public void setColour_(String colour_) {
        this.colour_ = colour_;
    }

    public void setMaterial_(String material_) {
        this.material_ = material_;
    }

    public void setCostRub_(Integer costRub_) {
        this.costRub_ = costRub_;
    }

    public void setRadiusInch_(Integer radiusInch_) {
        this.radiusInch_ = radiusInch_;
    }

    public Integer getRadiusInch_() {
        return radiusInch_;
    }

    public final void CalcProperties() throws InitializationException {

        if (this.getRadiusInch_() == null) throw new InitializationException("The ball is not initialized.");

        this.surfaceSquare_ = 4 * PI * Math.pow(radiusInch_ * CM_PER_INCH, 2);
        this.volume_ = 4 * PI * Math.pow(radiusInch_ * CM_PER_INCH, 3) / 3;
    }

    public final void Kick(Integer strength, Integer angle) throws InitializationException {

        if (this.getRadiusInch_() == null) throw new InitializationException("The ball is not initialized.");

        this.xCoord_ = xCoord_ + strength * Math.cos(Math.toRadians(angle.doubleValue()));
        this.yCoord_ = yCoord_ + strength * Math.sin(Math.toRadians(angle.doubleValue()));
    }

    public void Clear() {
        this.manufacturer_ = null;
        this.colour_ = null;
        this.material_ = null;
        this.costRub_ = null;
        this.radiusInch_ = null;

        this.surfaceSquare_ = null;
        this.volume_ = null;

        this.xCoord_ = null;
        this.yCoord_ = null;
    }

    @Override
    public String toString() {
        return "Ball: {"
            + "manufacturer_ = '" + manufacturer_ + '\''
            + ", colour_ = '" + colour_ + '\''
            + ", material_ ='" + material_ + '\''

            + ", costRub_ = " + costRub_
            + ", radiusInch_ = " + radiusInch_

            + ", surfaceSquare_ = " + String.format("%.2f", surfaceSquare_)
            + ", volume_ = " + String.format("%.2f", volume_)

            + ", xCoord_ = " + String.format("%.2f", xCoord_)
            + ", yCoord_ = " + String.format("%.2f", yCoord_)
            + '}';
    }
}
