package cn.csbit.repository;

import cn.csbit.model.DataSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Answer on 16/7/1.
 */
@Repository
public interface DataSourceDao extends PagingAndSortingRepository<DataSource, Integer> {
}
