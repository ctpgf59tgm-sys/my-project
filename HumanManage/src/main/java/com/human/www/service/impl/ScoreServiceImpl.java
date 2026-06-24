package com.human.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.human.www.domain.Score;
import com.human.www.domain.User;
import com.human.www.mapper.ScoreMapper;
import com.human.www.service.ScoreService;
import com.human.www.utils.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectScoreAll() {
        List<Score> scores = scoreMapper.selectList(null);
        return scores;
    }

    @Override
    public ResultVO<List<Score>> getScoreByNameId(String name, String id) {
        LambdaQueryWrapper<Score> query = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(name)) {
            query.like(Score::getName, name);
        }
        if (StringUtils.hasText(id)) {
            query.eq(Score::getId, id);
        }
        List<Score> scores = scoreMapper.selectList(query);
        if (scores.size() >= 0) {
            return ResultVO.success("数据查询成功！", scores);
        }
        return ResultVO.error("数据库异常！");
    }

    @Override
    public ResultVO<Integer> delete(String id) {
        LambdaQueryWrapper<Score> query = new LambdaQueryWrapper<>();
        query.eq(Score::getId, id);
        int i = scoreMapper.delete(query);
        if (i > 0) {
            return ResultVO.success("成绩删除成功！", i);
        }
        return ResultVO.error("成绩删除失败！");
    }

    @Override
    public ResultVO<Integer> update(Score score) {
        LambdaQueryWrapper<Score> query = new LambdaQueryWrapper<>();
        query.eq(Score::getId, score.getId());
        int i = scoreMapper.update(score, query);
        if (i > 0) {
            return ResultVO.success("成绩修改成功!", i);
        }
        return ResultVO.error("成绩修改失败!");
    }
    @Override
    public ResultVO<Integer> add(Score score) {
        // 直接插入整条用户数据到数据库
        LambdaQueryWrapper<Score> query = new LambdaQueryWrapper<>();
        int i = scoreMapper.update(score,query);
        if (i > 0) {
            return ResultVO.success("用户新增成功！", i);
        }
        return ResultVO.error("用户新增失败！");
    }
}