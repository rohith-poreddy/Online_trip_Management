package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FeedBack;

public interface IFeebackRepository extends JpaRepository<FeedBack,Long> {

}
