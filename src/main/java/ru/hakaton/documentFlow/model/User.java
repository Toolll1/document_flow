package ru.hakaton.documentFlow.model;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class User {

    private Integer id;
    private String name;
    private String email;
    private String login;
}
