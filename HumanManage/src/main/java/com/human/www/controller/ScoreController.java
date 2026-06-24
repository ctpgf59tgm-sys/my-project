package com.human.www.controller;

import com.human.www.domain.Score;
import com.human.www.service.ScoreService;
import com.human.www.utils.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @ResponseBody
    @RequestMapping("/selectScoreAll")
    public List<Score> selectScoreAll(){
        List<Score> scores = scoreService.selectScoreAll();
        return scores;
    }

    @ResponseBody
    @RequestMapping("/getScore")
    public ResultVO<List<Score>> getScoreNameId(String name, String id){
        ResultVO<List<Score>> scores = scoreService.getScoreByNameId(name, id);
        return scores;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ResultVO<Integer> delete(String id){
        return scoreService.delete(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultVO<Integer> update(@RequestBody Score score){
        return scoreService.update(score);

    }
    @ResponseBody
    @RequestMapping("/add")
    public ResultVO<Integer> add(@RequestBody Score score) {
        return scoreService.add(score);
    }

}