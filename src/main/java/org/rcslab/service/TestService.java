package org.rcslab.service;

import org.rcslab.entity.RowColAnswer;
import org.rcslab.entity.RowColRequest;
import java.util.List;

public interface TestService {
    List<RowColAnswer> execRowColRequest(RowColRequest request);
}
