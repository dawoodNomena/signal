package com.projetdec.signalement.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projetdec.signalement.entite.*;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
        
}