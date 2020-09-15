package org.rcslab.repository;

import org.rcslab.entity.RowColAnswer;
import org.rcslab.entity.RowColRequest;

import java.util.List;

//@Repository
public interface TestRepository /*extends CrudRepository<TestDbEntity, Integer>*/ {
    List<RowColAnswer> execRowColRequest(RowColRequest request);

    //@Query(value = "select a, b, c, d, y, v, ROW_NUMBER() as Id from source_data where Id = 1", nativeQuery = true)
    //String getFirst();
}
