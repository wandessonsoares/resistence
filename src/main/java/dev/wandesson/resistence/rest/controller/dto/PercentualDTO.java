package dev.wandesson.resistence.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter @Setter
@AllArgsConstructor
public class PercentualDTO {
    private String percentual;
}
