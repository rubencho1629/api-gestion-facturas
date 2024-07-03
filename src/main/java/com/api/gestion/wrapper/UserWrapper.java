package com.api.gestion.wrapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {

    private Integer id;
    private String nombre;
    private String numeroDeContacto;
    private String email;
    private String status;
    private String role;
}
