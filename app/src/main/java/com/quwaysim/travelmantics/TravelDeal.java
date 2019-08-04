package com.quwaysim.travelmantics;

public class TravelDeal {
    private String id;
    private String destination;
    private String price;
    private String description;
    private String imageURL;

    public TravelDeal() {
    }

    public TravelDeal(String destination, String price, String description, String imageURL) {
        this.setId(id);
        this.setDestination(destination);
        this.setPrice(price);
        this.setDescription(description);
        this.setImageURL(imageURL);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
