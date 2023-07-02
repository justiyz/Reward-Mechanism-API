package com.poprev.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectDto {

    private String projectName;

    private double targetAmount;

    private String projectStatus;

    private Long artistId;
}
