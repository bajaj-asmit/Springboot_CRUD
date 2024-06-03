package com.project.social_youtube.repository;

import com.project.social_youtube.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User,Integer> {



}
