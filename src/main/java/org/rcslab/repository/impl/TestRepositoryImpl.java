package org.rcslab.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.rcslab.entity.RowColAnswer;
import org.rcslab.entity.RowColRequest;
import org.rcslab.exception.ServiceException;
import org.rcslab.repository.TestRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TestRepositoryImpl implements TestRepository {

    private static final String ROW_COL_REQUEST = "SELECT %s as row, %s as col, COUNT(*) as val FROM source_data GROUP BY %s, %s";

    @Value("${sqlite.path}")
    private String connectionString;
    private Connection connection = null;

    @Override
    public synchronized List<RowColAnswer> execRowColRequest(RowColRequest request) {
        if(connection == null) {
            throw new ServiceException("no connection with db");
        }

        ArrayList<RowColAnswer> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(
                    String.format(
                            ROW_COL_REQUEST, request.getRow(), request.getCol(), request.getRow(), request.getCol()
                    )
            );

            while (resultSet.next()) {
                list.add(
                        new RowColAnswer(
                                resultSet.getString("row"),
                                resultSet.getString("col"),
                                Integer.valueOf(resultSet.getString("val"))
                        )
                );
            }

        } catch (SQLException e) {
            throw new ServiceException(e);
        }

        return list;
    }

    @PreDestroy
    public void preDestroy() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new ServiceException(e);
            }
        }
    }

    @PostConstruct
    public void postConstruct() {
        log.info("connectionString = " + connectionString);
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(connectionString);
            } catch (SQLException e) {
                connection = null;
                throw new ServiceException(e);
            }
        }
    }
}
