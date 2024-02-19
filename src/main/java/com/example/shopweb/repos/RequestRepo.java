package com.example.shopweb.repos;

import com.example.shopweb.models.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<RequestModel, Long> {
}
