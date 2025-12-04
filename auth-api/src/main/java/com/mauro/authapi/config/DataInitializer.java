package com.mauro.authapi.config;
import com.mauro.authapi.model.Role;
import com.mauro.authapi.model.RoleName;
import com.mauro.authapi.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
            Role roleUser = new Role();
            roleUser.setName(RoleName.ROLE_USER);
            roleRepository.save(roleUser);
        }

        if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
            Role roleAdmin = new Role();
            roleAdmin.setName(RoleName.ROLE_ADMIN);
            roleRepository.save(roleAdmin);
        }

        System.out.println("Roles criadas automaticamente!");
    }

    {
        System.out.println("Roles criadas automaticamente!");
    }
}