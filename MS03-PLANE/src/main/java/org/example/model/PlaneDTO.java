package org.example.model;

public class PlaneDTO {
    private String planeId;
    private Integer planeCapacity;
    private String planeCategory;
    private String planeModel;
    private String planeOperator;

    //Default Constructor
    public PlaneDTO() {}

    // Constructor
    public PlaneDTO(String planeId,Integer planeCapacity, String planeCategory, String planeModel, String planeOperator) {
        this.planeId = planeId;
        this.planeCapacity = planeCapacity;
        this.planeCategory = planeCategory;
        this.planeModel = planeModel;
        this.planeOperator = planeOperator;
    }

    //Getters and Setters
    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public Integer getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(Integer planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public String getPlaneCategory() {
        return planeCategory;
    }

    public void setPlaneCategory(String planeCategory) {
        this.planeCategory = planeCategory;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public String getPlaneOperator() {
        return planeOperator;
    }

    public void setPlaneOperator(String planeOperator) {
        this.planeOperator = planeOperator;
    }


}
