package org.javatest.assetdepreciation.model.repository;

import org.javatest.assetdepreciation.model.entity.Active;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static org.javatest.assetdepreciation.utils.SystemConstants.ACTIVE_SERIAL_QUERY;
import static org.javatest.assetdepreciation.utils.SystemConstants.ID;
import static org.javatest.assetdepreciation.utils.SystemConstants.SERIAL;

@Repository
public interface ActiveRepository extends JpaRepository<Active, Integer> {

    @Query(value = ACTIVE_SERIAL_QUERY)
    String searchBySerial(@Param(ID) Integer id, @Param(SERIAL) String serial);
}