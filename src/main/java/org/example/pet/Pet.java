package org.example.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_id_seq")
    @SequenceGenerator(name = "pet_id_seq", sequenceName = "pet_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String pet_name;
    private String pet_type;
    private String breed;
    private int age;
}
