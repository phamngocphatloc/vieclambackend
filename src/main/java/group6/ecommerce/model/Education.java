package group6.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Education {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int Id;
    @Column (name = "EducationName", columnDefinition = "nvarchar(255)", nullable = false, length = 255)
    private String educationName;

    public Education(String educationName) {
        this.educationName = educationName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }
    public Education (){

    }
}
