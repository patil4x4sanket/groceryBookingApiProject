package com.patil.sanket.groceryBookingApiProject.beans;

import javax.persistence.*;


@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private int oId;

//    @Column
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uId", referencedColumnName = "u_id")
    private User user;

//    @Column
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gId", referencedColumnName = "g_id")
    private GroceryItem groceryItem;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "gName", referencedColumnName = "g_name")
    @Column
    private String gName;

    @Column
    private int bookedQuantity;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "gPrice", referencedColumnName = "g_price")
    @Column
    private float price;

    @Column
    private float totalPrice;

    @PrePersist
    @PreUpdate
    private void calculateTotalAmount() {
        this.gName = this.groceryItem.getgName();
        this.price = this.groceryItem.getgPrice();
        this.totalPrice = this.bookedQuantity * this.price;
    }


    public Order() {
    }

    public Order(User user, GroceryItem groceryItem, int bookedQuantity) {
        this.user = user;
        this.groceryItem = groceryItem;
        this.bookedQuantity = bookedQuantity;
    }


    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GroceryItem getGroceryItem() {
        return groceryItem;
    }

    public void setGroceryItem(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getBookedQuantity() {
        return bookedQuantity;
    }

    public void setBookedQuantity(int bookedQuantity) {
        this.bookedQuantity = bookedQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", user=" + user +
                ", groceryItem=" + groceryItem +
                ", gName='" + gName + '\'' +
                ", bookedQuantity=" + bookedQuantity +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
