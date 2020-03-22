package com.neo.dao;

import com.neo.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by waynamigo on 19-5-14
 */
@Repository
public interface EvidenceRepository extends JpaRepository<Evidence,Integer> {
    List<Evidence> findAllByStuid(String stuid);
    Evidence findEvidenceByEvid(Integer evi_id);
}
