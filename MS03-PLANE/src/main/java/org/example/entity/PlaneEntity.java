package org.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class PlaneEntity {
    @Id
    @Column(name = "plane_id")
    private String planeId;
    @Column(name = "plane_capacity", nullable = false)
    private Integer planeCapacity;
    @Column(name = "plane_category", nullable = false)
    private String planeCategory;
    @Column(name = "plane_model", nullable = false)
    private String planeModel;
    @Column(name = "plane_operator", nullable = false)
    private String planeOperator;

    //Default Constructor
    public PlaneEntity() {}

    //Constructor
    public PlaneEntity(String planeId,Integer planeCapacity, String planeCategory, String planeModel, String planeOperator) {
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

    @Override
    public String toString() {
        return "PlaneEntity{" +
                "planeId='" + planeId + '\'' +
                ", planeCapacity=" + planeCapacity +
                ", planeCategory='" + planeCategory + '\'' +
                ", planeModel='" + planeModel + '\'' +
                ", planeOperator='" + planeOperator + '\'' +
                '}';
    }
}
