package strategy;

import utils.JsonUtils;

/**
 * Created by mad-man on 2017/8/12.
 */
public class StrategyRule {

    private Double percent;

    public StrategyRule() {
    }

    public StrategyRule(Double percent) {
        this.percent = percent;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
