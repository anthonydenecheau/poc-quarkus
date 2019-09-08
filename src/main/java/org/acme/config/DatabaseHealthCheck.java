package org.acme.config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import io.agroal.api.AgroalDataSource;

@Readiness
@ApplicationScoped
public class DatabaseHealthCheck implements HealthCheck {

    @Inject
    AgroalDataSource dataSource;

    @Override
    public HealthCheckResponse call() {
        System.out.println("call DatabaseHealthCheck");
        HealthCheckResponseBuilder responseBuilder =
            HealthCheckResponse.named("DB");

        try {
            checkDatabaseConnection();
            responseBuilder.withData("connection", true);
            responseBuilder.up();
        } catch (IllegalStateException e) {
            // cannot access the database
            responseBuilder.down()
                    .withData("error", e.getMessage());
        }
        return responseBuilder.build();
    }

    private void checkDatabaseConnection() {
        System.out.println(">> checkDatabaseConnection");
        try (Connection connection = dataSource.getConnection()) {
            connection.isValid(1000);
        } catch (SQLException sqlExc) {
            throw new IllegalStateException("Cannot contact database");
        }
    }

}