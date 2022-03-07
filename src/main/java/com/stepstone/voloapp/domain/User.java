package com.stepstone.voloapp.domain;

import com.stepstone.voloapp.domain.utils.BaseEntity;
import com.stepstone.voloapp.domain.utils.PersonalInformation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(	name = "users",
        uniqueConstraints = {
//                @UniqueConstraint(columnNames = "username")
        })
public class User extends BaseEntity {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_information_id", referencedColumnName = "id")
    private PersonalInformation personalInformation;

    public User(String username, String email, String encodedPassword, PersonalInformation personalInformation) {
        this.username = username;
        this.personalInformation = personalInformation;
        this.personalInformation.setEmail(email);
        this.password = encodedPassword;
    }
}