package com.bookshelf.finder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookshelf.finder.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserEntity,String>{
	Optional<UserEntity>  findByUserId(String userId);
   
}
 