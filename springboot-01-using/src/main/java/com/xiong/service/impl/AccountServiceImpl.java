package com.xiong.service.impl;

import com.xiong.service.AccountService;
import com.xiong.service.util.RiskAssessor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;

//构造器注入方式: 属性使用final进行修饰, 意味着不能通过setXXX()方式进行修改

/**
 * @author xiong
 * @date 2022/10/24
 */
@Service
public class AccountServiceImpl implements AccountService {
    private final RiskAssessor riskAssessor;
    private final PrintStream out;

    //如果有多个构造器, 必须指定自动配置使用的构造器
    //Class doesn't 't contain matching constructor for autowiring

    @Autowired
    public AccountServiceImpl(RiskAssessor riskAssessor) {
        this.riskAssessor = riskAssessor;
        this.out = System.out;
    }

    public AccountServiceImpl(RiskAssessor riskAssessor, PrintStream out) {
        this.riskAssessor = riskAssessor;
        this.out = out;
    }
}
