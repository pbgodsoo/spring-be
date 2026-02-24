package org.example.springbe.user.model;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(unique = true)
    private String email;
    private String name;
    @Setter
    private String password;
    private boolean enable;
    private String role;
}
