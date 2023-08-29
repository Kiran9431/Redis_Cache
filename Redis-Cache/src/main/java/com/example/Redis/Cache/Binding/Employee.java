package com.example.Redis.Cache.Binding;

import lombok.Data;

import java.io.Serializable;

@Data
    public class Employee implements Serializable {
        private Integer sno;
        private String name;
        private String email;
    }


