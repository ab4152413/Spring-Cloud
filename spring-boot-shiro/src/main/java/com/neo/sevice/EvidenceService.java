package com.neo.sevice;



import com.neo.model.Evidence;
import com.neo.dao.*;
import com.neo.results.ErrorResult;
import com.neo.results.Result;
import com.neo.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


import java.util.Date;
import java.util.List;

/**
 * Created by waynamigo on 19-5-24
 * List<Evidence> findAllByStu_id(String id);
 * Evidence findEvidenceByEvidence_id(String id);
 */
@Service
public class EvidenceService{
    @Autowired
    EvidenceRepository evidenceRepository;
    @Autowired
    RestTemplate restTemplate;

    private static final String DEFAULT_MEDIA_TYPE = "application/json; charset=UTF-8";
    private static final String QUERY_USER_AUTHORIZED_MENU_TREE = "queryMenuTree";


//    public Result addEvidence(String stu_id,String behavior) {
//        try {
//            Date record_time = new Date();
//            String picurl = "http://139.199.22.224:8000/"+stu_id+".jpg";
//            Evidence evidence= new Evidence(picurl,behavior,record_time,stu_id);
//            evidenceRepository.save(evidence);
//            return Result.success("success added");
//        } catch (Exception e) {
//            return Result.error(e.getMessage());
//        }
//    }
    public Result addEvidence(String stu_id,String behavior) {
        try {
            System.out.println(stu_id);
            ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://select:8002/evidence/add?stuid="+stu_id+"&behavior="+behavior,HttpMethod.POST,
                    null,stu_id,behavior);
            String body = responseEntity.getBody();
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
        List<Evidence> response = restTemplate.exchange("http://select:8002/evidence/getallbystuid?stuid="+stuid,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Evidence>>() {},stuid).getBody();
        return response;
    }

    public List<Evidence> getEvidencelist(){
        List<Evidence> response = restTemplate.exchange("http://select:8002/evidence/getall",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Evidence>>() {}).getBody();
        return response;
    }

//    public List<Evidence> getEvidencelist(String stuid){
//        try {
//            List<Evidence> evidences = evidenceRepository.findAllByStuid(stuid);
//            if (evidences == null)
//                return null;
//            return evidences;
//        } catch (Exception e) {
//            return null;
//        }
//    }
}