package ru.sleepySofa.term.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {
    private String username;
    private String eMail;
    private String telephone;
    private String password;
    private String avatarIcon;
    private String role;
}
