package com.example.ims_java.entities;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Table(name = "menu_master")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;

    @Column(name = "MenuID", nullable = true)
    private String menuID;

    @Column(name = "CategoryID", nullable = true)
    private Long categoryID;

    @Column(name = "MenuName", nullable = true)
    private String menuName;

    @Column(name = "Ingredients", nullable = true)
    private String ingredients;

    @Column(name = "PhotoID", nullable = true)
    private String photoID;

    @Column(name = "PhotoDirectory", nullable = true)
    private String photoDirectory;

    @Column(name = "MenuStatus", nullable = true)
    private Long menuStatus;

    @Column(name = "CreateBy", nullable = true)
    private String CreateBy;

    @Column(name = "CreateDate", nullable = true)
    private Date CreateDate;

    @Column(name = "UpdateBy", nullable = true)
    private String UpdateBy;

    @Column(name = "UpdateDate", nullable = true)
    private Date UpdateDate;

    @Column(name = "RestaurantID", nullable = true)
    private String RestaurantID;
}
