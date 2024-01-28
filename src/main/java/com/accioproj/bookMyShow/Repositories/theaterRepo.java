package com.accioproj.bookMyShow.Repositories;

import com.accioproj.bookMyShow.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//it will create bean of simple jpa respository which is implementing jpa repo so dont need to write @repo anntation
public interface theaterRepo extends JpaRepository<Theater,Integer> {
    Optional<Theater> findByTheaterNameAndTheaterAddress(String theaterName, String theaterAddress);

}
