package com.samsonmarikwa.rest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsonmarikwa.rest.entities.Product;

// Why use JpaRepository instead of CrudRepository
// JpaRepository has pagination and sorting methods that come from the parent interface PagingAndSortingRepository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
