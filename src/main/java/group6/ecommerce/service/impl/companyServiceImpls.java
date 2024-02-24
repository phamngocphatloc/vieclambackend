package group6.ecommerce.service.impl;

import group6.ecommerce.Repository.companyRepository;
import group6.ecommerce.model.Company;
import group6.ecommerce.service.companyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class companyServiceImpls implements companyService {
    private final companyRepository companyRepository;
    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }
}
