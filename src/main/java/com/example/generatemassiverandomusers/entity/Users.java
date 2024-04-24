package com.example.generatemassiverandomusers.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author FlyHippo
 * @since 2024-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String sex;

    private Integer age;

    private String email;

    private String tel;

    private String address;


}