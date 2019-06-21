package net.guide.springboot2.repository;

import net.guide.springboot2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository   extends JpaRepository<Role,Long> {

}

