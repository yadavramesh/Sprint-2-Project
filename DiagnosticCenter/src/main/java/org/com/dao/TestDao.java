package org.com.dao;

import org.com.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Test, String>{

}
