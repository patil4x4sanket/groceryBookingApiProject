package com.patil.sanket.groceryBookingApiProject.beans;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity(name = "grocery_item")
//@Data //--> lombok annotation (will need lombok dependency in pom), generates getters, setters, toString, equals, hashcode
//@NoArgsConstructor //--> lombok annotation, generates no-args constructor
//@AllArgsConstructor //--> lombok annotation, generates all-args constructor
@DynamicInsert
@DynamicUpdate
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "g_id")
    private int gId;
    private String gName;
    private float gPrice;
    private int gQuantity;


    public GroceryItem() {
        super();
    }

    public GroceryItem(int gId, String gName, float gPrice, int gQuantity) {
        this.gId = gId;
        this.gName = gName;
        this.gPrice = gPrice;
        this.gQuantity = gQuantity;
    }


    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public float getgPrice() {
        return gPrice;
    }

    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
    }

    public int getgQuantity() {
        return gQuantity;
    }

    public void setgQuantity(int gQuantity) {
        this.gQuantity = gQuantity;
    }


    @Override
    public String toString() {
        return "GroceryItem{" +
                "gId='" + gId + '\'' +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gQuantity=" + gQuantity +
                '}';
    }

    public String toStringWithBookedQuantity(int bookedQuantity, float totalPrice) {
        return "BookedGroceryItem{" +
                "gId='" + gId + '\'' +
                ", gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", bookedQuantity='" + bookedQuantity + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
