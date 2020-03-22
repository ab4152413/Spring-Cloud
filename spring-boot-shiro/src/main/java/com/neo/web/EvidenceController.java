package com.neo.web;

import com.neo.model.Evidence;
import com.neo.results.Result;
import com.neo.sevice.EvidenceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by waynamigo on 19-5-24
 */
@Controller
@RequestMapping("/evidence")
public class EvidenceController {
    @Autowired
    EvidenceService evidenceService = new EvidenceService();


    @ApiOperation(value = "getbyevid", notes = "查询一条，供其他接口使用", response = Result.class)
    @PostMapping(value = "/getbyevid")
    public Result getevidence(@ApiParam(value = "evid" ,required=true ) @RequestParam Integer evid){
        return evidenceService.getEvidence(evid);
    }
    @ApiOperation(value = "getallbystuid", notes = "查询一个学生所有记录", response = Result.class)

    @PostMapping(value = "/getallbystuid")
    public String getevidences(@ApiParam(value = "stuid" ,required=true ) @RequestParam String stuid,Model model){
        List<Evidence> evidences = evidenceService.getEvidencelist(stuid);
        model.addAttribute("eviList", evidences);
        return "userInfo";
    }

    @GetMapping(value = "/getall")
    public String getevidences(Model model){
        List<Evidence> evidences = evidenceService.getEvidencelist();
        model.addAttribute("eviList", evidences);
        return "userInfo";
    }


    @PostMapping(value = "/add")
    public String addoneevidence(@ApiParam(value = "stuid" ,required=true ) @RequestParam String stuid,
                                 @ApiParam(value = "behavior" ,required=true ) @RequestParam String behavior){
        evidenceService.addEvidence(stuid,behavior);
        return "index";
    }
}
