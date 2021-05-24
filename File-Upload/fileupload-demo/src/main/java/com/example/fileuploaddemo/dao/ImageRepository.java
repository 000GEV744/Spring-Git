package com.example.fileuploaddemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fileuploaddemo.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Integer>{

	Optional<ImageModel> findByName(String name);
}
