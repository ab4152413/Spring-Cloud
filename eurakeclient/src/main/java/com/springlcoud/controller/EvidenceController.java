package com.springlcoud.controller;

import com.springlcoud.model.Evidence;
import com.springlcoud.results.Result;
import com.springlcoud.service.EvidenceService;
import com.springlcoud.service.EvidenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by waynamigo on 19-5-24
 */
@RestController
@RequestMapping("/evidence")
public class EvidenceController {
    @Autowired
    EvidenceService evidenceService = new EvidenceService();

    @ApiOperation(value = "getbyevid", notes = "查询一条，供其他接口使用", response = Result.class)
    @PostMapping(value = "/getbyevid")
    public Result getevidence(@ApiParam(value = "evid" ,required=true ) @RequestParam Integer evid){
        return evidenceService.getEvidence(evid);
    }

    @RequestMapping("/getallbystuid")
    public List<Evidence> getevidences(String stuid){
        List<Evidence> evidences = evidenceService.getEvidencelist(stuid);
        System.out.println(evidences);
        return evidences;
    }

    @RequestMapping("/getall")
    public List<Evidence> getevidences(){
        List<Evidence> evidences = evidenceService.getEvidencelist();
        System.out.println(evidences);
        return evidences;
    }

    @PostMapping(value = "/add")
    public Result addoneevidence(@ApiParam(value = "stuid" ,required=true ) @RequestParam String stuid,
                                 @ApiParam(value = "behavior" ,required=true ) @RequestParam String behavior){
        System.out.println(stuid);
        return evidenceService.addEvidence(stuid,behavior);
    }
}
