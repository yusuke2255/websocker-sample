package jp.kwt.samples.chat.healthchecks;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return HealthCheck.Result.healthy();
    }
}