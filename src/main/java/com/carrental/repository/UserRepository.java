package com.carrental.repository;

import com.carrental.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {
/*    @Query("""
            select * from public.user where email = :email
            """)*/
    Optional<User> findByEmail(String email);
}
