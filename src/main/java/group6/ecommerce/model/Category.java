package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int Id;
    @Column (name = "categoryName", columnDefinition = "nvarchar(255)", nullable = false,length = 255)
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(){

    }

}
