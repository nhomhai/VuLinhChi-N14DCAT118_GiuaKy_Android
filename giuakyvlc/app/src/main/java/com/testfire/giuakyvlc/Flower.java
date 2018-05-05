package com.testfire.giuakyvlc;

import java.io.Serializable;

/**
 * Created by vulinhchi on 4/14/18.
 */

public class Flower  implements Serializable{
    private String id;
    private String flowername;
    private String price;
    private String imageFlower;
    private String details;
    private String status;
    private String species;

    public Flower() {
        this.flowername = flowername;
        this.price = price;
        this.status=status;
        this.species=species;
        this.details = details;
        this.imageFlower=imageFlower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlowername() {
        return flowername;
    }

    public void setFlowername(String flowername) {
        this.flowername = flowername;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageFlower() {
        return imageFlower;
    }

    public void setImageFlower(String imageFlower) {
        this.imageFlower = imageFlower;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

