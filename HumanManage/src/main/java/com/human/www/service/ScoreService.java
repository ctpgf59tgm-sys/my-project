package com.human.www.service;

import com.human.www.domain.Score;
import com.human.www.domain.User;
import com.human.www.utils.ResultVO;

import java.util.List;

public interface ScoreService {
    public abstract List<Score> selectScoreAll();
    public abstract ResultVO<List<Score>> getScoreByNameId(String name, String id);
    public abstract ResultVO<Integer> delete(String id);
    public abstract ResultVO<Integer> update(Score score);
    public abstract ResultVO<Integer> add(Score score);
}