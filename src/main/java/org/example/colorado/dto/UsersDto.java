package org.example.colorado.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.example.colorado.entity.Role;

import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto {

    private Integer id;
    private String name;
    private String telephonnumber;
    private Set<Role> role;
    private String password;

    // Constructors, getters, and setters
}
