package org.example.contact;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_id_seq")
    @SequenceGenerator(name = "contact_id_seq", sequenceName = "contact_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String contact_name;
    private String phone;
    private String email;
    private String address;
}
