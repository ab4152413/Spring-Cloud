package com.springlcoud.service;


import com.springlcoud.dao.*;
import com.springlcoud.model.Evidence;
import com.springlcoud.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by waynamigo on 19-5-24
 * List<Evidence> findAllByStu_id(String id);
 * Evidence findEvidenceByEvidence_id(String id);
 */
@Service
public class EvidenceService {
    @Autowired
    EvidenceRepository evidenceRepository;
    public Result addEvidence(String stu_id,String behavior) {
        try {
            Date record_time = new Date();
            String picurl = "http://211.87.177.1/jwxt/uploadfile/studentphoto/pic/"+stu_id+".JPG";
            Evidence evidence= new Evidence(picurl,behavior,record_time,stu_id);
            evidenceRepository.save(evidence);
            return Result.success("success added");
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    public Result getEvidence(Integer eviid){
        try {
            Evidence evidence = evidenceRepository.findEvidenceByEvid(eviid);
            if (evidence==null){
                return  Result.error("无不良记录");
            }else{
                return Result.success(evidence);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.error("有毒 滚去debug");
        }
    }
    public List<Evidence> getEvidencelist(String stuid){
        try {
            List<Evidence> evidences = evidenceRepository.findAllByStuid(stuid);
            System.out.println("我的可以用了");
            if (evidences == null)
                return null;
            return evidences;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Evidence> getEvidencelist(){
        try {
            List<Evidence> evidences = evidenceRepository.findAll();
            System.out.println("我的可以用了");
            if (evidences == null)
                return null;
            return evidences;
        } catch (Exception e) {
            return null;
        }
    }
}