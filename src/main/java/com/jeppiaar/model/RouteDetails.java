package com.jeppiaar.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class RouteDetails {
private int Id;
private Route routeId;
private int busNo;
private LocalDate departureDate;
private LocalTime departureTime;

}
