package com.project.neo.history.service;

import com.project.neo.history.entity.TimeQuantum;
import org.springframework.data.repository.Repository;

public interface TimeQuantumRepository extends Repository<TimeQuantum, String> {

    TimeQuantum findAllByName(String name);

    TimeQuantum findByStartYearLessThanEqualAndAndEndYearIsGreaterThanEqual(int yearSatrt,int yearEnd);
}
