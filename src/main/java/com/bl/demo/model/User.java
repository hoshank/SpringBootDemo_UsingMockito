package com.bl.demo.model;
/**
 * purpose:entity on which the operation is performed
 */

import com.bl.demo.dto.UserDto;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;


@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotEmpty(message = "Cannot be empty!")
    String userName;

    @NotEmpty(message = "Password is mandatory")
    String password;

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @CreationTimestamp
    private Timestamp registrationDate;

    public User() {
    }

    public User(UserDto userDto) {
        userName = userDto.userName;
        password = userDto.password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }
}
