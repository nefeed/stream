package io.nefeed.stream.aspect;

import io.nefeed.stream.annotation.AnalysisActuator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 09:11
 */
@Aspect
@Component
public class AnalysisActuatorAspect {
    final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);

    ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Pointcut("@annotation(analysisActuator)")
    public void serviceStatistics(AnalysisActuator analysisActuator) {
    }

    @Before("serviceStatistics(analysisActuator)")
    public void doBefore(JoinPoint joinPoint, AnalysisActuator analysisActuator) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        log.info("nefeed note:{}", analysisActuator.note());
    }

    @After("serviceStatistics(analysisActuator)")
    public void doAfter(AnalysisActuator analysisActuator) {
        log.info("nefeed statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), analysisActuator.note());
    }

}
