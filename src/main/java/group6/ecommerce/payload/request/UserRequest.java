package group6.ecommerce.payload.request;

import group6.ecommerce.model.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String city;
    private String district;
    private String ward;
}