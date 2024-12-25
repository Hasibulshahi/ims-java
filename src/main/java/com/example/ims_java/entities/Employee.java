package com.example.ims_java.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EmployeeID", nullable = true)
    private String employeeID;
    @Column(name = "UserName", nullable = true)
    private String userName;
    @Column(name = "Password", nullable = true)
    private String Password;
    @Column(name = "FirstName", nullable = true)
    private String FirstName;
    @Column(name = "LastName", nullable = true)
    private String LastName;
    @Column(name = "Passport", nullable = true)
    private String Passport;
    @Column(name = "ContactNO", nullable = true)
    private String ContactNO;
    @Column(name = "Email", nullable = true)
    private String Email;
    @Column(name = "Address", nullable = true)
    private String Address;
    @Column(name = "PostCode", nullable = true)
    private String PostCode;
    @Column(name = "Status", nullable = false)
    private int Status;
    @Column(name = "RoleID", nullable = false)
    private int RoleID;
    @Column(name = "CreateBy", nullable = true)
    private String CreateBy;
    @Column(name = "CreateDate", nullable = true)
    private Date CreateDate;
    @Column(name = "UpdateBy", nullable = true)
    private String UpdateBy;
    @Column(name = "UpdateDate", nullable = true)
    private Date UpdateDate;
}
