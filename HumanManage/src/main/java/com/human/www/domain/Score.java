package com.human.www.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "score_tb")
public class Score {

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    
    private String name;
    
    @TableField(value = "class_id")
    private String classId;
    
    private Integer chinese;
    
    private Integer math;
    
    private Integer english;

    public Score() {
    }

    public Score(String id, String name, String classId, Integer chinese, Integer math, Integer english) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }
}