package com.theindianmaharajatours.app.dao.repository;

import com.theindianmaharajatours.app.dao.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
