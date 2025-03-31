package com.example.jobportal.Service;


import com.example.jobportal.model.AdminEntity;
import com.example.jobportal.repository.Admin_repo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final Admin_repo adminRepository;

    public AdminService(Admin_repo adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Get all admins
    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Get admin by ID
    public AdminEntity getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    // Create new admin
    public AdminEntity createAdmin(AdminEntity admin) {
        return adminRepository.save(admin);
    }

    // Update admin details
    public AdminEntity updateAdmin(Long id, AdminEntity updatedAdmin) {
        AdminEntity existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));

        existingAdmin.setName(updatedAdmin.getName());
        existingAdmin.setEmail(updatedAdmin.getEmail());

        return adminRepository.save(existingAdmin);
    }

    // Delete admin by ID
    public void deleteAdmin(Long id) {
        if (!adminRepository.existsById(id)) {
            throw new RuntimeException("Admin not found with id: " + id);
        }
        adminRepository.deleteById(id);
    }
}
