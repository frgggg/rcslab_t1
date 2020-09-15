package org.rcslab.service.impl;

import org.rcslab.entity.RowColAnswer;
import org.rcslab.entity.RowColRequest;
import org.rcslab.entity.TestDbEntity;
import org.rcslab.exception.ServiceException;
import org.rcslab.repository.TestRepository;
import org.rcslab.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TestServiceImpl implements TestService {

    private Validator validator;
    private TestRepository repository;

    @Autowired
    public TestServiceImpl(TestRepository repository, Validator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public List<RowColAnswer> execRowColRequest(RowColRequest request) {
        Set<ConstraintViolation<RowColRequest>> constraintViolations = validator.validate(request);
        if(!constraintViolations.isEmpty()) {
            throw new ServiceException(constraintViolations.iterator().next().getMessage());
        }

        return repository.execRowColRequest(request);
    }
}
