package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment primary key
    @Column(name = "id")
    private int id;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "quantity")
    private int quantity;

    //must have default constructor
    public Part(){

    }
    public Part(String partName, int quantity) {
        this.partName = partName;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Part{" + "id=" + id +
                ", partName=" + partName +
                ", quantity=" + quantity +
                "}";
    }
}
