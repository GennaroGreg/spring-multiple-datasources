package org.example.character;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.base.BaseDocument;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "characters")
public class Character extends BaseDocument {

    private String name;
    private String movieName;
    private String tvShowName;
    private boolean main;
    private boolean villain;
    private boolean hero;
}
