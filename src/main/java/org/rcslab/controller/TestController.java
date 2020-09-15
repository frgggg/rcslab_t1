package org.rcslab.controller;

import org.rcslab.entity.RowColAnswer;
import org.rcslab.entity.RowColRequest;
import org.rcslab.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TestController {

    private TestService service;

    @Autowired
    protected TestController(TestService service) {
        this.service = service;
    }

    @GetMapping
    public List<RowColAnswer> rowColQuery(
            @RequestParam(name = "row", required = true) Character row,
            @RequestParam(name = "col", required = true) Character col
    ) {
        service.execRowColRequest(
                new RowColRequest(row, col)
        );
        return service.execRowColRequest(
                new RowColRequest(row, col)
        );
    }
}
