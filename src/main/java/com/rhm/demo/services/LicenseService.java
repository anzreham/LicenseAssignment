package com.rhm.demo.services;

import com.rhm.demo.models.License;
import com.rhm.demo.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    private LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }
    public List<License> getAllLicenses(){
        return this.licenseRepository.findAll();
    }

    //Get one license
    public License findByid(Long id) {
        return this.licenseRepository.findById(id).orElse(null);
    }

    //Create a license
    public License createLicense(License l) {
        l.setNumber(this.generateLicenseNumber());
        return licenseRepository.save(l);
    }
    public int generateLicenseNumber() {
        License l = licenseRepository.findTopByOrderByNumberDesc();
        if(l == null)
            return 1;
        int largestNumber = l.getNumber();
        largestNumber++;
        return (largestNumber);
    }
}
