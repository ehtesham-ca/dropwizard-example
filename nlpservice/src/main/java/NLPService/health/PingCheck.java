package NLPService.health;

import com.codahale.metrics.health.HealthCheck;

public class PingCheck extends HealthCheck {
    @Override
    protected Result check() {
        return Result.healthy("pong");
    }
}