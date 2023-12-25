package org.example.service;

import org.example.model.Equation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriterService {
    private static final String ADD_EQUATION = "INSERT INTO equations(equation) VALUES (?)";
    private static final ConnectionService CONNECTION_SERVICE = ConnectionService.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(WriterService.class);

    private static WriterService instance;

    public void addEquation(Equation equation) {
        Connection connection = CONNECTION_SERVICE.getConnection();

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(ADD_EQUATION);

            preparedStatement.setString(1, equation.getEquation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Error occurs in sql query: {}", e.getErrorCode());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static WriterService getInstance() {
        if (instance == null) {
            instance = new WriterService();
        }
        return instance;
    }
}
