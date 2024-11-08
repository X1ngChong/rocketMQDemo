package com.bhui.rocketmqdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("points_log")
public class PointsLog {
    @TableId
    private  Long id;
    private  Long userId;
    private Integer points;
    private LocalDateTime timeStamp;


}
