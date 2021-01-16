package com.rhm.demo.repositories;

import com.rhm.demo.models.License;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

    List<License> findAll();

    void deleteById(Long id);
    public License findTopByOrderByNumberDesc();

    // List<License> findByTitleContaining(String search);
   // List<License> findTop10ByOrderByRatingDesc();




}