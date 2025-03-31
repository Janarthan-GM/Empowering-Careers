package com.example.jobportal.Service;


import com.example.jobportal.model.CompanyEntity;
import com.example.jobportal.repository.Company_repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final Company_repo companyRepository;

    public CompanyService(Company_repo companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Get all companies
    public List<CompanyEntity> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get company by ID
    public CompanyEntity getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
    }

    // Create new company
    public CompanyEntity createCompany(CompanyEntity company) {
        return companyRepository.save(company);
    }

    // Update company details
    public CompanyEntity updateCompany(Long id, CompanyEntity updatedCompany) {
        CompanyEntity existingCompany = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        existingCompany.setName(updatedCompany.getName());
        existingCompany.setLocation(updatedCompany.getLocation());
        existingCompany.setEmail(updatedCompany.getEmail());
        existingCompany.setWebsite(updatedCompany.getWebsite());

        return companyRepository.save(existingCompany);
    }

    // Delete company by ID
    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found with id: " + id);
        }
        companyRepository.deleteById(id);
    }
}
