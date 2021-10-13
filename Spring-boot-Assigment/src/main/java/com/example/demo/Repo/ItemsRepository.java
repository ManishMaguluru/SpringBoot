package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Item;

public interface ItemsRepository extends JpaRepository<Item, Long>{

}
